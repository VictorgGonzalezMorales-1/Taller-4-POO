package gui;

import logica.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

/**
 * Panel correspondiente a la pestaña Ver Coleccion.
 * Muestra inicialmente las cartas cargadas en el sistema.
 */
public class PanelColeccion extends JPanel {

	private Sistema sistema;
	private DefaultListModel<String> modeloLista;
	private JList<String> listaCartas;

	/**
	 * Constructor del panel de coleccion.
	 *
	 * @param sistema sistema principal de la aplicacion
	 */
	public PanelColeccion(Sistema sistema) {
		this.sistema = sistema;
		crearComponentes();
		ActualizarLista();
	}

	/**
	 * Crea los componentes visuales del panel.
	 */
	private void crearComponentes() {
		setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Ver Coleccion", JLabel.CENTER);

		modeloLista = new DefaultListModel<String>();
		listaCartas = new JList<String>(modeloLista);

		add(titulo, BorderLayout.NORTH);
		add(new JScrollPane(listaCartas), BorderLayout.CENTER);
	}

	/**
	 * Actualiza la lista visual de cartas.
	 */
	public void ActualizarLista() {
		modeloLista.clear();

		String datos = sistema.EntregarOrden("2");
		String[] cartas = datos.split(",");

		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i].length() > 0) {
				modeloLista.addElement(cartas[i]);
			}
		}
	}
}