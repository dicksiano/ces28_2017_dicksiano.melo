package lab01;

public class Money implements MoneyInterface{
	public Money(Currency currency, int amount) {
		this._currency = currency;
		this._amount = amount;
	}
	public MoneyInterface add(Money m) {
		if(m.equals(this) ) {
			Money money = new Money(this.getCurrency(), this.getAmount() + m.getAmount());
			return (Money)money;
		} else {
			MoneyBag moneyBag = new MoneyBag();
			moneyBag.add(m);
			moneyBag.add(this);
			return (MoneyBag) moneyBag;
		}
	}
	public int getAmount() 	{
		return _amount;
	}
	public void setAmount(int amount) {
		this._amount = amount;
	}
	public Currency getCurrency() { 
		return _currency;
	}
	public void setCurrency(Currency currency) { 
		this._currency = currency;
	}
	public boolean equals(Object anObject) {
		if (!(anObject instanceof Money))
			return false;
		
		Money otherMoney = (Money) anObject;
		
		if(_amount == 0 && otherMoney.getAmount() == 0) {
			return true;
		}
		
		return _currency.equals(otherMoney.getCurrency());
	}
	public String toString() {
		String ans = new String();
		
		ans += this.getCurrency().getName();
		ans += " ";
		ans += this.getAmount();
		ans += "\n";

		return ans;
	}
	public int convertToBRL() {
		if(this._currency.getName() == "USD") {
			return this._amount * 3;
		} else if(this._currency.getName() == "CHF") {
			return this._amount * 2;
		} else {
			return this._amount * 1;
		}
	}
	
	private int _amount;
	private Currency _currency;
}
