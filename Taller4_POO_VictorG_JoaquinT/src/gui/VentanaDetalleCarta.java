package gui;

import dominio.Cartas;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Ventana que muestra una carta ampliada.
 */
public class VentanaDetalleCarta extends JFrame {

	private Cartas carta;
	private int indice;

	public VentanaDetalleCarta(Cartas carta, int indice) {

		this.carta = carta;
		this.indice = indice;

		setTitle("Detalle de carta - " + carta.getNombreCarta());
		setSize(450, 650);
		setLocationRelativeTo(null);

		crearComponentes();
	}

	/**
	 * Crea los paneles de la ventana.
	 */
	private void crearComponentes() {

		setLayout(new BorderLayout());

		JPanel panelImagen = CrearPanelImagen();
		JPanel panelDatos = CrearPanelDatos();

		add(panelImagen, BorderLayout.CENTER);
		add(new JScrollPane(panelDatos), BorderLayout.SOUTH);
	}

	/**
	 * Crea el panel de imagen.
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
	 * Crea el panel de datos.
	 */
	private JPanel CrearPanelDatos() {

		JPanel panel = new JPanel(new GridLayout(8, 1));

		panel.add(new JLabel("Indice: " + indice));
		panel.add(new JLabel("Nombre: " + carta.getNombreCarta()));
		panel.add(new JLabel("Tipo: " + carta.getTipo()));
		panel.add(new JLabel("Rareza: " + carta.getRareza()));

		String[] extras = carta.EntregarDatosExtra().split("\n");

		for (int i = 0; i < extras.length; i++) {
			panel.add(new JLabel(extras[i]));
		}

		panel.add(new JLabel("Poder: " + CalcularPoder()));

		return panel;
	}

	/**
	 * Calcula el poder usando Visitor.
	 */
	private double CalcularPoder() {

		InterfazVisitor visitor = new VisitorPoder();
		carta.Aceptar(visitor);

		return visitor.EntregarResultado();
	}
}