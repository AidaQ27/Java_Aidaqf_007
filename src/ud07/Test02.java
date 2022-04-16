package ud07;
// Crea una aplicacion que gestione el flujo de ventas de un caja de supermercados
// El programa guardara las cantidades del carrito de compra dentro de una lista
//Mostrara por pantalla: Iva aplicado, preciototalbruto y precio mas iva
//NUmero de articulos
//Cantidad pagada - cambio a devolver

//----Pautas-----
//Crear una lista que contenga el carrito de compra. Que podemos poner en el carrito (articulo + cantidad) -------- CARRITO
// ------- PRODUCTOS SUPERMERCADO FET
//Pedimos por interfaz grafica las cantidades de los productos que pondremos en la cesta
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;



public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Hashtable<String, String> diccSupermercado=new Hashtable<String, String>();
		
		diccSupermercado = crearDicc(); //Articulos y valores  del supermercado
		
		consola(diccSupermercado);
		
	

	}
	
	
	public static Hashtable<String, String> crearDicc(){// Creamos un diccionario con la clave-valor que queremos, en este caso (item-precio)
		
		Hashtable<String, String> dicc=new Hashtable<String, String>();
		
		dicc.put("poma", "2.5");
		dicc.put("pera", "2");
		dicc.put("kiwi", "3");
		dicc.put("platan", "4");
		dicc.put("taronja", "5");
		
		return dicc;

	}
	
	public static void mostrarDiccKey(Hashtable<String, String> dicc) { // Recorremos el diccionario con los articulos 
		System.out.println("Articulos disponibles: ");
		for (String i : dicc.keySet()) {
			System.out.print(i+", ");
		}
	}
	
	public static void consola(Hashtable<String, String> diccSupermercado) {// Pedimos por consola lo que necesitamos
		Scanner sc = new Scanner(System.in);
		String articulo = "";
		String cantidad = "";
		
		Hashtable<String, String> diccCesta=new Hashtable<String, String>();
		Hashtable<String, String> diccRellenador=new Hashtable<String, String>();
	
		do {
			mostrarDiccKey(diccSupermercado); // Recorremos el diccionario
			System.out.println("\n\nIntroduce el articulo que quieres comprar : \n(Introduce 'X' para salir)");
			articulo = sc.nextLine();
			
			if (!articulo.equals("x")) { // si el articulo es diferente a 'x' pregunta por la cantidad
				System.out.println("Introduce la cantidad que deseas comprar de " + articulo + ":");
				cantidad = sc.nextLine();
				diccRellenador =  añadirProductoValor(diccSupermercado, cantidad, articulo);// lo añade al dicc rellenado
				for (String i : diccRellenador.keySet()) {
					diccCesta.put(i, diccRellenador.get(i));
				}
			
			}
		
		}while (!articulo.equals("x")); // Pulsa 'x' para salir del bucle
		System.out.println("-------------");
		
		
		for (String i : diccCesta.keySet()) {
		      System.out.println("Tienes: " + i + " - " + diccCesta.get(i) +  " unidades");
		    }
		System.out.println(diccCesta);
		finalCompra(diccSupermercado, diccCesta);
			
	}
	
	
	public static Hashtable<String, String> añadirProductoValor(Hashtable<String, String> diccSupermercado, String cantidad, String articulo) {
		Scanner sc = new Scanner(System.in);
		
		//si volem introduir a la cesta  necesitarem un lloc d'on agafar estas coses
		Hashtable<String, String> diccCesta=new Hashtable<String, String>();
	
		for (String i : diccSupermercado.keySet()) {//recorre el dicc y si el articulo introducido coincide con el anterior dicc
			if (articulo.equals(i)) {
				diccCesta.put(articulo, cantidad);
				return diccCesta;
			}	
		}
		return diccCesta;
	}
	
	public static Hashtable<String, String> finalCompra(Hashtable<String, String> diccSupermercado, Hashtable<String, String> diccCesta) {
		//diccSupermercado		diccCesta
		// item : preu			item : quantitat
		Scanner sc = new Scanner(System.in);
		
		double total = 0.0;
		double IVA = 21;
		double totalIva = 0.0;
		int totalCompra = 0;
		for(String i : diccCesta.keySet()) {
			for (String x : diccSupermercado.keySet()) {
				if (x.equals(i)) {
					// i = "poma"  ///  diccCesta.get(i) = quantitat
					total += Double.parseDouble(diccCesta.get(i)) * Double.parseDouble(diccSupermercado.get(i));
					totalCompra += Double.parseDouble(diccCesta.get(i));
					
				}
				
			}
			
		}
		// Imprimimos todas las operaciones realizadas
		totalIva = total + (total * IVA / 100);
		System.out.println("El total bruto es : " + total);
		System.out.println("El total más IVA es: " + totalIva);
		System.out.println("Número total de articulos: " + totalCompra);
		System.out.println("Cuanto dinero entrega el cliente? : ");
		double entregado = sc.nextDouble();
		double devolver = entregado - totalIva;
		System.out.println("A devolver al cliente : " + devolver +  "€");
		
		
		
	return diccCesta;
		
		
	}
	
}
