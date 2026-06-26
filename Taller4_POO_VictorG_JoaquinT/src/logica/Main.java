package logica;

//Importar librerias necesarias
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

public class Main {

	static Sistema S = SistemaImplementado.getInstance();
	static JFrame menu;

	public static void main(String[] args) {

		LeerArchivo();
		InterfazUsuario();

	}

	private static void InterfazUsuario() {

		menu = new JFrame("MateoGodoyBuscaNovia");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(400, 500);
		menu.getContentPane().add(CrearGUI());
		menu.setVisible(true);

	}

	private static void CambiarPantalla(JPanel nuevoPanel) {

		menu.getContentPane().removeAll();
		menu.getContentPane().add(nuevoPanel);
		menu.revalidate();
		menu.repaint();

	}

	private static JPanel CrearGUI() {

		JPanel menuInicial = new JPanel(new GridLayout(1, 1));
		JPanel panelBotones = new JPanel(new GridLayout(2, 1));

		JButton administracion = new JButton("Administración");
		JButton colecciones = EntrarPanelPoder("Estrategia de Ordenamiento");
		;

		panelBotones.add(administracion);
		panelBotones.add(colecciones);

		menuInicial.add(panelBotones);

		return menuInicial;
	}

	private static JButton EntrarPanelPoder(String t) {

		JButton click = new JButton(t);
		click.addActionListener(e -> {

			CambiarPantalla(CrearPanelDePoder());

		});

		return click;

	}

	private static JPanel CrearPanelDePoder() {

		JPanel menuPoder = new JPanel(new GridLayout(1, 1));
		JPanel panelOrden = new JPanel(new GridLayout(4, 1));

		JButton Poder = EntregarOrden("1", "Poder");
		JButton Nombre = EntregarOrden("2", "Nombre");
		JButton Rareza = EntregarOrden("3", "Rareza");
		JButton Regresar = VolverAlMenuInicial();

		panelOrden.add(Poder);
		panelOrden.add(Nombre);
		panelOrden.add(Rareza);
		panelOrden.add(Regresar);

		menuPoder.add(panelOrden);

		return menuPoder;
	}

	private static JButton EntregarOrden(String tipoOrden, String tipo) {

		JButton click = new JButton(tipo);
		click.addActionListener(e -> {

			CambiarPantalla(EntregarVectorEnOrden(tipoOrden));

		});

		return click;

	}

	private static JPanel EntregarVectorEnOrden(String tipoOrden) {

		JPanel EntregarVector = new JPanel(new BorderLayout());
		JPanel Boton = new JPanel();
		JPanel vacio = new JPanel();
		
		vacio.setLayout(new BoxLayout(vacio, BoxLayout.Y_AXIS));

		JButton Regresar = VolverAlPanelPoder();

		Boton.add(Regresar);

		JScrollPane scrollPane = new JScrollPane(vacio);
		
		EntregarVector.add(Boton, BorderLayout.NORTH);
		EntregarVector.add(scrollPane, BorderLayout.CENTER);

		RellenarVacio(vacio, tipoOrden);

		return EntregarVector;

	}

	private static JButton VolverAlPanelPoder() {

		JButton click = new JButton("Regresar");
		click.addActionListener(e -> {

			CambiarPantalla(CrearPanelDePoder());

		});

		return click;

	}

	private static void RellenarVacio(JPanel vacio, String tipoOrden) {

		String[] cartas = S.EntregarOrden(tipoOrden).split(",");

		for (int a = 0; a < cartas.length; a++) {
			vacio.add(new JLabel(cartas[a]));

		}

	}

	private static JButton VolverAlMenuInicial() {

		JButton click = new JButton("Regresar");
		click.addActionListener(e -> {

			CambiarPantalla(CrearGUI());

		});

		return click;
	}

	// Método generado para generar la lectura de archivo
	private static void LeerArchivo() {

		File file = new File("Sobres.txt");
		Scanner lector = null;

		try {

			lector = new Scanner(file);

			while (lector.hasNextLine()) {
				S.TrabajarLinea(lector.nextLine());
			}

		} catch (Exception e) {
		}

		lector.close();

	}

	// Método generado para imprimir bonito
	public static void P(String t) {
		System.out.println(t);
	}

}
