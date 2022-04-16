package ud07;
// Crea una base de datos de 10 articulos para controlar el stock de productos de una tienda por medio de un diccionario (articulo:precio)
// El usuario podrá añadir, por mediode interfaz visual articulos nuevos y cantidades.
// El usuario podrá consultar la informacion almacenada en el dicc referente a un articulo concreto e incluso listar toda la info en el terminal

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable <String, String> stockProductos = new Hashtable <String, String>();
		stockProductos = crearBaseDatos();
		opcionesConsola(stockProductos);
		
	}
	
	public static Hashtable <String, String> crearBaseDatos() {
		Hashtable <String, String> baseDatos = new Hashtable <String, String>();
		baseDatos.put("poma", "1.20");
		baseDatos.put("pera", "1.10");
		baseDatos.put("platan", "0.20");
		baseDatos.put("kiwi", "2.20");
		baseDatos.put("taronja", "3.20");
		baseDatos.put("mandarina", "1.10");
		baseDatos.put("brocoli", "1.50");
		baseDatos.put("pebrot", "1.60");
		baseDatos.put("enciam", "1.70");
		baseDatos.put("tomaquet", "1.50");
		
		return baseDatos;
		
		
	}
	
	public static Hashtable<String, String> afegir(Hashtable<String, String> dicc){
		Scanner sc = new Scanner(System.in);
		System.out.println("Que articulo quieres añadir: ");
		String producto = sc.nextLine();
		System.out.println("Añade el precio: ");
		String precio = sc.nextLine();
		
		dicc.put(producto, precio);
		
		return dicc;
	}
	
	public static void  consultar(Hashtable<String, String> hashtable){
		Scanner sc = new Scanner(System.in);
		System.out.println("Que producto quieres consultar: ");
		String consultado = sc.nextLine();
		for (String i: hashtable.keySet()) {
			if (consultado.equals(i)) {
				System.out.println( "Producto - " + i + "/precio - " + hashtable.get(i)); 
				
			}
			
		}
		
	}
	
	public static void listar(Hashtable<String, String> hashtable){
		for (String i: hashtable.keySet()) {
				System.out.println( "Producto - " + i + "/precio - " + hashtable.get(i)); 
			}
			
		}
	
	public static Hashtable<String, String> borrar(Hashtable<String, String> dicc){
		Scanner sc = new Scanner(System.in);
		System.out.println("Que producto quieres borrar: ");
		String borrado = sc.nextLine();
		for (String x : dicc.keySet()) {
			if (borrado.equals(x)) {
				dicc.remove(x);
				System.out.println("El producto " + x + " ha sido eliminado correctamente");
				break;
			}
			// B-C-D-F-G-H
			// 1-2-3-4-5-6-7  
			// 	
		}
		return dicc;
		
		
		
	}
	

	public static Hashtable opcionesConsola(Hashtable stockProductos) {
		Scanner sc = new Scanner(System.in);
		int controlador = 0;
		do {
			System.out.println(" Añadir " + " Consultar " + " Listar " + "Borrar" +  " Salir ");
			
			String eleccion = "";
			eleccion = sc.nextLine();
		switch (eleccion.toUpperCase()) {
		case "AÑADIR":
			System.out.println("AÑADIR ");
			stockProductos= afegir(stockProductos);
			System.out.println(stockProductos);
			
			break;
		case "CONSULTAR":
			System.out.println("CONSULTAR: ");
			consultar(stockProductos);
			break;
		
		case "LISTAR":
			System.out.println("LISTAR: ");
			listar(stockProductos);
			break;
			
		case "BORRAR":
			System.out.println("BORRAR");
			stockProductos = borrar(stockProductos);
			
			break;
		case "SALIR":
			System.out.println("SALIR ");
			controlador = 1;
			
			break;
	

		default:
			System.out.println("default ");
			break;
		}
			
		}while(controlador == 0);
			
		
		
		
		//stockProductos.put(articulo, precio);
		//System.out.println(stockProductos);
		
		return stockProductos;	
	}
	

		
		
}
	
	
	
	
