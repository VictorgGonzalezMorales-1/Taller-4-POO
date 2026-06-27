package logica;

//Importar librerias necesarias/ Package necesarios
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import dominio.*;
import strategy.*;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

/**
 * Implementacion principal del sistema.
 * Esta clase usa Singleton y administra la memoria de cartas.
 */
public class SistemaImplementado implements Sistema {

	// Generar memoria para guardar los objetos creados
	static LinkedList<Cartas> M = new LinkedList<Cartas>();

	// Variable para almacenar la instancia unica de la clase
	static Sistema S;

	private static final String NOMBRE_ARCHIVO = "Sobres.txt";

	/**
	 * Constructor privado para aplicar Singleton.
	 */
	private SistemaImplementado() {
	}

	/**
	 * Metodo para entregar solo una instancia del Sistema.
	 *
	 * @return instancia unica del sistema
	 */
	public static Sistema getInstance() {
		if (S == null) {
			S = new SistemaImplementado();
		}

		return S;
	}

	@Override
	public void CargarArchivo() {
		M.clear();

		File file = new File(NOMBRE_ARCHIVO);
		Scanner lector = null;

		try {
			lector = new Scanner(file);

			while (lector.hasNextLine()) {
				String linea = lector.nextLine();

				if (linea.length() > 0) {
					TrabajarLinea(linea);
				}
			}

		} catch (Exception e) {
			System.out.println("No se pudo cargar el archivo " + NOMBRE_ARCHIVO);
		}

		if (lector != null) {
			lector.close();
		}
	}

	@Override
	public void GuardarArchivo() {
		PrintWriter escritor = null;

		try {
			escritor = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO));

			for (int i = 0; i < M.size(); i++) {
				escritor.println(M.get(i).FormatoArchivo());
			}

		} catch (IOException e) {
			System.out.println("No se pudo guardar el archivo " + NOMBRE_ARCHIVO);
		}

		if (escritor != null) {
			escritor.close();
		}
	}

	@Override
	public void TrabajarLinea(String l) {
		try {
			Cartas carta = FactoryCartas.CrearCarta(l.split(";"));

			if (carta != null) {
				M.add(carta);
			}

		} catch (RuntimeException e) {
			System.out.println("Linea ignorada: " + l);
		}
	}

	@Override
	public boolean AgregarCarta(String nombre, String rareza, String tipo, String dato1, String dato2) {
		try {
			if (nombre.length() == 0 || rareza.length() == 0 || tipo.length() == 0 || dato1.length() == 0) {
				return false;
			}

			if (tipo.equals("Pokemon") && dato2.length() == 0) {
				return false;
			}

			double rarezaNumero = Double.valueOf(rareza);

			Cartas carta = FactoryCartas.CrearCartaDesdeDatos(nombre, rarezaNumero, tipo, dato1, dato2);

			if (carta != null) {
				M.add(carta);
				GuardarArchivo();
				return true;
			}

		} catch (RuntimeException e) {
			return false;
		}

		return false;
	}

	@Override
	public boolean EliminarCartaPorIndice(int indice) {
		if (indice >= 0 && indice < M.size()) {
			M.remove(indice);
			GuardarArchivo();
			return true;
		}

		return false;
	}

	@Override
	public boolean ModificarCartaPorIndice(int indice, String dato1, String dato2) {
		if (indice >= 0 && indice < M.size()) {
			try {
				if (dato1.length() == 0) {
					return false;
				}

				Cartas carta = M.get(indice);
				carta.ModificarExtras(dato1, dato2);
				GuardarArchivo();
				return true;

			} catch (RuntimeException e) {
				return false;
			}
		}

		return false;
	}

	/**
	 * Metodo el cual dependiendo de la opcion que elijan, ordena los objetos
	 * en base a ese requerimiento.
	 *
	 * @param t tipo de ordenamiento
	 */
	public void Ordenar(String t) {
		InterfazStrategy estrategia = FactoryStrategy.CrearStrategy(t);

		if (estrategia != null) {
			M = estrategia.Ordenar(M);
		}
	}

	@Override
	public String EntregarOrden(String n) {
		Ordenar(n);

		String texto = "";

		for (int a = 0; a < M.size(); a++) {
			texto += a + "-" + M.get(a).getNombreCarta() + ",";
		}

		return texto;
	}

	@Override
	public String buscarCartaPorNombre(String nombre) {
		InterfazVisitor V = new VisitorPoder();

		for (Cartas carta : M) {
			carta.Aceptar(V);

			if (carta.getNombreCarta().equals(nombre)) {
				return carta.toString() + "," + V.EntregarResultado();
			}
		}

		return null;
	}

	@Override
	public String BuscarCartaPorIndice(int indice) {
		if (indice >= 0 && indice < M.size()) {
			InterfazVisitor V = new VisitorPoder();
			Cartas carta = M.get(indice);

			carta.Aceptar(V);

			return carta.toString() + "," + V.EntregarResultado();
		}

		return null;
	}

	@Override
	public void EliminarObjetoConNombre(String nombre) {
		for (int i = 0; i < M.size(); i++) {
			if (M.get(i).getNombreCarta().equals(nombre)) {
				M.remove(i);
				GuardarArchivo();
				break;
			}
		}
	}

	@Override
	public LinkedList<Cartas> EntregarMemoria() {
		LinkedList<Cartas> copia = new LinkedList<Cartas>();

		for (int i = 0; i < M.size(); i++) {
			copia.add(M.get(i));
		}

		return copia;
	}

	@Override
	public int CantidadCartas() {
		return M.size();
	}
}