package Q1.pubV0;

import java.util.ArrayList;

public class Drink implements Item {
	private String _name;
	private ArrayList<Ingredient> _ingredients;
	
	public Drink(String name) {
		this._name  = name;
		this._ingredients = new ArrayList<Ingredient>();
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String name) {
		this._name  = name;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this._ingredients.add(ingredient);
	}
	
	public void removeIngredient(Ingredient ingredient) {
		if(this._ingredients.contains(ingredient)) {
			this._ingredients.remove(ingredient);
		}
	}
	
	public double getPrice() {
		double price = 0;
		for(Ingredient ingredient : this._ingredients) {
			price = price + ingredient.getPrice();
		}
		return price;
	}
	
	public boolean equals(String other) {	
		
		return _name.equals(other);
	}
}
