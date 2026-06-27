package gui;

import dominio.Cartas;
import logica.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

/**
 * Panel correspondiente a la pestaña Administracion.
 * Permite agregar cartas nuevas a la coleccion.
 */
public class PanelAdministracion extends JPanel {

	private Sistema sistema;

	private JTextField txtNombre;
	private JTextField txtRareza;
	private JComboBox<String> comboTipo;
	private JTextField txtDato1;
	private JTextField txtDato2;

	private JLabel lblDato1;
	private JLabel lblDato2;

	private DefaultListModel<String> modeloLista;
	private JList<String> listaCartas;

	/**
	 * Constructor del panel de administracion.
	 *
	 * @param sistema sistema principal de la aplicacion
	 */
	public PanelAdministracion(Sistema sistema) {
		this.sistema = sistema;
		crearComponentes();
		ActualizarLista();
	}

	/**
	 * Crea los componentes visuales del panel.
	 */
	private void crearComponentes() {
		setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Administracion de cartas", JLabel.CENTER);

		JPanel panelFormulario = CrearPanelFormulario();

		modeloLista = new DefaultListModel<String>();
		listaCartas = new JList<String>(modeloLista);

		add(titulo, BorderLayout.NORTH);
		add(panelFormulario, BorderLayout.WEST);
		add(new JScrollPane(listaCartas), BorderLayout.CENTER);
	}

	/**
	 * Crea el formulario usado para agregar cartas.
	 *
	 * @return panel con formulario
	 */
	private JPanel CrearPanelFormulario() {
		JPanel panelFormulario = new JPanel(new GridLayout(9, 2));

		txtNombre = new JTextField();
		txtRareza = new JTextField();
		comboTipo = new JComboBox<String>(new String[] { "Pokemon", "Item", "Supporter", "Energy" });
		txtDato1 = new JTextField();
		txtDato2 = new JTextField();

		lblDato1 = new JLabel("Daño:");
		lblDato2 = new JLabel("Cantidad energias:");

		JButton btnAgregar = new JButton("Agregar Carta");
		JButton btnEliminar = new JButton("Eliminar Carta");
		JButton btnModificar = new JButton("Modificar Carta");
		JButton btnActualizar = new JButton("Actualizar Lista");

		panelFormulario.add(new JLabel("Nombre:"));
		panelFormulario.add(txtNombre);

		panelFormulario.add(new JLabel("Rareza:"));
		panelFormulario.add(txtRareza);

		panelFormulario.add(new JLabel("Tipo:"));
		panelFormulario.add(comboTipo);

		panelFormulario.add(lblDato1);
		panelFormulario.add(txtDato1);

		panelFormulario.add(lblDato2);
		panelFormulario.add(txtDato2);

		panelFormulario.add(btnAgregar);
		panelFormulario.add(btnActualizar);

		panelFormulario.add(btnEliminar);
		panelFormulario.add(btnModificar);

		panelFormulario.add(new JLabel(""));
		panelFormulario.add(new JLabel("Eliminar y modificar se completan en Commit 9"));

		comboTipo.addActionListener(e -> ActualizarEtiquetasTipo());

		btnAgregar.addActionListener(e -> AgregarCarta());

		btnActualizar.addActionListener(e -> ActualizarLista());

		btnEliminar.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Eliminar carta se implementara en el Commit 9.");
		});

		btnModificar.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Modificar carta se implementara en el Commit 9.");
		});

		ActualizarEtiquetasTipo();

		return panelFormulario;
	}

	/**
	 * Cambia las etiquetas del formulario dependiendo del tipo de carta.
	 */
	private void ActualizarEtiquetasTipo() {
		String tipo = comboTipo.getSelectedItem().toString();

		if (tipo.equals("Pokemon")) {
			lblDato1.setText("Daño:");
			lblDato2.setText("Cantidad energias:");
			txtDato2.setEnabled(true);
		} else if (tipo.equals("Item")) {
			lblDato1.setText("Bonificacion:");
			lblDato2.setText("No usado:");
			txtDato2.setText("");
			txtDato2.setEnabled(false);
		} else if (tipo.equals("Supporter")) {
			lblDato1.setText("Efectos por turno:");
			lblDato2.setText("No usado:");
			txtDato2.setText("");
			txtDato2.setEnabled(false);
		} else if (tipo.equals("Energy")) {
			lblDato1.setText("Elemento:");
			lblDato2.setText("No usado:");
			txtDato2.setText("");
			txtDato2.setEnabled(false);
		}
	}

	/**
	 * Agrega una carta usando los datos ingresados en el formulario.
	 */
	private void AgregarCarta() {
		String nombre = txtNombre.getText();
		String rareza = txtRareza.getText();
		String tipo = comboTipo.getSelectedItem().toString();
		String dato1 = txtDato1.getText();
		String dato2 = txtDato2.getText();

		if (nombre.length() == 0) {
			JOptionPane.showMessageDialog(this, "Debes ingresar el nombre de la carta.");
			return;
		}

		if (rareza.length() == 0) {
			JOptionPane.showMessageDialog(this, "Debes ingresar la rareza.");
			return;
		}

		if (dato1.length() == 0) {
			JOptionPane.showMessageDialog(this, "Debes ingresar el dato principal de la carta.");
			return;
		}

		if (tipo.equals("Pokemon") && dato2.length() == 0) {
			JOptionPane.showMessageDialog(this, "Las cartas Pokemon requieren cantidad de energias.");
			return;
		}

		boolean agregada = sistema.AgregarCarta(nombre, rareza, tipo, dato1, dato2);

		if (agregada) {
			JOptionPane.showMessageDialog(this, "Carta agregada correctamente.");
			LimpiarFormulario();
			ActualizarLista();
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo agregar la carta. Revisa los datos ingresados.");
		}
	}

	/**
	 * Limpia los campos del formulario despues de agregar una carta.
	 */
	private void LimpiarFormulario() {
		txtNombre.setText("");
		txtRareza.setText("");
		txtDato1.setText("");
		txtDato2.setText("");
		comboTipo.setSelectedItem("Pokemon");
		ActualizarEtiquetasTipo();
	}

	/**
	 * Actualiza la lista de cartas mostrada en la pestaña Administracion.
	 */
	public void ActualizarLista() {
		modeloLista.clear();

		LinkedList<Cartas> cartas = sistema.EntregarMemoria();

		for (int i = 0; i < cartas.size(); i++) {
			Cartas carta = cartas.get(i);

			modeloLista.addElement(
					i + " - " +
					carta.getNombreCarta() +
					" - " +
					carta.getTipo() +
					" - Rareza: " +
					carta.getRareza()
			);
		}
	}
}