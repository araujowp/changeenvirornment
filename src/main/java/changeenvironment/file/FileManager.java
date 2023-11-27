package changeenvironment.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

	
	public static String getLocalPath() {
		return System.getProperty("user.dir");
	}
	
	
    public static String getFirstLine(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String primeiraLinha = br.readLine();
            return primeiraLinha;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	
}
