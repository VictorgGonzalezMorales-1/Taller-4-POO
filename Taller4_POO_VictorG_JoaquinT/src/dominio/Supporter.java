package dominio;

import visitor.*;

/**
 * Representa una carta de tipo Supporter.
 */
public class Supporter extends Cartas {

	private double efectosPorTurno;

	/**
	 * Constructor de Supporter.
	 */
	public Supporter(String nombreCarta, double rareza, String tipo, double efectosPorTurno) {
		super(nombreCarta, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}

	public double getEfectosPorTurno() {
		return efectosPorTurno;
	}

	public void setEfectosPorTurno(double efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

	@Override
	public void Aceptar(InterfazVisitor V) {
		V.Visit(this);
	}

	@Override
	public String FormatoArchivo() {
		return nombreCarta + ";" +
				FormatearNumero(rareza) + ";" +
				tipo + ";" +
				FormatearNumero(efectosPorTurno);
	}

	@Override
	public void ModificarExtras(String dato1, String dato2) {
		efectosPorTurno = Double.valueOf(dato1);
	}

	@Override
	public String EntregarDatosExtra() {
		return "Efectos por turno: " + efectosPorTurno;
	}

	@Override
	public String toString() {
		return tipo + "," + efectosPorTurno + "," + nombreCarta + "," + rareza + "," + rutaImagen;
	}
}