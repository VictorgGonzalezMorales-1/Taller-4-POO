package logica;

//Importar librerias necesarias/ Package necesarios
import java.util.LinkedList;
import dominio.*;
import strategy.*;
import visitor.InterfazVisitor;
import visitor.VisitorPoder;

public class SistemaImplementado implements Sistema {

	// Generar Memoria para guardar los objetos creados
	static LinkedList<Cartas> M = new LinkedList<Cartas>();
	// Variable para almacenar la instacia de la clase
	static Sistema S;

	private SistemaImplementado() {
	}

	// Método para entregar solo una instacia del Sistema
	public static Sistema getInstance() {
		if (S == null)
			S = new SistemaImplementado();
		return S;
	}

	@Override
	public void TrabajarLinea(String l) {
		M.add(FactoryCartas.CrearCarta(l.split(";")));
	}

	// Método el cual dependiendo de la opción que elijan, se ordenarán los objetos
	// en base a ese requermiento
	public void Ordenar(String t) {
		InterfazStrategy S = FactoryStrategy.CrearStrategy(t);
		M = S.Ordenar(M);

	}

	@Override
	public String EntregarOrden(String n) {

		Ordenar(n);

		String texto = "";
		InterfazVisitor V = new VisitorPoder();

		for (int a = 0; a < M.size(); a++) {
			M.get(a).Aceptar(V);
			texto += (a + 1) + ") " + M.get(a).getNombreCarta() + "  -  " + V.EntregarResultado() + ",";
		}

		return texto + "";

	}

}
