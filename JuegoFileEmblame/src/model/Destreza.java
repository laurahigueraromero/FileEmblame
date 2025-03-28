package model;

public enum Destreza {

	DESTREZA_DEBIL(30, 8, 2), DESTREZA_FUERTE(50, 10, 4);

	private final int vida;
	private final int ataque;
	private final int defensa;

	private Destreza(int vida, int ataque, int defensa) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void descripcion() {

		System.out.println("Vida: " + getVida());
		System.out.println("Ataque: " + getAtaque());
		System.out.println("Defensa: " + getDefensa());
	}

}
