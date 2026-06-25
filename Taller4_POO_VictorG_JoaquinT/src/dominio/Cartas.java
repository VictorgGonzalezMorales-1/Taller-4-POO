package dominio;

public abstract class Cartas {

	protected String nombreCarta;
	protected double rareza;
	protected String tipo;

	public Cartas(String nombreCarta, double rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cartas [nombreCarta=" + nombreCarta + ", tipo=" + tipo + "]";
	}

	public double getRareza() {
		return rareza;
	}

	public String getNombreCarta() {
		return nombreCarta;
	}

}
