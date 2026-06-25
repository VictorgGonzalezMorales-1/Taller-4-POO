package visitor;

//Importar librerias necesarias/ Package necesarios
import dominio.*;

public interface InterfazVisitor {
	
	void Visit(Pokemon p);
	void Visit(Item i);
	void Visit(Supporter s);
	void Visit(Energy e);
	
	double EntregarResultado();

}
