package changeenvironment.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadConf {

	private String path;

	public ReadConf(String path) {
		this.path = path;
	}
	
	public String getTag(String tagDescription) {
		if (tagDescription == null) {
            return null;
        }
        String tag = tagDescription.trim();
        if (tag.isEmpty()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty() || linha.startsWith("#") || linha.startsWith(";")) {
                    continue;
                }

                if (linha.startsWith(tag + "=")) {
                    String valor = linha.substring(tag.length() + 1).trim();
                    return valor;
                }

                int indexIgual = linha.indexOf('=');
                if (indexIgual != -1) {
                    String chave = linha.substring(0, indexIgual).trim();
                    if (chave.equals(tag)) {
                        String valor = linha.substring(indexIgual + 1).trim();
                        return valor;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de configuração: " + path);
            e.printStackTrace();
        }

        return null;
	}

	
	public static void main(String[] args) {
		
		String caminho = "C:/visualmix/config/vm_av_adm.conf";
		
		ReadConf readConf = new ReadConf(caminho);
		System.out.println(readConf.getTag("DEFAULT.TIPOCONEXAO"));
		System.out.println(readConf.getTag("CLIENTE"));
		System.out.println(readConf.getTag("AMBIENTE"));
		
	}
	
}
