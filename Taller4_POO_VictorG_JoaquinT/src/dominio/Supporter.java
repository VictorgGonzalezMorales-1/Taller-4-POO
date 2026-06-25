package dominio;

public class Supporter extends Cartas {

	private double efectosPorTurno;

	public Supporter(String nombreCarta, double rareza, String tipo, double efectosPorTurno) {
		super(nombreCarta, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public double getEfectosPorTurno() {
		return efectosPorTurno;
	}

}
