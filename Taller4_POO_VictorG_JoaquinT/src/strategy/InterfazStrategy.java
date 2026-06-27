package strategy;

//Importar librerias necesarias
import dominio.*;
import java.util.LinkedList;

/**
 * Interfaz del patron Strategy.
 * Define el comportamiento comun para ordenar la coleccion de cartas.
 */
public interface InterfazStrategy {

	/**
	 * Recibe la memoria de cartas y retorna la misma coleccion ordenada
	 * segun la estrategia concreta.
	 *
	 * @param C coleccion de cartas
	 * @return coleccion ordenada
	 */
	LinkedList<Cartas> Ordenar(LinkedList<Cartas> C);

}