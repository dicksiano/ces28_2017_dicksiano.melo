package Q1.pubV0;

public class Beverage implements Item {
	private String _name;
	private double _price;
	
	public Beverage(String name, int price) {
		this._name = name;
		this._price = price;
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String name) {
		this._name  = name;
	}
	
	public void setPrice(int price) {
		this._price = price;
	}
	
	public double getPrice() {
		return this._price;
	}
	
	public boolean equals(String other) {		
		
		return _name.equals(other);
	}
	
}
