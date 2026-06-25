package strategy;

import java.util.LinkedList;

import dominio.Cartas;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

public class StrategyPoder implements InterfazStrategy {

	@Override
	public LinkedList<Cartas> Ordenar(LinkedList<Cartas> C) {

		InterfazVisitor V = new VisitorPoder();

		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1; j++) {

				C.get(j).Aceptar(V);
				double poder1 = V.EntregarResultado();

				C.get(j + 1).Aceptar(V);
				double poder2 = V.EntregarResultado();

				if (poder1 < poder2) {

					Cartas temporal = C.get(j);
					C.set(j, C.get(j + 1));
					C.set(j + 1, temporal);

				}
			}
		}

		return C;
	}

}
