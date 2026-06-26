package strategy;

public class FactoryStrategy {
	
	public static InterfazStrategy CrearStrategy(String n) {

		switch (n) {

		case "1":
			return new StrategyPoder();

		case "2":
			return new StrategyNombre();

		case "3":
			return new StrategyRareza();
		}

		return null;

	}

}
