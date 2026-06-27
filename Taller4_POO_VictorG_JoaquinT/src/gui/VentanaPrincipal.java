package gui;

import logica.Sistema;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Ventana principal de la aplicacion.
 * Contiene las dos pestañas solicitadas por el taller:
 * Administracion y Ver Coleccion.
 */
public class VentanaPrincipal extends JFrame {

	private Sistema sistema;
	private PanelAdministracion panelAdministracion;
	private PanelColeccion panelColeccion;

	/**
	 * Constructor de la ventana principal.
	 *
	 * @param sistema sistema principal de la aplicacion
	 */
	public VentanaPrincipal(Sistema sistema) {
		this.sistema = sistema;

		setTitle("Pokemon TCG - Coleccion");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		crearComponentes();
	}

	/**
	 * Crea los componentes principales de la ventana.
	 */
	private void crearComponentes() {
		JTabbedPane pestanas = new JTabbedPane();

		panelAdministracion = new PanelAdministracion(sistema);
		panelColeccion = new PanelColeccion(sistema);

		pestanas.addTab("Administracion", panelAdministracion);
		pestanas.addTab("Ver Coleccion", panelColeccion);

		pestanas.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				panelColeccion.ActualizarLista();
			}
		});

		add(pestanas);
	}
}