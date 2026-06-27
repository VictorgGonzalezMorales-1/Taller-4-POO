package dominio;

//Importar librerias necesarias
import visitor.*;

/**
 * Representa una carta de tipo Item.
 */
public class Item extends Cartas {

	private double bonificacion;

	/**
	 * Constructor de Item.
	 *
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 * @param bonificacion bonificacion del item
	 */
	public Item(String nombreCarta, double rareza, String tipo, double bonificacion) {
		super(nombreCarta, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	public double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
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
				FormatearNumero(bonificacion);
	}

	@Override
	public void ModificarExtras(String dato1, String dato2) {
		this.bonificacion = Double.valueOf(dato1);
	}

	@Override
	public String EntregarDatosExtra() {
		return "Bonificacion: " + bonificacion;
	}

	@Override
	public String toString() {
		return tipo + "," + bonificacion + "," + nombreCarta + "," + rareza + "," + rutaImagen;
	}
}