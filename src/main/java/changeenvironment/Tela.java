package changeenvironment;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class Tela {

	Scanner scanner;
	
	public Tela(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}
	
	public String ler(String mensagem) {
		
		String texto = null;
		System.out.println(mensagem);

		if (scanner.hasNextLine()) {
			return scanner.nextLine().trim();
		}
		scanner.close();
		return texto;
	}

	public void imprimeLinha() {
		System.out.println(" +=========================================================+ ");
	}

	public void escrever(String texto) {
		System.out.println(texto);
	}
	
	
	public void imprime(Map<Integer, String> diretorios) {
		for (Map.Entry<Integer, String> entry : diretorios.entrySet()) {
			String ordem = String.format("%03d", entry.getKey());
			System.out.println(" " + ordem + "-> " + entry.getValue());
		}
	}
	
}
