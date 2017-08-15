package lab01;

import java.util.LinkedHashMap;

public class MoneyBag  implements MoneyInterface {
	public MoneyBag() {
		_monies = new LinkedHashMap<Currency,Money>();
	}
	
	public int size() { return _monies.size(); }
	
	public void add(Money m) { 
		if(this.contains(m)) {
			Money aux = new Money(m.getCurrency(), m.getAmount() + _monies.get(m.getCurrency()).getAmount());
			_monies.put(m.getCurrency(),aux);
		} else {
			_monies.put(m.getCurrency(),m);
		}
	}
	
	LinkedHashMap<Currency,Money> getMonies() { return _monies; }
	
	public boolean contains(Money m) {
		if(this._monies.get(m.getCurrency()) == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString() {
		String ans = new String();
		
		for (Money it : this._monies.values()) {
			ans += it.toString();
		}
		return ans;
	}
	
	public int getTotal() {
		int ans = 0;
		
		for (Money it : this._monies.values()) {
			ans += it.convertToBRL();
		}
		return ans;
	}
	private LinkedHashMap<Currency,Money> _monies;
}

