package dominio;

//Importar librerias necesarias
import visitor.*;

/**
 * Clase abstracta que representa una carta generica de la coleccion.
 * Contiene los atributos comunes de todos los tipos de cartas.
 */
public abstract class Cartas {

	protected String nombreCarta;
	protected double rareza;
	protected String tipo;
	protected String rutaImagen;

	/**
	 * Constructor de la clase Cartas.
	 *
	 * @param nombreCarta nombre de la carta
	 * @param rareza rareza de la carta
	 * @param tipo tipo de carta
	 */
	public Cartas(String nombreCarta, double rareza, String tipo) {
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
		this.rutaImagen = "imagenes/" + nombreCarta;
	}

	/**
	 * Retorna la rareza de la carta.
	 *
	 * @return rareza de la carta
	 */
	public double getRareza() {
		return rareza;
	}

	/**
	 * Retorna el nombre de la carta.
	 *
	 * @return nombre de la carta
	 */
	public String getNombreCarta() {
		return nombreCarta;
	}

	/**
	 * Retorna el tipo de carta.
	 *
	 * @return tipo de carta
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Retorna la ruta base de la imagen.
	 * La extension se buscara despues como png, jpg o jpeg.
	 *
	 * @return ruta base de imagen
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}

	/**
	 * Metodo para aceptar un visitor.
	 *
	 * @param V visitor que operara sobre la carta
	 */
	public abstract void Aceptar(InterfazVisitor V);

	/**
	 * Retorna la carta en el formato original de Sobres.txt.
	 *
	 * @return linea lista para guardar en archivo
	 */
	public abstract String FormatoArchivo();

	/**
	 * Modifica solamente los atributos adicionales segun el tipo de carta.
	 *
	 * @param dato1 primer dato adicional
	 * @param dato2 segundo dato adicional, usado principalmente en Pokemon
	 */
	public abstract void ModificarExtras(String dato1, String dato2);

	/**
	 * Retorna una descripcion de los atributos adicionales.
	 *
	 * @return texto con datos extra
	 */
	public abstract String EntregarDatosExtra();
	
	/**
	 * Formatea un numero para guardarlo en el archivo.
	 * Si el numero es entero, lo guarda sin decimal.
	 *
	 * @param numero numero a formatear
	 * @return numero como texto
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