package View;

public class AnotherDrone {
	private double _x, _y, _z;
	private int _ID;
	
	public AnotherDrone(int ID, double x, double y, double z) {
		this._ID = ID;
		this._x = x;
		this._y = y;
		this._z = z;
	}
	
	public void updatePosition(double x, double y, double z) {
		this._x = x;
		this._y = y;
		this._z = z;		
	}
	
	public int getID() { 
		return this._ID;
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
	
}
