package logica;

//Importar librerias necesarias/ Package necesarios
import java.util.LinkedList;
import dominio.*;

public class SistemaImplementado implements Sistema {

	// Generar Memoria para guardar los objetos creados
	static LinkedList<Cartas> M = new LinkedList<Cartas>();
	// Variable para almacenar la instacia de la clase
	static Sistema S;

	private SistemaImplementado() {
	}

	// Método para entregar solo una instacia del Sistema
	public static Sistema getInstance() {
		if (S == null)
			S = new SistemaImplementado();
		return S;
	}

	@Override
	public void TrabajarLinea(String l) {
		M.add(FactoryCartas.CrearCarta(l.split(";")));
	}

}
