package strategy;

import dominio.*;
import java.util.LinkedList;

/**
 * Interfaz del patron Strategy.
 */
public interface InterfazStrategy {

	/**
	 * Ordena la coleccion recibida.
	 */
	LinkedList<Cartas> Ordenar(LinkedList<Cartas> C);
}