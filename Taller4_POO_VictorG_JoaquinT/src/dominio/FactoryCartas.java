package dominio;

/**
 * Factory encargada de crear cartas.
 */
public class FactoryCartas {
	
	/**
	 * Crea una carta desde una linea separada del archivo.
	 */
	public static Cartas CrearCarta(String[] p) {

		Cartas carta = null;

		try {

			if (p.length < 4) {
				return null;
			}

			if (p[2].equals("Pokemon")) {

				if (p.length < 5) {
					return null;
				}

				double rareza = Double.valueOf(p[1]);
				double daño = Double.valueOf(p[3]);
				double energias = Double.valueOf(p[4]);

				if (energias <= 0) {
					return null;
				}

				carta = new Pokemon(p[0], rareza, p[2], daño, energias);

			} else if (p[2].equals("Item")) {

				double rareza = Double.valueOf(p[1]);
				double bonificacion = Double.valueOf(p[3]);

				carta = new Item(p[0], rareza, p[2], bonificacion);

			} else if (p[2].equals("Supporter")) {

				double rareza = Double.valueOf(p[1]);
				double efectos = Double.valueOf(p[3]);

				carta = new Supporter(p[0], rareza, p[2], efectos);

			} else if (p[2].equals("Energy")) {

				double rareza = Double.valueOf(p[1]);

				carta = new Energy(p[0], rareza, p[2], p[3]);
			}

		} catch (Exception e) {
			carta = null;
		}

		return carta;
	}

	/**
	 * Crea una carta desde los datos ingresados en la GUI.
	 */
	public static Cartas CrearCartaDesdeDatos(String nombre, double rareza, String tipo, String dato1, String dato2) {

		Cartas carta = null;

		try {

			if (tipo.equals("Pokemon")) {

				double daño = Double.valueOf(dato1);
				double energias = Double.valueOf(dato2);

				if (energias <= 0) {
					return null;
				}

				carta = new Pokemon(nombre, rareza, tipo, daño, energias);

			} else if (tipo.equals("Item")) {

				double bonificacion = Double.valueOf(dato1);
				carta = new Item(nombre, rareza, tipo, bonificacion);

			} else if (tipo.equals("Supporter")) {

				double efectos = Double.valueOf(dato1);
				carta = new Supporter(nombre, rareza, tipo, efectos);

			} else if (tipo.equals("Energy")) {

				carta = new Energy(nombre, rareza, tipo, dato1);
			}

		} catch (Exception e) {
			carta = null;
		}

		return carta;
	}
}