package strategy;

import java.util.LinkedList;
import dominio.Cartas;

public class StrategyNombre implements InterfazStrategy {

	@Override
	public LinkedList<Cartas> Ordenar(LinkedList<Cartas> C) {

		String abc = "abcdefghijklmnopqrstuvwxyz";
		String[] abecedario = abc.split("");

		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1; j++) {

				String letra1 = C.get(j).getNombreCarta().toLowerCase().split("")[0];
				String letra2 = C.get(j + 1).getNombreCarta().toLowerCase().split("")[0];

				int indice1 = 0;
				int indice2 = 0;

				for (int k = 0; k < abecedario.length; k++) {

					if (letra1.equals(abecedario[k])) {
						indice1 = k;
					}

					if (letra2.equals(abecedario[k])) {
						indice2 = k;
					}

				}

				if (indice1 > indice2) {

					Cartas temporal = C.get(j);
					C.set(j, C.get(j + 1));
					C.set(j + 1, temporal);

				}
			}
		}

		return C;
	}

}
