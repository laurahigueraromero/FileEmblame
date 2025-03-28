package model;

public enum Casa {
	AGUILAS_NEGRAS("Volemos alto", "Casa de los águilas"), LEONES_AZULES("Oye mi rugido", "Casa de los leones"),
	CIERVOS_DORADOS("No sé que hago aquí", "Casa de los ciervos");

	private final String LEMA;
	private final String NOMBRE;

	private Casa(String lema, String nombre) {
		this.LEMA = lema;
		this.NOMBRE = nombre;
	}

	public String getLema() {
		return LEMA;
	}

	public String getNombre() {
		return NOMBRE;
	}
}
