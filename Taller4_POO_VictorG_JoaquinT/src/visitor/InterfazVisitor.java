package visitor;

import dominio.*;

/**
 * Interfaz del patron Visitor.
 */
public interface InterfazVisitor {
	
	void Visit(Pokemon p);

	void Visit(Item i);

	void Visit(Supporter s);

	void Visit(Energy e);
	
	double EntregarResultado();
}