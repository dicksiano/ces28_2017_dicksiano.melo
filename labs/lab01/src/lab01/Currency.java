package lab01;

public class Currency {
	public Currency(String name) {
		this._name = name;
	}
	public String getName() {
		return this._name;
	}
	public boolean equals(Object anObject) {
		if (!(anObject instanceof Currency))
			return false;
		Currency otherCurrency = (Currency) anObject;
		
		return _name.equals(otherCurrency.getName());
	}
	String _name;
}
