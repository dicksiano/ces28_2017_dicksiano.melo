package Q1.pubV0;

import java.util.ArrayList;

public class Pub {

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";
    
    private ArrayList<Item> _items;
    
    public Pub() {
    	this._items = new ArrayList<Item>();
    	
    	// Adicionar Beverages!
    	this._items.add(new Beverage("hansa",74));
    	this._items.add(new Beverage("grans",103));
    	this._items.add(new Beverage("strongbow",110));
    	
    	// Adicionar drinks!
    	
        Ingredient ingredient1 = new Ingredient("rum", 65); //one unit of rum
        Ingredient ingredient2 = new Ingredient("grenadine", 10); //one unit of grenadine
        Ingredient ingredient3 = new Ingredient("lime juice", 10); //one unit of lime juice
        Ingredient ingredient4 = new Ingredient("green stuff", 10); //one unit of green stuff
        Ingredient ingredient5 = new Ingredient("tonic water", 20); //one unit of tonic water
        Ingredient ingredient6 = new Ingredient("gin", 85); //one unit of gin
                   
        Drink drinkGt = new Drink("gt");
        drinkGt.addIngredient(ingredient4);
        drinkGt.addIngredient(ingredient5);
        drinkGt.addIngredient(ingredient6);  
        this._items.add(drinkGt);
        
        Drink  drinkBacardi = new Drink("bacardi_special");
        drinkBacardi.addIngredient(ingredient1);
        drinkBacardi.addIngredient(ingredient2);
        drinkBacardi.addIngredient(ingredient3);
        drinkBacardi.addIngredient(ingredient6);
        
    	this._items.add(drinkBacardi);
    	
    }
    
    private boolean isManyDrinks(String drink, int amount) {
    	return (amount > 2 && (drink == GT || drink == BACARDI_SPECIAL));
    }
    
    private boolean hasDiscount(String drink, boolean student) {
    	return (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER));
    }
    public int computeCost(String drink, boolean student, int amount) {

        if (isManyDrinks(drink,amount)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        double price = -1;
        for(Item item : this._items) {
        	if(item.equals(drink)) {
        		price = item.getPrice();
        	}
        }
        if(price == -1){
            throw new RuntimeException("No such drink exists");
        }
                
        if (hasDiscount(drink, student)) {
            price = price - price/10;
        }
        
        return (int) Math.ceil(price*amount);
    }
    
    public void addItem(Item item) {
    	this._items.add(item);
    }

    
}
