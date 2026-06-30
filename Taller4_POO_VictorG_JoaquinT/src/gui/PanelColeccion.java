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
 * Panel donde se muestra la coleccion.
 */
public class PanelColeccion extends JPanel {

	private Sistema sistema;
	private JPanel panelCartas;
	private JComboBox<String> comboOrden;

	public PanelColeccion(Sistema sistema) {
		this.sistema = sistema;
		crearComponentes();
		ActualizarLista();
	}

	/**
	 * Crea los componentes del panel.
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
	 * Actualiza las cartas mostradas.
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
	 * Retorna el numero de estrategia.
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
	 * Crea el boton de una carta.
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
	 * Abre la ventana de detalle.
	 */
	private void AbrirDetalleCarta(Cartas carta, int indice) {

		VentanaDetalleCarta detalle = new VentanaDetalleCarta(carta, indice);
		detalle.setVisible(true);
	}
}