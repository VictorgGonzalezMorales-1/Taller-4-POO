package dominio;

//Importar librerias necesarias
import visitor.*;

public abstract class Cartas {

	protected String nombreCarta;
	protected double rareza;
	protected String tipo;
	protected String rutaImagen;

	public Cartas(String nombreCarta, double rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cartas [nombreCarta=" + nombreCarta + ", tipo=" + tipo + "]";
	}

	public double getRareza() {
		return rareza;
	}

	public String getNombreCarta() {
		return nombreCarta;
	}
	
	public String getRutaImagen() {
		return "{" + this.rutaImagen + "}.png/jpg/etc.";
	}
	
	// Método generado para aceptar la visita de la clase visitor
	public abstract void Aceptar(InterfazVisitor V);

}
