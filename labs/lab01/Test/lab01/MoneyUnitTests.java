package lab01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyUnitTests {

	private Currency testCurrency = new Currency("BRL");
	private Currency auxiliarCurrencyUSD = new Currency("USD");
	private Currency auxiliarCurrencyCHF = new Currency("CHF");
	private Money testMoneyA = new Money(testCurrency,0);
	private Money testMoneyB = new Money(testCurrency,0);
	private Money testMoneyC = new Money(testCurrency,0);
	private Money testMoneyD = new Money(testCurrency,0);
	
	@Test
	public void checkCurrency() {
		Currency auxiliarCurrency = new Currency("BRL");
		
		assertTrue(testCurrency.getName() == "BRL");
		assertEquals(testCurrency, auxiliarCurrency);
	}
	@Test
	public void checkAddMoneyWithAssert() {
		Currency testCurrency = new Currency("USD");
		
		testMoneyA.setAmount(5);
		testMoneyA.setCurrency(testCurrency);
		
		testMoneyB.setAmount(20);
		testMoneyB.setCurrency(testCurrency); 
		
		Money result = (Money)testMoneyA.add(testMoneyB);
		assertTrue(result.getAmount() == 25);
		assertTrue(result.getCurrency().getName() == "USD");
	}
	
	@Test
	public void checkAddMoneyWithAssertEquals() {
		Currency testCurrency = new Currency("USD");
		
		testMoneyA.setAmount(5);
		testMoneyA.setCurrency(testCurrency);
		
		testMoneyB.setAmount(20);
		testMoneyB.setCurrency(testCurrency); 
		
		Money result = (Money)testMoneyA.add(testMoneyB);
		assertEquals(result.getAmount(), 25);
		assertEquals(result.getCurrency().getName(), "USD");
	}
	
	@Before
	public void setUp() {		
		testMoneyA.setAmount(1);
		testMoneyA.setCurrency(testCurrency);
		
		testMoneyB.setAmount(10);
		testMoneyB.setCurrency(testCurrency);
		
		testMoneyC.setAmount(0);
		testMoneyC.setCurrency(auxiliarCurrencyUSD);
		
		testMoneyD.setAmount(0);		
		testMoneyD.setCurrency(testCurrency);
	}
	
	@Test
	public void checkInitialMoney() {
		assertEquals(testMoneyA.getAmount(),1);
		assertEquals(testMoneyA.getCurrency().getName(),"BRL");
	}
	
	@Test
	public void checkAddMoneyWithAssertTrueUsingBefore() {
		Money result = (Money)testMoneyA.add(testMoneyB);
		assertTrue(result.getAmount() == 11);
		assertTrue(result.getCurrency().getName() == "BRL");
	}
	
	@Test
	public void checkAddMoneyWithAssertEqualsUsingBefore() {
		Money result = (Money)testMoneyA.add(testMoneyB);
		assertEquals(result.getAmount(),11);
		assertEquals(result.getCurrency().getName(),"BRL");
	}
	
	@Test
	public void checkEquals() {
		testMoneyB.setCurrency(auxiliarCurrencyUSD);
		assertFalse(testMoneyA.equals(testMoneyB));	
	}
	
	@Test
	public void checkEqualsBothWithZero() {
		assertTrue(testMoneyC.equals(testMoneyD));		
	}
	
	@Test
	public void checkToString() {
		assertEquals(testMoneyA.toString(),"BRL 1\n");
		assertEquals(testMoneyD.toString(),"BRL 0\n");
	}
	
	@Test
	public void checkConvertToBRL() {
		testMoneyB.setAmount(1);
		testMoneyB.setCurrency(auxiliarCurrencyUSD);
		testMoneyC.setAmount(1);
		testMoneyC.setCurrency(auxiliarCurrencyCHF);
		
		assertEquals(testMoneyA.convertToBRL(), 1);
		assertEquals(testMoneyB.convertToBRL(), 3);
		assertEquals(testMoneyC.convertToBRL(), 2);
	}
	
	@Test
	public void checkAddSameMoney() {
		Money result = (Money)testMoneyB.add(testMoneyA);
		assertTrue(result.getAmount() == 11);
		assertTrue(result.getCurrency().getName() == "BRL");
	}
	
	@Test
	public void checkAddDiferentMoney() {
		testMoneyB.setCurrency(auxiliarCurrencyUSD);
		MoneyBag result = (MoneyBag)testMoneyB.add(testMoneyA);
		
		assertTrue(result.contains(testMoneyA));
		assertEquals(result.getMonies().get(testCurrency).getAmount(), 1);
		assertTrue(result.contains(testMoneyB));
		assertEquals(result.getMonies().get(auxiliarCurrencyUSD).getAmount(), 10);
		assertEquals(result.size(),2);
	}
}

