package Model;

import Presenter.UTM_CTR;

public class Drone {
	private double _x;
	private double _y;
	private double _z;
	private int _ID;
	private UTM_CTR _utm_ctr;
	
	public Drone(UTM_CTR utm_ctr, double x, double y, double z, int ID) {
		this._utm_ctr = utm_ctr;
		this._ID = ID;
		this._x = x;
		this._y = y;
		this._z = z;
	}
	
	public double getX() {
		return this._x;
	}
	
	public double getY() {
		return this._y;
	}
	
	public double getZ() {
		return this._z;
	}
	
	public void moveX(double delta) {
		this._x += delta;
		this._utm_ctr.notifyChange(this._ID, this._x, this._y,this._z);
		
	}
	
	public void moveY(double delta) {
		this._y += delta;
		this._utm_ctr.notifyChange(this._ID, this._x, this._y,this._z);
	}
	
	public void moveZ(double delta) {
		this._z += delta;
		this._utm_ctr.notifyChange(this._ID, this._x, this._y,this._z);
	}

}
