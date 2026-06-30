package strategy;

/**
 * Factory encargada de crear estrategias de ordenamiento.
 */
public class FactoryStrategy {
	
	/**
	 * Crea una estrategia segun la opcion recibida.
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