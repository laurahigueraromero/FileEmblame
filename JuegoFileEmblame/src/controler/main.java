package controler;

import java.util.Scanner;

import model.Casa;
import model.Destreza;
import model.Enemigo;
import model.Estudiante;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("      ______________________ ");
		System.out.println("     |                      |");
		System.out.println("     |  FILE EMBLAME        |");
		System.out.println("     |  >_ Loading...       |");
		System.out.println("     |______________________|");
		System.out.println("    /                        \\");
		System.out.println("   |  []                []   |");
		System.out.println("   |      ( )      ( )       |");
		System.out.println("   |          ----           |");
		System.out.println("    \\______________________/");
		System.out.println("       ");
		Enemigo e = new Enemigo();
		e.elegirEnemigos();

	}

}
