package logica;

import java.util.LinkedList;

import dominio.Cartas;

/**
 * Interfaz principal del sistema.
 * Define las operaciones necesarias para administrar la coleccion.
 */
public interface Sistema {

	/**
	 * Carga todas las cartas desde el archivo Sobres.txt.
	 */
	void CargarArchivo();

	/**
	 * Guarda todas las cartas actuales en el archivo Sobres.txt.
	 */
	void GuardarArchivo();

	/**
	 * Metodo generado para recibir y direccionar la informacion de una linea.
	 *
	 * @param l linea leida desde el archivo
	 */
	void TrabajarLinea(String l);

	/**
	 * Agrega una carta a la memoria usando los datos recibidos.
	 *
	 * @param nombre nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 * @param dato1 primer atributo adicional
	 * @param dato2 segundo atributo adicional
	 * @return true si se pudo agregar, false en caso contrario
	 */
	boolean AgregarCarta(String nombre, String rareza, String tipo, String dato1, String dato2);

	/**
	 * Elimina una carta usando su indice dentro de la memoria.
	 *
	 * @param indice posicion de la carta
	 * @return true si se elimino, false si no se pudo eliminar
	 */
	boolean EliminarCartaPorIndice(int indice);

	/**
	 * Modifica solamente los atributos adicionales de una carta.
	 *
	 * @param indice posicion de la carta
	 * @param dato1 primer atributo adicional
	 * @param dato2 segundo atributo adicional
	 * @return true si se modifico, false si no se pudo modificar
	 */
	boolean ModificarCartaPorIndice(int indice, String dato1, String dato2);

	/**
	 * Metodo generado para al solicitar los objetos en un orden especifico,
	 * ordenarlos y entregarlos.
	 *
	 * @param n tipo de ordenamiento
	 * @return nombres de cartas separados por coma
	 */
	String EntregarOrden(String n);

	/**
	 * Busca una carta por nombre y entrega sus datos en texto.
	 *
	 * @param nombre nombre de la carta
	 * @return datos de la carta
	 */
	String buscarCartaPorNombre(String nombre);

	/**
	 * Busca una carta por indice y entrega sus datos en texto.
	 *
	 * @param indice posicion de la carta
	 * @return datos de la carta
	 */
	String BuscarCartaPorIndice(int indice);

	/**
	 * Elimina una carta por nombre.
	 * Metodo antiguo mantenido para compatibilidad con la GUI actual.
	 *
	 * @param nombre nombre de la carta
	 */
	void EliminarObjetoConNombre(String nombre);

	/**
	 * Entrega una copia de la memoria de cartas.
	 *
	 * @return lista de cartas
	 */
	LinkedList<Cartas> EntregarMemoria();

	/**
	 * Entrega la cantidad de cartas cargadas.
	 *
	 * @return cantidad de cartas
	 */
	int CantidadCartas();
}