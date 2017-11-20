package model;

import InterpV0.CubicSpline;
import InterpV0.InterpolationMethod;
import InterpV0.Lagrange;

import java.util.Hashtable;

public class Model {
	private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private final Hashtable<String, InterpolationMethod> _methods;
	
	private InterpolationMethod interpolationModel;
	
	public Model() {
		this._methods = new Hashtable<String, InterpolationMethod>();
		_methods.put(CS_METHOD, new CubicSpline());
		_methods.put(L_METHOD, new Lagrange());
		
	}
	
	public void addMethod(String string, InterpolationMethod inter) {
		_methods.put(string, inter);
	}
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod(String method) {
        switch (method) {
            case L_METHOD:
                interpolationModel = new Lagrange();
                break;
            case CS_METHOD:
                interpolationModel = new CubicSpline();
                break;
            default:
            	if(!this._methods.containsKey(method)) {
                	System.out.println("Unknown method " + method);
                } else {
                	interpolationModel = _methods.get(method);
                }
        }
    	  
        return interpolationModel;
    }
}
