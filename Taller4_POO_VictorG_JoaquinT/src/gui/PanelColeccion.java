package gui;

import dominio.Cartas;
import logica.Sistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

import java.util.LinkedList;

/**
 * Panel correspondiente a la pestaña Ver Coleccion.
 * Permite visualizar las cartas, ordenarlas y abrir su detalle ampliado.
 */
public class PanelColeccion extends JPanel {

	private Sistema sistema;
	private JPanel panelCartas;
	private JComboBox<String> comboOrden;

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

		JPanel panelSuperior = new JPanel();

		JLabel titulo = new JLabel("Ver Coleccion");
		comboOrden = new JComboBox<String>(new String[] { "Poder", "Nombre", "Rareza" });
		JButton btnOrdenar = new JButton("Ordenar / Actualizar");

		panelSuperior.add(titulo);
		panelSuperior.add(new JLabel("Ordenar por:"));
		panelSuperior.add(comboOrden);
		panelSuperior.add(btnOrdenar);

		panelCartas = new JPanel();
		panelCartas.setLayout(new GridLayout(0, 4, 10, 10));

		JScrollPane scroll = new JScrollPane(panelCartas);

		add(panelSuperior, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		btnOrdenar.addActionListener(e -> ActualizarLista());
	}

	/**
	 * Actualiza la vista de cartas segun el orden seleccionado.
	 */
	public void ActualizarLista() {
		panelCartas.removeAll();

		String tipoOrden = ObtenerTipoOrden();
		sistema.EntregarOrden(tipoOrden);

		LinkedList<Cartas> cartas = sistema.EntregarMemoria();

		for (int i = 0; i < cartas.size(); i++) {
			Cartas carta = cartas.get(i);
			JButton botonCarta = CrearBotonCarta(carta, i);
			panelCartas.add(botonCarta);
		}

		panelCartas.revalidate();
		panelCartas.repaint();
	}

	/**
	 * Transforma la opcion del combo en la opcion usada por FactoryStrategy.
	 *
	 * @return codigo de estrategia
	 */
	private String ObtenerTipoOrden() {
		String opcion = comboOrden.getSelectedItem().toString();

		if (opcion.equals("Poder")) {
			return "1";
		}

		if (opcion.equals("Nombre")) {
			return "2";
		}

		return "3";
	}

	/**
	 * Crea un boton visual para una carta.
	 *
	 * @param carta carta a mostrar
	 * @param indice posicion de la carta en la coleccion actual
	 * @return boton de carta
	 */
	private JButton CrearBotonCarta(Cartas carta, int indice) {
		JButton boton = new JButton();

		String texto = "<html><center>"
				+ carta.getNombreCarta()
				+ "<br>Tipo: " + carta.getTipo()
				+ "<br>Rareza: " + carta.getRareza()
				+ "</center></html>";

		boton.setText(texto);

		ImageIcon icono = GestorImagenes.CrearIconoCarta(carta.getNombreCarta(), 110, 150);
		boton.setIcon(icono);

		boton.setHorizontalTextPosition(SwingConstants.CENTER);
		boton.setVerticalTextPosition(SwingConstants.BOTTOM);

		boton.setPreferredSize(new Dimension(180, 240));

		boton.addActionListener(e -> AbrirDetalleCarta(carta, indice));

		return boton;
	}

	/**
	 * Abre una ventana ampliada con los datos de la carta seleccionada.
	 *
	 * @param carta carta seleccionada
	 * @param indice posicion de la carta
	 */
	private void AbrirDetalleCarta(Cartas carta, int indice) {
		VentanaDetalleCarta detalle = new VentanaDetalleCarta(carta, indice);
		detalle.setVisible(true);
	}
}