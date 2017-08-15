package lab01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagUnitTests {
	private Currency testCurrencyBRL = new Currency("BRL");
	private Currency testCurrencyUSD = new Currency("USD");
	private Currency testCurrencyCHF = new Currency("CHF");
	private MoneyBag testMoneyBag = new MoneyBag();
	private Money testMoneyA = new Money(testCurrencyBRL, 0);
	private Money testMoneyB = new Money(testCurrencyBRL, 0);
	private Money testMoneyC = new Money(testCurrencyBRL, 0);
	
	@Before
	public void setUp() {		
		testMoneyA.setAmount(1);
		testMoneyA.setCurrency(testCurrencyBRL);
		testMoneyB.setAmount(10);
		testMoneyB.setCurrency(testCurrencyUSD);
		testMoneyC.setAmount(100);
		testMoneyC.setCurrency(testCurrencyCHF);
		
		testMoneyBag.add(testMoneyA);
		testMoneyBag.add(testMoneyB);
	}
	
	@Test
	public void checkInitialMoneyBag() {
		assertTrue(testMoneyBag.getMonies().containsValue(testMoneyA));
		assertTrue(testMoneyBag.getMonies().containsValue(testMoneyB));
		assertFalse(testMoneyBag.getMonies().containsValue(testMoneyC));
	}
	
	@Test 
	public void checkSize() {
		assertEquals(testMoneyBag.size(),2);
	}
	
	@Test
	public void checkContains() {
		assertTrue(testMoneyBag.contains(testMoneyA));
		assertTrue(testMoneyBag.contains(testMoneyB));
		assertFalse(testMoneyBag.contains(testMoneyC));
	}
	
	@Test
	public void checkToString() {
		assertEquals(testMoneyBag.toString(), "BRL 1\nUSD 10\n");
	}
	@Test
	public void checkAddMoneyBag() {
		Money auxiliarMoneyA = new Money(testCurrencyBRL, 5);
		Money auxiliarMoneyB = new Money(testCurrencyUSD,50);
		
		testMoneyBag.add(auxiliarMoneyA);
		testMoneyBag.add(auxiliarMoneyB);
		
		assertEquals(testMoneyBag.getMonies().get(testCurrencyBRL).getAmount(),6);
		assertEquals(testMoneyBag.getMonies().get(testCurrencyUSD).getAmount(),60);
	}
	
	@Test
	public void checkGetTotal() {
		assertEquals(testMoneyBag.getTotal(), 31);
	}
}

