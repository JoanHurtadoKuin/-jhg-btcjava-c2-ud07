package EX04;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex04App {

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		// Variables
		Hashtable<String, Double> almacenPrecio = new Hashtable<String, Double>();
		Hashtable<String, Integer> almacenStock = new Hashtable<String, Integer>();
		int opcion;
		String producto;
		double precio;
		int cantidad;
		ArrayList<String> lista = new ArrayList<>();

		// Programa

		crearAlmacenStock(almacenStock);
		crearAlmacenPrecio(almacenPrecio);

		do {
			System.out.println("Introduce una opcion");
			System.out.println("1- Añadir producto");
			System.out.println("2- Eliminar producto");
			System.out.println("3- Ver stock");
			System.out.println("0- Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:// Añadir producto
				System.out.println("Introduce el nombre del producto");
				producto = sc.next();
				System.out.println("Introduce el precio de " + producto);
				precio = sc.nextDouble();
				System.out.println("Introduce la cantidad de " + producto);
				cantidad = sc.nextInt();

				añadirProductoPrecio(almacenPrecio, producto, precio);
				añadirProductoStock(almacenStock, producto, cantidad);

				break;

			case 2: // Eliminar producto
				System.out.println("Introduce el nombre del producto");
				producto = sc.next();
				eliminarProductoPrecio(almacenPrecio, producto);
				eliminarProductoStock(almacenStock, producto);

				break;
			case 3: // Mostrar Almacen

				System.out.println(almacenStock);

				break;

			case 4: // Añadir producto lista
				System.out.println("Introduce el producto");
				producto = sc.next();
				if (añadirProducto(almacenPrecio, producto.toLowerCase())) {
					System.out.println("Introduce la cantidad");
					cantidad = sc.nextInt();
					for (int i = 0; i < cantidad; i++) {
						lista.add(producto);
					}
				} else {
					System.out.println("Producto incorrecto");
				}
				break;
				
			case 5: //Mostrar informacion
				mostrarInformacion(almacenPrecio, lista);

			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opcion != 0);

		sc.close();

		// Rellenamos el stock

	}

	private static Hashtable<String, Double> añadirProductoPrecio(Hashtable<String, Double> almacenPrecio,
			String producto, Double precio) {

		// Stock
		almacenPrecio.put(producto, precio);

		return almacenPrecio;
	}

	private static Hashtable<String, Integer> añadirProductoStock(Hashtable<String, Integer> almacenPrecio,
			String producto, int cantidad) {

		// Stock
		almacenPrecio.put(producto, cantidad);

		return almacenPrecio;
	}

	private static Hashtable<String, Double> crearAlmacenPrecio(Hashtable<String, Double> almacenPrecio) {

		// Stock
		almacenPrecio.put("manzana", 2.0);
		almacenPrecio.put("pera", 1.0);
		almacenPrecio.put("platano", 1.50);
		almacenPrecio.put("melocoton", 2.0);
		almacenPrecio.put("cereza", 0.50);
		almacenPrecio.put("mandarina", 1.0);
		almacenPrecio.put("uva", 1.50);
		almacenPrecio.put("sandia", 2.0);
		almacenPrecio.put("piña", 1.50);
		almacenPrecio.put("limon", 2.0);

		return almacenPrecio;
	}

	private static Hashtable<String, Integer> crearAlmacenStock(Hashtable<String, Integer> almacenPrecio) {

		// Stock
		almacenPrecio.put("manzana", 2);
		almacenPrecio.put("pera", 1);
		almacenPrecio.put("platano", 13);
		almacenPrecio.put("melocoton", 20);
		almacenPrecio.put("cereza", 50);
		almacenPrecio.put("mandarina", 30);
		almacenPrecio.put("uva", 10);
		almacenPrecio.put("sandia", 20);
		almacenPrecio.put("piña", 10);
		almacenPrecio.put("limon", 20);

		return almacenPrecio;
	}

	private static Hashtable<String, Integer> eliminarProductoStock(Hashtable<String, Integer> almacenPrecio,
			String producto) {

		// Stock
		almacenPrecio.remove(producto);

		return almacenPrecio;
	}

	private static Hashtable<String, Double> eliminarProductoPrecio(Hashtable<String, Double> almacenPrecio,
			String producto) {

		// Stock
		almacenPrecio.remove(producto);

		return almacenPrecio;
	}

	private static void mostrarInformacion(Hashtable<String, Double> almacen, ArrayList<String> lista) {

		double precio = 0;
		double precioIVA = 0;

		for (int i = 0; i < lista.size(); i++) {
			// Cogemos el precio segun el producto
			precio += almacen.get(lista.get(i));
		}
		precioIVA = precio * 1.21;

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
}
