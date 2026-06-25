package strategy;

//Importar librerias necesarias
import dominio.*;
import logica.*;
import java.util.LinkedList;

public interface InterfazStrategy {

	// Recibe el vector memoria de objetos y devuelve el mismo, pero odenado
	LinkedList<Cartas> Ordenar(LinkedList<Cartas> C);

}
