package changeenvironment;

import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Diretorio {

	public void copiaArquivos(String diretorioOrigem, String diretorioDestino) throws IOException {

		System.out.println(" diretorio" + diretorioOrigem);

		File origem = new File(diretorioOrigem);
		File destino = new File(diretorioDestino);

		if (!origem.exists() || !origem.isDirectory()) {
			throw new IllegalArgumentException("O diretório de origem não existe ou não é um diretório válido.");
		}

		if (!destino.exists()) {
			destino.mkdirs();
		}

		if (!destino.isDirectory()) {
			throw new IllegalArgumentException("O diretório de destino não é um diretório válido.");
		}

		File[] arquivos = origem.listFiles();

		if (arquivos != null) {
			for (File arquivo : arquivos) {
				if (arquivo.isFile()) {
					FileInputStream input = new FileInputStream(arquivo);
					File novoArquivo = new File(destino, arquivo.getName());
					FileOutputStream output = new FileOutputStream(novoArquivo);

					byte[] buffer = new byte[1024];
					int bytesRead;

					while ((bytesRead = input.read(buffer)) > 0) {
						output.write(buffer, 0, bytesRead);
					}

					input.close();
					output.close();
				}
			}
		}
	}

	public Map<Integer, String> listar(String path) {
		Map<Integer, String> diretoriosMap = new HashMap<Integer, String>();
		File diretorio = new File(path);

		if (diretorio.exists() && diretorio.isDirectory()) {
			File[] subdiretorios = diretorio.listFiles(new FileFilter() {
				public boolean accept(File file) {
					return file.isDirectory();
				}
			});

			if (subdiretorios != null) {
				int ordem = 1;
				for (File subdiretorio : subdiretorios) {
					diretoriosMap.put(ordem, subdiretorio.getName());
					ordem++;
				}
			} else {
				System.out.println("O diretório está vazio ou não é um diretório.");
			}
		} else {
			System.out.println("O caminho especificado não existe ou não é um diretório.");
		}

		return diretoriosMap;
	}

	public void close(Closeable arquivo) {

		if (arquivo == null) {
			return;
		}

		try {
			arquivo.close();
		} catch (Exception e) {
			System.out.println("não foi possivel fechar o arquivo");
		}
	}

}
