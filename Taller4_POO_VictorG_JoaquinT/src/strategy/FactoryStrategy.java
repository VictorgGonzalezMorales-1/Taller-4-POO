package strategy;

/**
 * Factory encargada de crear estrategias de ordenamiento.
 */
public class FactoryStrategy {
	
	/**
	 * Crea una estrategia de ordenamiento segun la opcion recibida.
	 *
	 * @param n opcion de ordenamiento
	 *          1: poder
	 *          2: nombre
	 *          3: rareza
	 * @return estrategia de ordenamiento
	 */
	public static InterfazStrategy CrearStrategy(String n) {

		switch (n) {

		case "1":
			return new StrategyPoder();

		case "2":
			return new StrategyNombre();

		case "3":
			return new StrategyRareza();

		default:
			return new StrategyNombre();
		}
	}
}