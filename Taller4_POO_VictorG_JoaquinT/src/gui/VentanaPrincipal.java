package gui;

import logica.Sistema;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Ventana principal del programa.
 */
public class VentanaPrincipal extends JFrame {

	private Sistema sistema;
	private PanelAdministracion panelAdministracion;
	private PanelColeccion panelColeccion;

	public VentanaPrincipal(Sistema sistema) {
		this.sistema = sistema;

		setTitle("Pokemon TCG - Coleccion");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		CrearGUI();
	}

	/**
	 * Crea las pestañas principales.
	 */
	private void CrearGUI() {

		JTabbedPane pestanas = new JTabbedPane();

		panelAdministracion = new PanelAdministracion(sistema);
		panelColeccion = new PanelColeccion(sistema);

		pestanas.addTab("Administracion", panelAdministracion);
		pestanas.addTab("Ver Coleccion", panelColeccion);

		pestanas.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				panelColeccion.ActualizarLista();
				panelAdministracion.ActualizarLista();
			}
		});

		add(pestanas);
	}
}