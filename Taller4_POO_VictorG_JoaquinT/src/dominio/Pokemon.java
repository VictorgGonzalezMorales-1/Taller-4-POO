package dominio;

import visitor.*;

/**
 * Representa una carta de tipo Pokemon.
 */
public class Pokemon extends Cartas {

	private double daño;
	private double cantEnergias;

	/**
	 * Constructor de Pokemon.
	 */
	public Pokemon(String nombreCarta, double rareza, String tipo, double daño, double cantEnergias) {
		super(nombreCarta, rareza, tipo);
		this.daño = daño;
		this.cantEnergias = cantEnergias;
	}

	public double getDaño() {
		return daño;
	}

	public double getCantEnergias() {
		return cantEnergias;
	}

	public void setDaño(double daño) {
		this.daño = daño;
	}

	public void setCantEnergias(double cantEnergias) {
		this.cantEnergias = cantEnergias;
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
				FormatearNumero(daño) + ";" +
				FormatearNumero(cantEnergias);
	}

	@Override
	public void ModificarExtras(String dato1, String dato2) {
		double nuevoDaño = Double.valueOf(dato1);
		double nuevasEnergias = Double.valueOf(dato2);

		if (nuevasEnergias > 0) {
			daño = nuevoDaño;
			cantEnergias = nuevasEnergias;
		}
	}

	@Override
	public String EntregarDatosExtra() {
		return "Daño: " + daño + "\nCantidad de energias: " + cantEnergias;
	}

	@Override
	public String toString() {
		return tipo + "," + daño + "," + cantEnergias + "," + nombreCarta + "," + rareza + "," + rutaImagen;
	}
}