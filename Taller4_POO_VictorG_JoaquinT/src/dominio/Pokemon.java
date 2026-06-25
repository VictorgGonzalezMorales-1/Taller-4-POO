package dominio;

//Importar librerias necesarias
import visitor.*;

public class Pokemon extends Cartas {

	private double daño;
	private double cantEnergias;

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

	@Override
	public void Aceptar(InterfazVisitor V) {
		V.Visit(this);

	}

}
