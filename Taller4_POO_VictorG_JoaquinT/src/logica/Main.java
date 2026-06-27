package logica;

import gui.VentanaPrincipal;

import javax.swing.SwingUtilities;

/**
 * Clase principal del programa.
 * Se encarga de iniciar el sistema y abrir la interfaz grafica.
 */
public class Main {

	static Sistema S = SistemaImplementado.getInstance();

	/**
	 * Metodo principal.
	 *
	 * @param args argumentos de ejecucion
	 */
	public static void main(String[] args) {

		S.CargarArchivo();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				VentanaPrincipal ventana = new VentanaPrincipal(S);
				ventana.setVisible(true);
			}
		});
	}
}