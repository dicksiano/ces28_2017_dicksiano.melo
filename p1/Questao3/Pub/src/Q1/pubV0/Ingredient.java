package Q1.pubV0;

public class Ingredient {
	private String _name;
	private double _price;
	
	public Ingredient(String name, int price) {
		this._name = name;
		this._price = price;
	}
	
	public double getPrice() {
		return this._price;
	}
	
	public String getName() {
		return this._name;
	}
}
