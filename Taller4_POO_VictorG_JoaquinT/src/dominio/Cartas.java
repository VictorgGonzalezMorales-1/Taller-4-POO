package dominio;

import visitor.*;

/**
 * Clase abstracta que representa una carta general de la coleccion.
 */
public abstract class Cartas {

	protected String nombreCarta;
	protected double rareza;
	protected String tipo;
	protected String rutaImagen;

	/**
	 * Constructor de carta.
	 */
	public Cartas(String nombreCarta, double rareza, String tipo) {
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
		this.rutaImagen = "imagenes/" + nombreCarta;
	}

	/**
	 * Retorna la rareza de la carta.
	 */
	public double getRareza() {
		return rareza;
	}

	/**
	 * Retorna el nombre de la carta.
	 */
	public String getNombreCarta() {
		return nombreCarta;
	}

	/**
	 * Retorna el tipo de carta.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Retorna la ruta base de la imagen.
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}

	/**
	 * Acepta un visitor.
	 */
	public abstract void Aceptar(InterfazVisitor V);

	/**
	 * Retorna la carta en formato de archivo.
	 */
	public abstract String FormatoArchivo();

	/**
	 * Modifica solamente los datos propios del tipo de carta.
	 */
	public abstract void ModificarExtras(String dato1, String dato2);

	/**
	 * Entrega los datos adicionales de la carta.
	 */
	public abstract String EntregarDatosExtra();

	/**
	 * Formatea un numero para guardarlo en el archivo.
	 */
	protected String FormatearNumero(double numero) {
		if (numero == (long) numero) {
			return String.valueOf((long) numero);
		}

		return String.valueOf(numero);
	}

	@Override
	public String toString() {
		return "Cartas [nombreCarta=" + nombreCarta + ", tipo=" + tipo + "]";
	}
}