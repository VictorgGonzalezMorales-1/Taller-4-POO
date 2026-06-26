package logica;

import dominio.Cartas;

public interface Sistema {

	// Método generado para recibir y direccionar la información de la linea
	void TrabajarLinea(String l);

	// Método generado para al solicitar los objetos en un orden específico,
	// ordenarlos y entregarlos
	String EntregarOrden(String n);

	// Método generado para que al buscar una carta por su nombre sea entregada si
	// es que
	String buscarCartaPorNombre(String nombre);

}
