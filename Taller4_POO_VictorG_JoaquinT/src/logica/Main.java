package logica;

import gui.VentanaPrincipal;

/**
 * Clase principal del programa.
 */
public class Main {

	static Sistema S = SistemaImplementado.getInstance();

	public static void main(String[] args) {

		S.CargarArchivo();
		InterfazUsuario();

	}

	/**
	 * Abre la interfaz grafica.
	 */
	private static void InterfazUsuario() {

		VentanaPrincipal ventana = new VentanaPrincipal(S);
		ventana.setVisible(true);

	}

	/**
	 * Imprime por consola.
	 */
	public static void P(String t) {
		System.out.println(t);
	}
}