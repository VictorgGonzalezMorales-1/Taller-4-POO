package visitor;

import dominio.*;

/**
 * Visitor encargado de calcular el poder de cada tipo de carta.
 */
public class VisitorPoder implements InterfazVisitor {

	private Double poder;

	/**
	 * Constructor del visitor.
	 * Inicializa el poder en cero para evitar valores nulos.
	 */
	public VisitorPoder() {
		poder = 0.0;
	}

	@Override
	public void Visit(Pokemon p) {
		poder = (p.getDaño() / p.getCantEnergias()) * 100;
	}

	@Override
	public void Visit(Item i) {
		poder = i.getBonificacion() * 20;
	}

	@Override
	public void Visit(Supporter s) {
		poder = s.getEfectosPorTurno() * 50;
	}

	@Override
	public void Visit(Energy e) {
		poder = 1.0;
	}

	@Override
	public double EntregarResultado() {
		return poder;
	}
}