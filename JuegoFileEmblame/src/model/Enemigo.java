package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Enemigo {

	Scanner sc = new Scanner(System.in);

	private String nombreEnemigo;
	private int ataqueEnemigo;
	private int vidaEnemigo;
	private Destreza destreza;
	private int defensaEnemigo;

	public Enemigo(String nombreEnemigo, int ataqueEnemigo, int vidaEnemigo, Destreza destreza, int defensaEnemigo) {
		super();
		this.nombreEnemigo = nombreEnemigo;
		this.ataqueEnemigo = ataqueEnemigo;
		this.vidaEnemigo = vidaEnemigo;
		this.destreza = destreza;
		this.defensaEnemigo = defensaEnemigo;

	}

	public Enemigo() {

	}

	public String getNombreEnemigo() {
		return nombreEnemigo;
	}

	public void setNombreEnemigo(String nombreEnemigo) {
		this.nombreEnemigo = nombreEnemigo;
	}

	public int getAtaqueEnemigo() {
		return ataqueEnemigo;
	}

	public void setAtaqueEnemigo(int ataqueEnemigo) {
		this.ataqueEnemigo = ataqueEnemigo;
	}

	public int getVidaEnemigo() {
		return vidaEnemigo;
	}

	public void setVidaEnemigo(int vidaEnemigo) {
		this.vidaEnemigo = vidaEnemigo;
	}

	public Destreza getDestreza() {
		return destreza;
	}

	public void setDestreza(Destreza destreza) {
		this.destreza = destreza;
	}

	public int getDefensaEnemigo() {
		return defensaEnemigo;
	}

	public void setDefensaEnemigo(int defensaEnemigo) {
		this.defensaEnemigo = defensaEnemigo;
	}

	public List<String> arrayEnemigos() {

		List<String> enemigos = new ArrayList<>();
		enemigos.add("kuk");
		enemigos.add("Loki");
		enemigos.add("Fenrir");
		enemigos.add("Hel");
		enemigos.add("Demonio");

		return enemigos;

	}

	public void elegirEnemigos() {
		int eleccion = 0;

		System.out.println("Ingrese su nombre:");
		String nombre = sc.nextLine();
		Estudiante es = new Estudiante(nombre, Casa.AGUILAS_NEGRAS, Destreza.DESTREZA_FUERTE, 1);
		Enemigo en = new Enemigo(nombreEnemigo, ataqueEnemigo, vidaEnemigo, destreza, defensaEnemigo);
		int nivelUsuario = es.getNivel();
		int ataque = en.getAtaqueEnemigo();
		int vida = en.getVidaEnemigo();
		int defensa = es.getDefensa();
		es.elegirPersonaje();
		do {
			System.out.println("Elija entre 2 y 5 enemigos:");
			eleccion = sc.nextInt();
			sc.nextLine();
		} while (eleccion < 2 || eleccion > 5);

		List<String> enemigos = arrayEnemigos(); // Lista de enemigos disponibles
		List<String> seleccionados = new ArrayList<>(); // Lista de enemigos elegidos

		System.out.println("Enemigos seleccionados:");
		for (int i = 0; i < eleccion; i++) { // Seleccionar los primeros 'eleccion' enemigos
			seleccionados.add(enemigos.get(i));
			System.out.println("- " + enemigos.get(i));
		}

		// Seleccionar un enemigo al azar de los elegidos
		Random random = new Random();
		String enemigoAleatorio = seleccionados.get(random.nextInt(seleccionados.size()));

		System.out.println("\n¡Enemigo aleatorio elegido!: " + enemigoAleatorio);

		// Determinar la casa y destreza según el enemigo seleccionado
		if (seleccionados.contains(enemigos.get(2)) || seleccionados.contains(enemigos.get(4))) {

			destreza = Destreza.DESTREZA_DEBIL;
			puntuaciones(nivelUsuario, vida, ataque, defensa);

		} else if (seleccionados.contains(enemigos.get(1))) {

			destreza = Destreza.DESTREZA_FUERTE;
			puntuaciones(nivelUsuario, vida, ataque, defensa);

		} else {

			destreza = Destreza.DESTREZA_DEBIL;
			puntuaciones(nivelUsuario, vida, ataque, defensa);

		}

		// Mostrar información de la casa
		System.out.println("******Tus puntos*************");
		destreza.descripcion();
		combate(es, enemigoAleatorio, en);

		/*
		 * EXPLICACION GET() ==> * get= El método get() se utiliza para acceder a un
		 * atributo privado de una clase y devolver su valor. Es fundamental para
		 * aplicar el principio de encapsulamiento en la programación orientada a
		 * objetos, ya que te permite controlar cómo se acceden a los datos dentro de
		 * una clase. Aunque puedes acceder a los atributos directamente si los haces
		 * públicos, es mejor práctica usar el enfoque de getter (y setter si es
		 * necesario) para tener más control sobre el acceso y manipulación de los
		 * datos. Esto facilita la mantenibilidad y la seguridad del código en proyectos
		 * más grandes.
		 */

	}

	public void puntuaciones(int nivelUsuario, int vida, int ataque, int defensa) {
		Destreza debil = Destreza.DESTREZA_DEBIL;

		if (destreza == debil) {
			nivelUsuario += 1;
			vidaEnemigo += 5;
			ataqueEnemigo += 2;
			defensaEnemigo += 1;
		} else {
			nivelUsuario += 2;
			vidaEnemigo += 8;
			ataqueEnemigo += 3;
			defensaEnemigo += 2;
		}
		System.out.println("********Punto de partida**************************************** ");
		System.out.println("Nivel actual: " + nivelUsuario + " Vida enemigo: " + vidaEnemigo + " Ataque enemigo "
				+ ataqueEnemigo + " Defensa: " + defensaEnemigo);
	}

	public void combate(Estudiante es, String enemigoAleatorio, Enemigo en) {
		Random rd = new Random();
		int vidaUsuario = destreza.getVida();
		int nivel = es.getNivel();

		System.out.println(" ");
		System.out.println("¡ATACAMOS!!!");

		// El estudiante ataca tres veces

		es.atacar(en);
		es.atacar(en);
		es.atacar(en);
		vidaUsuario += rd.nextInt(2) + 1;
		System.out.println("Vida del estudiante: " + vidaUsuario + " | Vida del enemigo: " + vidaEnemigo);

		turnoEnemigo(en, vidaEnemigo, vidaUsuario);

		System.out.println("VAMOS!!! ATAQUEMOS!");
		es.atacar(en);
		es.atacar(en);
		es.atacar(en);
		vidaUsuario += rd.nextInt(2) + 1;

		subirNivel(es, nivel);
		nivel = es.getNivel();
		nivel = rd.nextInt(15) - 1;
		if (nivel >= 10) {

			System.out.println("¡Has alcanzado el nivel máximo! Nivel: " + nivel);

		}

		if (vidaEnemigo <= 0) {
			System.out.println("¡Has matado al enemigo en el  nivel: " + nivel + " !");
		}

		if (es.getVida() <= 0) {
			System.out.println("El estudiante ha sido derrotado...");
		} else if (destreza.getVida() <= 0) {
			System.out.println("¡El enemigo ha sido derrotado!");
		}

		// Mostrar la información final del combate
		informacionEnemigosAtaque(enemigoAleatorio, vidaEnemigo, es, vidaUsuario, nivel);
	}

	public void subirNivel(Estudiante es, int nivel) {

		// Aumenta el nivel del estudiante
		nivel = es.getNivel();
		es.setNivel(nivel + 1);

		// Se cura al estudiante, pasando la vida máxima (no la vida actual)
		curar(10, es.getVidaMaxima(), es); // Aquí usamos getVidaMaxima() para no superar la vida máxima

	}

	public void curar(int puntos, int vidaMaxima, Estudiante es) {
		// Aumenta la vida del estudiante
		int nuevaVida = es.getVida() + puntos;

		// Si la nueva vida supera la vida máxima, la limitamos a la vida máxima
		if (nuevaVida > vidaMaxima) {
			nuevaVida = vidaMaxima;
		}

		// Actualiza la vida del estudiante
		es.setVida(nuevaVida);
	}

	public void informacionEnemigosAtaque(String enemigo, int vidaEnemigo, Estudiante es, int vida, int nivel) {
		int ataque = es.getAtaque();
		int defensa = es.getDefensa();

		String info = "Vida del estudiante: " + vida + "\n " +

				enemigo + " con vida:" + vidaEnemigo + " ataque: " + ataqueEnemigo + " defensa: " + defensaEnemigo
				+ "\n******************************************Tu puntuacion final" + "\nvida: " + vida + "+ataque: "
				+ ataque + "defensa:" + defensa + "nivel: " + nivel;

		System.out.println(info);
		guardarEnArchivo(info);

	}

	public void guardarEnArchivo(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println("quieres exportar la partida");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("si")) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					"/Users/laurahigueraromero/Desktop/CarpetasEscritorio/nebrija/ejercicioIndividual_Fran/partidasGuaradas/partidas.txt",
					true))) {
				writer.write(mensaje);
				writer.newLine(); // Agregar una línea en blanco para separar registros
				writer.write("----------------------------------------------------\n");
				System.out.println("partida guardada!");
			} catch (IOException e) {
				System.out.println("Error al guardar el archivo: " + e.getMessage());
			}
		}
	}

	// Método principal que genera y guarda el mensaje

	public void turnoEnemigo(Enemigo enemigoAleatorio, int vidaEnemigo, int vidaAtacada) {
		Random rd = new Random();
		int vida = destreza.getVida();
		System.out.println("OH NO! nos atacan!!!!!!!");
		enemigoAleatorio.getAtaqueEnemigo();
		vidaEnemigo += rd.nextInt(20) + 1;
		if (this.vidaEnemigo <= 0) {
			System.out.println("¡" + this.nombreEnemigo + " ha sido derrotado!");
			return;
		}

		System.out.println("luchando...");
		System.out.println(" ");

		vidaAtacada = vida - rd.nextInt(10) + 1;
		System.out.println("Vida del estudiante: " + vidaAtacada + " | Vida del enemigo: " + vidaEnemigo);

		if (this.vidaEnemigo <= 0) {
			System.out.println(
					"¡" + this.nombreEnemigo + " ha sido derrotado por " + enemigoAleatorio.getNombreEnemigo() + "!");
		}
	}

}
