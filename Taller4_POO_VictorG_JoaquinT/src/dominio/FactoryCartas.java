package dominio;

public class FactoryCartas {
	
	public static Cartas CrearCarta(String[] p) {

		Cartas c = null;

		switch (p[2]) {

		case "Pokemon":
			return new Pokemon(p[0], Double.valueOf(p[1]), p[2], Double.valueOf(p[3]), Double.valueOf(p[4]));

		case "Item":
			return new Item(p[0], Double.valueOf(p[1]), p[2], Double.valueOf(p[3]));

		case "Supporter":
			return new Supporter(p[0], Double.valueOf(p[1]), p[2], Double.valueOf(p[3]));

		case "Energy":
			return new Energy(p[0], Double.valueOf(p[1]), p[2], p[3]);

		}

		return c;

	}

}
