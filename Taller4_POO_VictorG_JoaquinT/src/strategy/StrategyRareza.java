package strategy;

import java.util.LinkedList;
import dominio.Cartas;

/**
 * Estrategia que ordena las cartas por rareza.
 * Mientras mayor sea la rareza, mejor es la carta.
 */
public class StrategyRareza implements InterfazStrategy {

	@Override
	public LinkedList<Cartas> Ordenar(LinkedList<Cartas> C) {

		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1; j++) {

				if (C.get(j).getRareza() < C.get(j + 1).getRareza()) {

					Cartas temporal = C.get(j);
					C.set(j, C.get(j + 1));
					C.set(j + 1, temporal);

				}
			}
		}
		
		return C;
	}
}