package dominio;

public class Item extends Cartas {

	private double bonificacion;

	public Item(String nombreCarta, double rareza, String tipo, double bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public double getBonificacion() {
		return bonificacion;
	}

}
