package strategy;

import java.util.LinkedList;
import dominio.Cartas;

/**
 * Estrategia que ordena las cartas alfabeticamente por nombre.
 */
public class StrategyNombre implements InterfazStrategy {

	@Override
	public LinkedList<Cartas> Ordenar(LinkedList<Cartas> C) {

		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1; j++) {

				String nombre1 = C.get(j).getNombreCarta();
				String nombre2 = C.get(j + 1).getNombreCarta();

				if (nombre1.compareToIgnoreCase(nombre2) > 0) {

					Cartas temporal = C.get(j);
					C.set(j, C.get(j + 1));
					C.set(j + 1, temporal);

				}
			}
		}

		return C;
	}
}