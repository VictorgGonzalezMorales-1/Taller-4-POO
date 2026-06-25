package logica;

//Importar librerias necesarias
import java.util.Scanner;
import java.io.File;

public class Main {
	
	static Sistema S = SistemaImplementado.getInstance();

	public static void main(String[] args) {
		
		LeerArchivo();

	}

	//Método generado para generar la lectura de archivo
	private static void LeerArchivo() {

		File file = new File("Sobres.txt");
		Scanner lector = null;
		
		try {
			
			lector = new Scanner(file);
			
			while(lector.hasNextLine()) {
				S.TrabajarLinea(lector.nextLine());
			}
			
		}catch(Exception e) {
		}
		
		lector.close();
		
	}
	
	//Método generado para imprimir bonito
	public static void P(String t) {
		System.out.println(t);
	}

}
