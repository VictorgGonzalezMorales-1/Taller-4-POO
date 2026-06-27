package strategy;

import java.util.LinkedList;

import dominio.Cartas;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

/**
 * Estrategia que ordena las cartas por poder calculado.
 * El poder se obtiene usando el patron Visitor.
 */
public class StrategyPoder implements InterfazStrategy {

	@Override
	public LinkedList<Cartas> Ordenar(LinkedList<Cartas> C) {

		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1; j++) {

				double poder1 = CalcularPoder(C.get(j));
				double poder2 = CalcularPoder(C.get(j + 1));

				if (poder1 < poder2) {

					Cartas temporal = C.get(j);
					C.set(j, C.get(j + 1));
					C.set(j + 1, temporal);

				}
			}
		}

		return C;
	}

	/**
	 * Calcula el poder de una carta usando Visitor.
	 *
	 * @param carta carta a evaluar
	 * @return poder calculado
	 */
	private double CalcularPoder(Cartas carta) {
		InterfazVisitor V = new VisitorPoder();
		carta.Aceptar(V);
		return V.EntregarResultado();
	}
}