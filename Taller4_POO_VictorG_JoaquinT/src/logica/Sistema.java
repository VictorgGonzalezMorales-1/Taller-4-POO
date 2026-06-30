package logica;

import java.util.LinkedList;
import dominio.Cartas;

/**
 * Interfaz principal del sistema.
 */
public interface Sistema {

	void CargarArchivo();

	void GuardarArchivo();

	void TrabajarLinea(String l);

	boolean AgregarCarta(String nombre, String rareza, String tipo, String dato1, String dato2);

	boolean EliminarCartaPorIndice(int indice);

	boolean ModificarCartaPorIndice(int indice, String dato1, String dato2);

	String EntregarOrden(String n);

	String buscarCartaPorNombre(String nombre);

	String BuscarCartaPorIndice(int indice);

	void EliminarObjetoConNombre(String nombre);

	LinkedList<Cartas> EntregarMemoria();

	int CantidadCartas();
}