package View;

import java.util.Hashtable;

import Presenter.UTM_CTR;

public class GCS {
	private UTM_CTR _utm_ctr;
	private int _ID;
	private double _myDroneX, _myDroneY, _myDroneZ;
	private Hashtable<Integer, AnotherDrone> _anotherDrones = new Hashtable();
	
	public GCS(UTM_CTR utm_ctr) {
		this._utm_ctr = utm_ctr;
		this._ID = utm_ctr.getNextID();
		utm_ctr.connectGCS(this);
	}
	
	public int getID() {
		return this._ID;
	}
	public void commandMoveX(double delta) {
		this._utm_ctr.moveDroneX(_ID,delta);
	}
	
	public void commandMoveY(double delta) {
		this._utm_ctr.moveDroneY(_ID,delta);
	}
	
	public void commandMoveZ(double delta) {
		this._utm_ctr.moveDroneZ(_ID,delta);
	}
	
	public double getMyDroneX() {
		return this._myDroneX;
	}
	public double getMyDroneY() {
		return this._myDroneY;
	}
	public double getMyDroneZ() {
		return this._myDroneZ;
	}
	
	public void update(double x, double y, double z) {
		this._myDroneX = x;
		this._myDroneY = y;
		this._myDroneZ = z;
	}
	
	public void addAnotherDrone(int ID, double x, double y, double z) {
		this._anotherDrones.put(ID, new AnotherDrone(ID,x,y,z));
	}
	
	public void updateAnotherDrone(int ID, double x, double y, double z) {
		this._anotherDrones.get(ID).updatePosition(x, y, z);
	}
	
	public Hashtable<Integer, AnotherDrone> getAnotherDrones() {
		return _anotherDrones;
	}
}
