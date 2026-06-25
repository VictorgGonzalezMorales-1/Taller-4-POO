package visitor;

import dominio.*;

public class VisitorPoder implements InterfazVisitor {

	private Double poder;

	@Override
	public void Visit(Pokemon p) {poder = (p.getDaño()/p.getCantEnergias())*100;}

	@Override
	public void Visit(Item i) {poder = i.getBonificacion()*20;}

	@Override
	public void Visit(Supporter s) {poder = s.getEfectosPorTurno()*50;}

	@Override
	public void Visit(Energy e) {poder = (double) 1;}

	
	@Override
	public double EntregarResultado() {
		return poder;
	}

}
