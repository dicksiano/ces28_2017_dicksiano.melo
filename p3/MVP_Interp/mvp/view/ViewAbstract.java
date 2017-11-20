package view;

import java.text.DecimalFormat;
import presenter.Presenter;

public abstract class ViewAbstract {
	protected Presenter _presenter;
	
	protected String _methodInput;
	protected String _fileInput;
	protected double _xInput;
	protected DecimalFormat formatResult = new DecimalFormat("####.######");
    
    public ViewAbstract() { 
    	this._presenter = Presenter.getInstance(this);
    }
    
    // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO  
    public void setMethod( String methodInput) {
    	this._methodInput = methodInput;
    }
    
    public String getMethodInput() {
    	return _methodInput;
    }
    
    // RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
    public void setFileInput( String fileInput) {
    	this._fileInput = fileInput;
    }
    
    public String getFileInput() {
    	return _fileInput;
    }
    
    // RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
    public void setXInput( double xInput) {
    	this._xInput = xInput;
    }
    
    public double getXInput() {
    	return _xInput;
    }
    
    // RESPONSABILITY: IMPRIMIR RESULTADOS
    public abstract void printResult();
    
}