package view;

import presenter.Presenter;

public class View extends ViewAbstract {

	public View() {
		super();
	}
	
	// RESPONSABILITY: IMPRIMIR RESULTADOS
    public void printResult() {
    	System.out.println("***********************");
    	System.out.println("DataFile: " + _fileInput);
    	System.out.println("Interp at " + formatResult.format(_xInput) + 
    					" ; result = " + formatResult.format(this._presenter.getResult() ) );
	}

}
