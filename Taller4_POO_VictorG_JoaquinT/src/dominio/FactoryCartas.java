package dominio;

/**
 * Factory encargada de crear cartas segun el tipo recibido.
 */
public class FactoryCartas {
	
	/**
	 * Crea una carta a partir de las partes de una linea del archivo Sobres.txt.
	 *
	 * @param p arreglo con los datos de la carta
	 * @return carta creada
	 */
	public static Cartas CrearCarta(String[] p) {

		if (p.length < 4) {
			throw new IllegalArgumentException("Linea incompleta en Sobres.txt");
		}

		switch (p[2]) {

		case "Pokemon":

			if (p.length < 5) {
				throw new IllegalArgumentException("Pokemon requiere daño y cantidad de energias.");
			}

			double daño = Double.valueOf(p[3]);
			double energias = Double.valueOf(p[4]);

			if (energias <= 0) {
				throw new IllegalArgumentException("La cantidad de energias debe ser mayor que cero.");
			}

			return new Pokemon(p[0], Double.valueOf(p[1]), p[2], daño, energias);

		case "Item":
			return new Item(p[0], Double.valueOf(p[1]), p[2], Double.valueOf(p[3]));

		case "Supporter":
			return new Supporter(p[0], Double.valueOf(p[1]), p[2], Double.valueOf(p[3]));

		case "Energy":
			return new Energy(p[0], Double.valueOf(p[1]), p[2], p[3]);

		default:
			throw new IllegalArgumentException("Tipo de carta no encontrado: " + p[2]);
		}
	}

	/**
	 * Crea una carta desde datos ingresados manualmente en la GUI.
	 *
	 * @param nombre nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 * @param dato1 primer dato adicional
	 * @param dato2 segundo dato adicional
	 * @return carta creada
	 */
	public static Cartas CrearCartaDesdeDatos(String nombre, double rareza, String tipo, String dato1, String dato2) {

		switch (tipo) {

		case "Pokemon":

			double daño = Double.valueOf(dato1);
			double energias = Double.valueOf(dato2);

			if (energias <= 0) {
				throw new IllegalArgumentException("La cantidad de energias debe ser mayor que cero.");
			}

			return new Pokemon(nombre, rareza, tipo, daño, energias);

		case "Item":
			return new Item(nombre, rareza, tipo, Double.valueOf(dato1));

		case "Supporter":
			return new Supporter(nombre, rareza, tipo, Double.valueOf(dato1));

		case "Energy":
			return new Energy(nombre, rareza, tipo, dato1);

		default:
			throw new IllegalArgumentException("Tipo de carta no encontrado: " + tipo);
		}
	}
}