package dominio;

//Importar librerias necesarias
import visitor.*;

/**
 * Representa una carta de tipo Supporter.
 */
public class Supporter extends Cartas {

	private double efectosPorTurno;

	/**
	 * Constructor de Supporter.
	 *
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 * @param efectosPorTurno efectos por turno
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
		return nombreCarta + ";" + rareza + ";" + tipo + ";" + efectosPorTurno;
	}

	@Override
	public void ModificarExtras(String dato1, String dato2) {
		this.efectosPorTurno = Double.valueOf(dato1);
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