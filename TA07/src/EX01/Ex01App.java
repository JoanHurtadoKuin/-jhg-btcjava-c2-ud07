package EX01;

import java.util.Hashtable;
import java.util.Scanner;

public class Ex01App {
	// Scanner Global
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables
		int opcion;
		Hashtable<String, Double> alumnos = new Hashtable<String, Double>();

		do {
			System.out.println("Introduce una opcion");
			System.out.println("1- Crear alumno");
			System.out.println("2- Mostrar alumnos");
			System.out.println("0- Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1: // Añadir alumno
				crearAlumno(alumnos);
				break;

			case 2: // Mostrar Alumnos
				mostrarAlumnos(alumnos);
				break;

			case 0:
				System.out.println("Adiooos!");
				break;

			default:
				System.out.println("ERROR");
			}

		} while (opcion != 0);

		sc.close();
	}

	private static void mostrarAlumnos(Hashtable<String, Double> alumnos) {
		if (alumnos.isEmpty()) {
			System.out.println("No hay alumnos");
		} else {
			System.out.println("****ALUMNOS****");
			System.out.println(alumnos.toString());
			System.out.println("***************");
		}
	}

	private static void crearAlumno(Hashtable<String, Double> alumnos) {

		// Variables
		String nombre;
		int examenes;
		double notas = 0;

		System.out.println("Nombre del alumno");
		nombre = sc.next();
		System.out.println("Cuantos examenes ha realizado?");
		examenes = sc.nextInt();

		for (int i = 0; i < examenes; i++) {
			System.out.println("Introduce la nota del examen " + (i + 1));
			notas += sc.nextDouble();
		}
		;

		alumnos.put(nombre, notas / examenes);

	}

}
