package changeenvironment;

public class EnvironmentVariables {

	/**
     * Retorna o valor da variável de ambiente informada.
     * 
     * @param name nome da variável de ambiente
     * @return o valor da variável ou {@code null} se ela não existir
     */
    public static String getValue(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        return System.getenv(name);
    }

    /**
     * Retorna o valor da variável de ambiente ou um valor padrão caso ela não exista.
     * 
     * @param name nome da variável de ambiente
     * @param defaultValue valor a ser retornado se a variável não existir
     * @return o valor da variável ou o valor padrão
     */
    public static String getValue(String name, String defaultValue) {
        String value = getValue(name);
        return value != null ? value : defaultValue;
    }
	
}
