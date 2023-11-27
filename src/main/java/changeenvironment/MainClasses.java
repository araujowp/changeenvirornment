package changeenvironment;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MainClasses {

	private static final String OPCOES = "escolha um numero para copiar, C para copiar ou S para sair ";

	private static String escolha = "0";
	private static String diretorioBase;
	private static Tela tela;
	private static String diretorioRaiz;
	private static Map<Integer, String> diretorios;
	private static Diretorio diretorio;

	public static void main(String[] args) {

		diretorioRaiz = null;

		try {
			diretorioRaiz = args[0].replace("\\\\", File.separator);
		} catch (Exception e) {
			System.out.println("Falha ao iniciar a aplicaão verifique se foi passado um diretorio valido");
		}
		diretorioBase = diretorioRaiz;

		diretorios = null;

		tela = new Tela(System.in);
		tela.escrever("bem vindo ao change environment");
		escolha = "0";
		diretorio = new Diretorio();

		do {
			tela.imprimeLinha();

			switch (escolha) {
			case "c":
				copiar();
				break;
			case "s":
				sair();
			default:
				listar();
				break;
			}
			tela.escrever("escolha: " + escolha);
			
		} while (!"s".equals(escolha));
	}

	private static void listar() {

		if (!escolha.equalsIgnoreCase("0")) {
			diretorioBase += File.separator + diretorios.get(Integer.valueOf(escolha));
		}

		diretorios = getDiretorios(diretorioBase, diretorio, tela);
		escolha = tela.ler(OPCOES);

	}

	private static void sair() {
		tela.escrever("sair ");
	}

	private static void copiar() {
		
		escolha = tela.ler("copia ativada escolha um numero para copiar");
		diretorioBase += File.separator + diretorios.get(Integer.valueOf(escolha));
		try {
			diretorio.copiaArquivos(diretorioBase, diretorioRaiz);
		} catch (IOException e) {
			System.out.println("falha ao copiar arquivos " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("arquivos copiados");
	}

	private static Map<Integer, String> getDiretorios(String diretorioBase, Diretorio diretorio, Tela tela) {
		
		System.out.println("diretorio atual " + diretorioBase);
		Map<Integer, String> diretorios = diretorio.listar(diretorioBase);
		tela.imprime(diretorios);
		return diretorios;
	}

}
