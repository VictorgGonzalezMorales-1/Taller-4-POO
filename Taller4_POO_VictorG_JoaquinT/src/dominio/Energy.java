package dominio;

//Importar librerias necesarias
import visitor.*;

public class Energy extends Cartas {

	private String elemento;

	public Energy(String nombreCarta, double rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, tipo);
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	@Override
	public void Aceptar(InterfazVisitor V) {
		V.Visit(this);
		
	}

}
