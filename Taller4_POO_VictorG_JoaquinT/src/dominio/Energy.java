package dominio;

//Importar librerias necesarias
import visitor.*;

/**
 * Representa una carta de tipo Energy.
 */
public class Energy extends Cartas {

	private String elemento;

	/**
	 * Constructor de Energy.
	 *
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 * @param elemento elemento de la energia
	 */
	public Energy(String nombreCarta, double rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	@Override
	public void Aceptar(InterfazVisitor V) {
		V.Visit(this);
	}

	@Override
	public String FormatoArchivo() {
		return nombreCarta + ";" + rareza + ";" + tipo + ";" + elemento;
	}

	@Override
	public void ModificarExtras(String dato1, String dato2) {
		this.elemento = dato1;
	}

	@Override
	public String EntregarDatosExtra() {
		return "Elemento: " + elemento;
	}

	@Override
	public String toString() {
		return tipo + "," + elemento + "," + nombreCarta + "," + rareza + "," + rutaImagen;
	}
}