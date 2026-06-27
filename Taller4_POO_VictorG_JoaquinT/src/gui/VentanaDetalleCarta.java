package gui;

import dominio.Cartas;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Ventana ampliada para visualizar una carta seleccionada.
 * Muestra imagen, atributos y poder calculado mediante Visitor.
 */
public class VentanaDetalleCarta extends JFrame {

	private Cartas carta;
	private int indice;

	/**
	 * Constructor de la ventana de detalle.
	 *
	 * @param carta carta seleccionada
	 * @param indice posicion de la carta dentro de la coleccion
	 */
	public VentanaDetalleCarta(Cartas carta, int indice) {
		this.carta = carta;
		this.indice = indice;

		setTitle("Detalle de carta - " + carta.getNombreCarta());
		setSize(450, 650);
		setLocationRelativeTo(null);

		crearComponentes();
	}

	/**
	 * Crea los componentes visuales de la ventana.
	 */
	private void crearComponentes() {
		setLayout(new BorderLayout());

		JPanel panelImagen = CrearPanelImagen();
		JPanel panelDatos = CrearPanelDatos();

		add(panelImagen, BorderLayout.CENTER);
		add(panelDatos, BorderLayout.SOUTH);
	}

	/**
	 * Crea el panel donde se muestra la imagen ampliada de la carta.
	 *
	 * @return panel con imagen
	 */
	private JPanel CrearPanelImagen() {
		JPanel panel = new JPanel(new BorderLayout());

		ImageIcon icono = GestorImagenes.CrearIconoCarta(carta.getNombreCarta(), 260, 370);

		JLabel labelImagen = new JLabel(icono);
		labelImagen.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(labelImagen, BorderLayout.CENTER);

		return panel;
	}

	/**
	 * Crea el panel donde se muestran los datos de la carta.
	 *
	 * @return panel con informacion de la carta
	 */
	private JPanel CrearPanelDatos() {
		JPanel panel = new JPanel(new GridLayout(1, 1));

		JTextArea areaDatos = new JTextArea();
		areaDatos.setEditable(false);

		String texto = "Indice: " + indice + "\n"
				+ "Nombre: " + carta.getNombreCarta() + "\n"
				+ "Tipo: " + carta.getTipo() + "\n"
				+ "Rareza: " + carta.getRareza() + "\n"
				+ carta.EntregarDatosExtra() + "\n"
				+ "Poder: " + CalcularPoder();

		areaDatos.setText(texto);

		JScrollPane scroll = new JScrollPane(areaDatos);
		panel.add(scroll);

		return panel;
	}

	/**
	 * Calcula el poder de la carta usando VisitorPoder.
	 *
	 * @return poder calculado de la carta
	 */
	private double CalcularPoder() {
		InterfazVisitor visitor = new VisitorPoder();
		carta.Aceptar(visitor);
		return visitor.EntregarResultado();
	}
}