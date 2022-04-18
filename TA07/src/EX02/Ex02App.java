package EX02;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex02App {

	final static double IVA_04 = 1.04;
	final static double IVA_21 = 1.21;

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		// Variables
		Hashtable<String, Double> almacen = new Hashtable<String, Double>();
		ArrayList<String> lista = new ArrayList<>();
		int opcion;
		String producto;
		int cantidad;

		// Programa
		// Creamos el almacen de alimentos
		almacen = crearAlmacen(almacen);

		do {
			System.out.println("Introduce una opcion");
			System.out.println("1- Añadir producto");
			System.out.println("2- Mostrar informacion");
			System.out.println("3- Ver stock");
			System.out.println("0- Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:// Añadir producto
				System.out.println("Introduce un producto");
				producto = sc.next();
				

				if (añadirProducto(almacen, producto.toLowerCase())) {
					System.out.println("Introduce la cantidad");
					cantidad = sc.nextInt();
					for (int i = 0; i < cantidad; i++) {
						lista.add(producto);
					}
				} else {
					System.out.println("Producto incorrecto");
				}

				break;

			case 2: // Mostrar informacion

				mostrarInformacion(almacen, lista);

				break;
			case 3: //Mostrar Stock
				System.out.println(almacen.toString());
				break;

			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcion != 0);

		sc.close();
	}

	private static void mostrarInformacion(Hashtable<String, Double> almacen, ArrayList<String> lista) {

		double precio = 0;
		double precioIVA = 0;

		for (int i = 0; i < lista.size(); i++) {
			// Cogemos el precio segun el producto
			precio += almacen.get(lista.get(i));
		}
		precioIVA = precio * IVA_21;

		// Mostramos la informacion
		System.out.println("****INFORMACION****");
		System.out.println("Precio bruto: " + precio + "€");
		System.out.println("Precio con IVA: " + precioIVA + "€");
		System.out.println("Cantidad de articulos pagados: " + lista.size());
		pagarCliente(precioIVA);

	}

	private static void pagarCliente(double precio) {
		Scanner sc = new Scanner(System.in);
		double efectivo;

		// Pedimos el dinero del cliente
		System.out.print("Introduce el efectivo");
		efectivo = sc.nextDouble();
		System.out.println("Cantidad pagada: " + efectivo + "€");
		if (efectivo < precio) {// Si no llega al precio
			System.out.println("Faltan " + (efectivo - precio) + "€");
		} else {
			System.out.println("El cambio a devolver es " + (efectivo - precio) + "€");
		}

		sc.close();
	}

	private static boolean añadirProducto(Hashtable<String, Double> almacen, String producto) {

		for (int i = 0; i < almacen.size(); i++) {
			if (almacen.containsKey(producto)) { // Comprobamos que el producto este en el stock
				return true;
			}
		}
		return false;

	}

	private static Hashtable<String, Double> crearAlmacen(Hashtable<String, Double> almacen) {

		// Stock
		almacen.put("manzana", 0.50);
		almacen.put("pera", 1.0);
		almacen.put("platano", 1.50);
		almacen.put("melocoton", 2.0);

		return almacen;
	}
}
