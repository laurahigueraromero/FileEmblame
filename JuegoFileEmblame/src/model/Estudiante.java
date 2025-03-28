package model;

import java.util.Random;
import java.util.Scanner;

public class Estudiante {
	private String nombre;
	private Casa casa;
	private Destreza destreza;
	private int vida;
	private int ataque;
	private int defensa;
	private int nivel;
	private int vidaMaxima;

	public Estudiante() {

	}

	public Estudiante(String nombre, Casa casa, Destreza destreza, int vidaMaxima) {
		Random rd = new Random();
		this.nombre = nombre;
		this.casa = casa;
		this.destreza=destreza;
		this.nivel = 1; // Asegura que el nivel siempre comience en 1
		this.vida = rd.nextInt(21) + 40; // Vida entre 40 y 60
		this.ataque = rd.nextInt(6) + 7; // Ataque entre 7 y 12
		this.defensa = rd.nextInt(4) + 4; // Defensa entre 4 y 7
		this.vidaMaxima= vidaMaxima;
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida >= 0)
			this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		if (ataque > 0)
			this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		if (defensa > 0)
			this.defensa = defensa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		if (nivel > 0)
			this.nivel = nivel;
	}
	

	public Destreza getDestreza() {
		return destreza;
	}

	public void setDestreza(Destreza destreza) {
		this.destreza = destreza;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima, int vida) {
		if (vida >= 0 && vida <= vidaMaxima) {
	        this.vida = vida;
	    } else if (vida > vidaMaxima) {
	        this.vida = vidaMaxima; // Limitar vida a vida máxima
	    } else {
	        this.vida = 0; // Si la vida es negativa, ponerla a 0
	    }
	}

	
	public void atacar(Enemigo enemigoAleatorio) {
	    if (enemigoAleatorio.getVidaEnemigo() > 0) {  // Verifica si el enemigo está vivo
	        int dano = Math.max(this.ataque - enemigoAleatorio.getDestreza().getDefensa(), 0); // Evita daño negativo
	        enemigoAleatorio.setVidaEnemigo(enemigoAleatorio.getVidaEnemigo() - dano); // Reducir vida del enemigo

	        System.out.println(this.nombre + " ataca a " + enemigoAleatorio.getNombreEnemigo() + " causando " + dano + " de daño.");
	        System.out.println("Vida restante del enemigo: " + enemigoAleatorio.getVidaEnemigo());

	    } 
	}


	public void imprimirInfo() {
		System.out.println("***************************************************************");
		String personaje = "Estudiante: " + nombre + "\nCasa: " + casa + "\nLema: " + casa.getLema() + "\nVida: " + getVida()
				+ "\nAtaque: " + getAtaque() + "\nDefensa: " + getDefensa();

		System.out.println(personaje);
		System.out.println();
	}

	public void elegirPersonaje() {
		Scanner sc = new Scanner(System.in);
		int personaje;
		do {
			System.out.println(" Elija personaje:");
			System.out.println("1.Elias(casa aguilas)\n2.Eros(casa ciervos)\n3.Athe(casa leones)");
			personaje = sc.nextInt();
			sc.nextLine();

		} while (personaje > 3 || personaje < 1);
		if(personaje==1) {
			casa= Casa.AGUILAS_NEGRAS;
			System.out.println("Casa: " + casa.getNombre());
			System.out.println("Lema: " + casa.getLema());
			imprimirInfo();
			
		}else if(personaje==2) {
			casa = Casa.CIERVOS_DORADOS;
			System.out.println("Casa: " + casa.getNombre());
			System.out.println("Lema: " + casa.getLema());
			
		}else {
			casa = Casa.LEONES_AZULES;
			System.out.println("Casa: " + casa.getNombre());
			System.out.println("Lema: " + casa.getLema());
		}
		
	}

}
