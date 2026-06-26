package dominio;

//Importar librerias necesarias
import visitor.*;

public class Item extends Cartas {

	private double bonificacion;

	public Item(String nombreCarta, double rareza, String tipo, double bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public double getBonificacion() {
		return bonificacion;
	}

	@Override
	public void Aceptar(InterfazVisitor V) {
		V.Visit(this);

	}

	@Override
	public String toString() {
		return tipo + "," + bonificacion + "," + nombreCarta + "," + rareza + "," + rutaImagen;
	}

}
