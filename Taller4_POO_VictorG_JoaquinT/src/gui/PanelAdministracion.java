package gui;

import logica.Sistema;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Panel correspondiente a la pestaña Administracion.
 * Aqui se implementaran las operaciones de agregar, eliminar y modificar cartas.
 */
public class PanelAdministracion extends JPanel {

	private Sistema sistema;

	/**
	 * Constructor del panel de administracion.
	 *
	 * @param sistema sistema principal de la aplicacion
	 */
	public PanelAdministracion(Sistema sistema) {
		this.sistema = sistema;
		crearComponentes();
	}

	/**
	 * Crea la estructura inicial del panel de administracion.
	 */
	private void crearComponentes() {
		setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Administracion de cartas", JLabel.CENTER);

		JPanel panelBotones = new JPanel(new GridLayout(3, 1));

		JButton btnAgregar = new JButton("Agregar Carta");
		JButton btnEliminar = new JButton("Eliminar Carta");
		JButton btnModificar = new JButton("Modificar Carta");

		panelBotones.add(btnAgregar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnModificar);

		add(titulo, BorderLayout.NORTH);
		add(panelBotones, BorderLayout.CENTER);
	}
}