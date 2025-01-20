package uiMain;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		while (opcion != 6) {
			System.out.println("Bienvenido a la veterinaria virtual.");
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("\n1. (Funcionalidad 1)");
            System.out.println("2. (Funcionalidad 2)");
            System.out.println("3. (Funcionalidad 3)");
            System.out.println("4. (Funcionalidad 4)");
            System.out.println("5. (Funcionalidad 5)");
            System.out.println("6. Salir");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
            	case 1:
            		System.out.println("Bienvenido a la funcionalidad 1.");
            		break;
            	case 2:
            		System.out.println("Bienvenido a la funcionalidad 2.");
            		break;
            	case 3:
            		System.out.println("Bienvenido a la funcionalidad 3.");
            		break;
            	case 4:
            		System.out.println("Bienvenido a la funcionalidad 4.");
            		break;
            	case 5:
            		System.out.println("Bienvenido a la funcionalidad 5.");
            		break;
            	case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
            	default:
            		System.out.println("Opción no válidad. Por favor, intente de nuevo.\n");
            }
            
		}
		sc.close();
	}
}