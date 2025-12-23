package changeenvironment;

public enum TipoBancoDados {

	MSSQLSERVER((byte) 1), //
	ORACLE((byte) 2), //
	MSACESS((byte) 3), //
	MYSQL((byte) 4), //
	POSTGRES((byte) 5), //
	JMSACESS((byte) 6), //
	IBM_DB2((byte) 7), //
	IBM_DB2_AS400((byte) 8), //
	PDF((byte) 9);

	private final byte tipo;

	TipoBancoDados(byte pTipo) {
		tipo = pTipo;
	}

	public byte getTipo() {
		return tipo;
	}

	public static TipoBancoDados getById(byte id) {
		for (TipoBancoDados tipo : values()) {
			if (tipo.getTipo() == id) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Tipo inválido: " + id);
	}
}