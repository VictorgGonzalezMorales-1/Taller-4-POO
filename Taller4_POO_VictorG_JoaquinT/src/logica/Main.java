package logica;

//Importar librerias necesarias
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

public class Main {

	static Sistema S = SistemaImplementado.getInstance();
	static JFrame menu;
	static boolean estoyEnAdministrador = false;
	static boolean quieroEliminar = false;
	static boolean quieroModificar = false;

	public static void main(String[] args) {

		LeerArchivo();
		InterfazUsuario();

	}

	// Encargado de Generar la Ventana y direccionar labores
	private static void InterfazUsuario() {

		menu = new JFrame("MateoGodoyBuscaNovia");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(400, 500);
		menu.getContentPane().add(CrearGUI());
		menu.setVisible(true);

	}

	// Método generado para que a la hora de cambiar entre los menú u opciones, se
	// actualice la pantalla
	private static void CambiarPantalla(JPanel nuevoPanel) {

		menu.getContentPane().removeAll();
		menu.getContentPane().add(nuevoPanel);
		menu.revalidate();
		menu.repaint();

	}

	// Método generado para generar el menú inicial
	private static JPanel CrearGUI() {

		JPanel menuInicial = new JPanel(new GridLayout(1, 1));
		JPanel panelBotones = new JPanel(new GridLayout(2, 1));

		JButton administracion = EntrarPanelAdministrador("Administrador");
		JButton colecciones = EntrarPanelPoder("Estrategia de Ordenamiento");
		;

		panelBotones.add(administracion);
		panelBotones.add(colecciones);

		menuInicial.add(panelBotones);

		return menuInicial;
	}

	// Método generado para ingresar al panel de administrador luego de presionar el
	// botón
	private static JButton EntrarPanelAdministrador(String t) {

		JButton click = new JButton(t);
		click.addActionListener(e -> {

			estoyEnAdministrador = true;
			CambiarPantalla(CrearPanelDeAdministrador());

		});

		return click;

	}

	// Método generado para completar el panel de administrador con la distibución
	// de botones necesarias
	private static JPanel CrearPanelDeAdministrador() {

		JPanel menuAdministrador = new JPanel(new GridLayout(1, 1));
		JPanel panelOpciones = new JPanel(new GridLayout(4, 1));

		JButton agregar = new JButton("Agregar Carta");
		JButton eliminar = EntregarVectorAEliminar("2", "Eliminar");
		JButton modificar = EntregarVectorAModificar("2", "Modificar");
		JButton regresar = VolverAlMenuInicial();

		panelOpciones.add(agregar);
		panelOpciones.add(eliminar);
		panelOpciones.add(modificar);
		panelOpciones.add(regresar);

		menuAdministrador.add(panelOpciones);

		return menuAdministrador;
	}

	// Método para regresar el menú de opciones de métodos de ordenamiento
	private static JButton VolverAlPanelAdministrador() {

		JButton click = new JButton("Regresar");
		click.addActionListener(e -> {

			CambiarPantalla(CrearPanelDeAdministrador());

		});

		return click;

	}

	// Entregar Vector en orden de objetos
	private static JButton EntregarVectorAEliminar(String tipoOrden, String tipo) {

		JButton click = new JButton(tipo);
		click.addActionListener(e -> {

			CambiarPantalla(EntregarVectorEnOrden(tipoOrden));

		});

		return click;

	}

	// Entregar Vector en orden de objetos
	private static JButton EntregarVectorAModificar(String tipoOrden, String tipo) {

		JButton click = new JButton(tipo);
		click.addActionListener(e -> {

			CambiarPantalla(EntregarVectorEnOrden(tipoOrden));

		});

		return click;

	}

	// Método generado para al precionar el botón de Estrategia ordenamiento se
	// redireccione a este menu
	private static JButton EntrarPanelPoder(String t) {

		JButton click = new JButton(t);
		click.addActionListener(e -> {

			estoyEnAdministrador = false;
			CambiarPantalla(CrearPanelDePoder());

		});

		return click;

	}

	// Método generado para crear el panel de poder
	private static JPanel CrearPanelDePoder() {

		JPanel menuPoder = new JPanel(new GridLayout(1, 1));
		JPanel panelOrden = new JPanel(new GridLayout(4, 1));

		JButton poder = EntregarOrden("1", "Poder");
		JButton nombre = EntregarOrden("2", "Nombre");
		JButton rareza = EntregarOrden("3", "Rareza");
		JButton regresar = VolverAlMenuInicial();

		panelOrden.add(poder);
		panelOrden.add(nombre);
		panelOrden.add(rareza);
		panelOrden.add(regresar);

		menuPoder.add(panelOrden);

		return menuPoder;
	}

	// Método generado para al presionar algun método de ordenamiento, se direccione
	// para completar esta tarea
	private static JButton EntregarOrden(String tipoOrden, String tipo) {

		JButton click = new JButton(tipo);
		click.addActionListener(e -> {

			CambiarPantalla(EntregarVectorEnOrden(tipoOrden));

		});

		return click;

	}

	// Método generado para generar los paneles en donde se mostrará el orden
	// resultante de la opción,
	private static JPanel EntregarVectorEnOrden(String tipoOrden) {

		JPanel EntregarVector = new JPanel(new BorderLayout());
		JPanel Boton = new JPanel();
		JPanel vacio = new JPanel();

		vacio.setLayout(new BoxLayout(vacio, BoxLayout.Y_AXIS));

		JButton Regresar = null;

		if (estoyEnAdministrador == true)
			Regresar = VolverAlPanelAdministrador();

		else
			Regresar = VolverAlPanelPoder();

		Boton.add(Regresar);

		JScrollPane scroll = new JScrollPane(vacio);

		EntregarVector.add(Boton, BorderLayout.NORTH);
		EntregarVector.add(scroll, BorderLayout.CENTER);

		RellenarVacio(vacio, tipoOrden);

		return EntregarVector;

	}

	// Método para regresar el menú de opciones de métodos de ordenamiento
	private static JButton VolverAlPanelPoder() {

		JButton click = new JButton("Regresar");
		click.addActionListener(e -> {

			CambiarPantalla(CrearPanelDePoder());

		});

		return click;

	}

	// Método generado para al solicitar el orden resultante de los objetos según la
	// estrategia, mostrar en orden estos resultados agregandolos al panal vacío
	private static void RellenarVacio(JPanel vacio, String tipoOrden) {

		String[] cartas = S.EntregarOrden(tipoOrden).split(",");

		for (int a = 0; a < cartas.length; a++) {

			String nombre = cartas[a];
			JButton botonNuevo = new JButton(nombre);
			botonNuevo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

			botonNuevo.addActionListener(e -> {

				CambiarPantalla(CrearPanelDetalleCarta(nombre, tipoOrden));

			});

			vacio.add(botonNuevo);

		}

	}

	// Método generado para dependiendo del tipo de carta, entregar su información
	private static JPanel CrearPanelDetalleCarta(String nombreCarta, String tipoOrden) {

		JPanel menuCarta = new JPanel(new GridLayout(2, 1));
		JPanel imagen = new JPanel();
		JPanel atributos = new JPanel();

		String[] d = S.buscarCartaPorNombre(nombreCarta).split(",");

		JButton tipo;
		JButton nombre;
		JButton rareza;
		JButton daño;
		JButton energias;
		JButton poder;
		JButton bonificacion;
		JButton efectorPorTurno;
		JButton elemento;
		JButton regresar = VolverALasCartas(tipoOrden);

		switch (d[0]) {

		case "Pokemon":

			if (estoyEnAdministrador == false) {

				atributos = new JPanel(new GridLayout(7, 1));

				tipo = new JButton("Tipo: " + d[0]);
				nombre = new JButton("Nombre: " + d[3]);
				rareza = new JButton("Rareza: " + d[4]);
				daño = new JButton("Daño: " + d[1]);
				energias = new JButton("Cantidad Energías: " + d[2]);
				poder = new JButton("Poder: " + d[6]);

				atributos.add(tipo);
				atributos.add(nombre);
				atributos.add(rareza);
				atributos.add(daño);
				atributos.add(energias);
				atributos.add(poder);
				atributos.add(regresar);

			}

			else {

			}

			menuCarta.add(imagen);
			menuCarta.add(atributos);

			break;

		case "Item":

			if (estoyEnAdministrador == false) {

				atributos = new JPanel(new GridLayout(5, 1));

				tipo = new JButton("Tipo: " + d[0]);
				nombre = new JButton("Nombre: " + d[2]);
				rareza = new JButton("Rareza: " + d[3]);
				bonificacion = new JButton("Bonificación: " + d[1]);
				poder = new JButton("Poder: " + d[4]);

				atributos.add(tipo);
				atributos.add(nombre);
				atributos.add(rareza);
				atributos.add(bonificacion);
				atributos.add(poder);
				atributos.add(regresar);

			}

			else {

				if (quieroEliminar == true) {

				}

				else if (quieroModificar == true) {

				}

			}

			menuCarta.add(imagen);
			menuCarta.add(atributos);

			break;

		case "Supporter":

			if (estoyEnAdministrador == false) {

				atributos = new JPanel(new GridLayout(5, 1));

				tipo = new JButton("Tipo: " + d[0]);
				nombre = new JButton("Nombre: " + d[2]);
				rareza = new JButton("Rareza: " + d[3]);
				efectorPorTurno = new JButton("Efectos por turno: " + d[1]);
				poder = new JButton("Poder: " + d[4]);

				atributos.add(tipo);
				atributos.add(nombre);
				atributos.add(rareza);
				atributos.add(efectorPorTurno);
				atributos.add(poder);
				atributos.add(regresar);

			}

			else {

				if (quieroEliminar == true) {

				}

				else if (quieroModificar == true) {

				}

			}

			menuCarta.add(imagen);
			menuCarta.add(atributos);

			break;

		case "Energy":

			if (estoyEnAdministrador == false) {

				atributos = new JPanel(new GridLayout(5, 1));

				tipo = new JButton("Tipo: " + d[0]);
				nombre = new JButton("Nombre: " + d[2]);
				rareza = new JButton("Rareza: " + d[3]);
				elemento = new JButton("Elemento: " + d[1]);
				poder = new JButton("Poder: " + d[4]);

				atributos.add(tipo);
				atributos.add(nombre);
				atributos.add(rareza);
				atributos.add(elemento);
				atributos.add(poder);
				atributos.add(regresar);

			}

			else {

				if (quieroEliminar == true) {

				}

				else if (quieroModificar == true) {

				}

			}

			menuCarta.add(imagen);
			menuCarta.add(atributos);

			break;

		}

		return menuCarta;
	}

	// Método para regresar al menú inicial
	private static JButton VolverALasCartas(String tipoOrden) {

		JButton click = new JButton("Regresar");
		click.addActionListener(e -> {

			CambiarPantalla(EntregarVectorEnOrden(tipoOrden));

		});

		return click;
	}

	// Método para regresar al menú inicial
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
