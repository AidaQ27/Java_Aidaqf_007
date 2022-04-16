package ud07;
// Crea una app que calcule la nota media de los alumnos
// Una vez calculada la nota media se guardara esta informacion en un dicc de cada alumno
//Todos estos natos se han de proporcionar por pantalla


import java.util.Hashtable;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int alumnos  = 0;
		
		// Definimos una variable para instanciar el dicc
		Hashtable<Integer, Double> dicc= new Hashtable<Integer, Double>();
		
		Scanner sc = new Scanner(System.in);
		
		// Preguntamos cuantos alumnos queremos introducir
		do {
			System.out.println("Introduce el numero de alumnos: ");
			alumnos = sc.nextInt();
		} while (alumnos <= 0);
		
		
		
		// recorremos la cantidad de alumnos y añadimos las notas
		for (int i = 1 ; i <= alumnos; i++) {
			
			double nota = 0.0;
			double suma = 0.0;
			double media = 0.0;
			
			
			System.out.println("Introduce la nota del alumno " + i + " : ");
			nota = sc.nextDouble();
			suma += nota;
			
			System.out.println("Introduce la nota del alumno " + i + " : ");
			nota = sc.nextDouble();
			suma += nota;
			
			// Hacemos el calculo de la media
			media = suma / 2;
			
			// La añadimos al dicc por clave-valor
			dicc.put(i, media);
		}
		
		sc.close();
		//recorremos el dicc para imprimir
		for (Integer i : dicc.keySet()) {
		      System.out.println("Alumno " + i + ": tiene una media de  " + dicc.get(i));
		    }
	
		//System.out.println(dicc.toString());
	} 
	
	
}
