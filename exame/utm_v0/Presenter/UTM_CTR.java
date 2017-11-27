package Presenter;

import View.GCS;
import Model.Drone;

import java.util.Hashtable;

public class UTM_CTR {
	private static int _nextID = 0;
	private Hashtable<Integer, Drone> _drone = new Hashtable();
	private Hashtable<Integer, GCS> _gcs = new Hashtable();
	
	/*
	 * Construtor private para que não possa ser acessado externamente.
	 */
	private UTM_CTR() {}
	
	/*
	 * Singleton holder é a única classe que instancia um UTM_CTR.
	 */
    private static class SingletonHolder {
        private static final UTM_CTR _instance = new UTM_CTR();
    }
    /*
     * Método getInstance() fornece a possibilidade de que outros classes 
     * acessem o objeto UTM_CTR, mas esse objeto é único.
     * 
     */
    public static UTM_CTR getInstance() {
        return SingletonHolder._instance;
    }
    
    public int getNextID() {
    	_nextID = _nextID + 1;
    	return _nextID;
    }
    
    public void connectGCS(GCS gcs) {
    	Drone currentDrone = new Drone(this, 0,0,0, _nextID);
    	
    	_drone.put(_nextID, currentDrone); // Adiciona novo drone
    	
    	// Avisa para o novo GCS quais drones já estavam presentes
    	for( GCS oldGcs : _gcs.values()) {
    		gcs.addAnotherDrone(oldGcs.getID(), oldGcs.getMyDroneX(), oldGcs.getMyDroneY(), oldGcs.getMyDroneZ()); 
    	}
    	
    	// Avisa para os antigos GCS que um novo drone aparceu em (0,0,0)
    	for( GCS oldGcs : _gcs.values()) {
    		oldGcs.addAnotherDrone(_nextID,0,0,0); 
    	}
    	_gcs.put(_nextID, gcs);
    }
    
    public void moveDroneX(int ID, double delta) {
    	_drone.get(ID).moveX(delta);
    }
    public void moveDroneY(int ID, double delta) {
    	_drone.get(ID).moveY(delta);
    }
    public void moveDroneZ(int ID, double delta) {
    	_drone.get(ID).moveZ(delta);
    }
    
    public double getDroneX(int ID) {
		return _drone.get(ID).getX();
	}
	public double getDroneY(int ID) {
		return _drone.get(ID).getY();
	}
	public double getDroneZ(int ID) {
		return _drone.get(ID).getZ();
	}
	
	public void notifyChange(int ID, double x, double y, double z) {
		_gcs.get(ID).update(x,y,z); // Avisa mudança para o GCS associado
		
		// Avisa para os outros GCSs a sua nova posição
		for( GCS otherGcs : _gcs.values()) {
			if(otherGcs.getID() != ID) {
				otherGcs.updateAnotherDrone(ID,x,y,z); 
			}
    	}
	}
}
