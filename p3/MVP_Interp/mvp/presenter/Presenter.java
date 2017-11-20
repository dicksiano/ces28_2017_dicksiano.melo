package presenter;

import model.Model;
import view.ViewAbstract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;


public final class Presenter {
	private ViewAbstract _view;
	private Model _model;
    
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private double _value, _result;
    private File _file;
    private Vector<Double> x, y;
    private static volatile Presenter _instance = null;
    
    private Presenter() {
    	
    }
    // Presenter é Singleton para garantir que seja possível trocar de instância
    // de View utilizando a mesma instância de Presenter.
    public static Presenter getInstance(ViewAbstract viewAbstract) {
    	if(_instance == null) {
    		_instance = new Presenter();
    		_instance._model = new Model();
    	}

		_instance._view = viewAbstract;
    	return _instance;
    }
	
    
	// RESPONSABILITY: LER ARQUIVO DE DADOS
 	private void buildDataPoints() {
 		_file = new File(this._view.getFileInput());
 		
         if(_file == null) {
        	 System.out.println("Null file!");
            return;
         }

         x = new Vector<Double>();
         y = new Vector<Double>();
         try {
             input = new FileReader(_file);
 		    /* Filter FileReader through a Buffered read to read a line at a time */
             bufRead = new BufferedReader(input);
             // Read first line
             String line = bufRead.readLine();
             // Read through file one line at time.
             while (line != null){
                 xy = new StringTokenizer(line, "\t ");
                 while(xy.hasMoreTokens()) {
                     x.addElement(Double.parseDouble(xy.nextToken()));
                     y.addElement(Double.parseDouble(xy.nextToken()));
                 }
                 line = bufRead.readLine();
             }
             bufRead.close();
         } catch (IOException e) { // If another exception is generated, print a stack trace
             e.printStackTrace();
         }
     }//buildDataPoints
    
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult() {
        _value = this._view.getXInput();
        buildDataPoints();
        String currentMethod = this._view.getMethodInput();
        if(this._model.getMethod(currentMethod) != null) {
            _result = this._model.getMethod(currentMethod).calculateResult(_value, x, y);
            //this._view.printResult(_result);
        } else {
            System.out.println("It is not defined an interpolation method.");
        }
    }
    
    public double getResult() {
    	this.calculateResult();
    	return _result;
    }
}
