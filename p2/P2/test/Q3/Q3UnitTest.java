package Q3;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q3.TireMonitor.Alarm;
import Q3.TireMonitor.ISensor;

public class Q3UnitTest {

	@Mock private ISensor iSensorMock; // Interface sendo mockada
	private Alarm alarm;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		alarm = new Alarm(iSensorMock);
	}	
	/*
	 * Testar se inicialmente o alarm está com a variável isAlarmOn como False (Caso inicial)
	 */
	@Test
	public void testeAlarmInitial() {
		assertFalse(alarm.isAlarmOn());
	}
	
	/*
	 * Casos em que alarm deve estar OFF 
	 */
	@Test
	public void testeAlarmMustBeOff() {
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(18.0);
		alarm.check();
		alarm.check();
		assertFalse(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(19.3);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(20.1);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(20.81);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	/*
	 * Casos em que deve estar OFF - limites: 17.0 e 21.0
	 */
	@Test
	public void testeAlarmMustBeOffBoundaries() {
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(17.0);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(21.0);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	/*
	 * Casos em que o alarm deve estar ON
	 */
	@Test
	public void testeAlarmMustBeOn() {
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(16.0);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(16.3);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(-21.1);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		Mockito.when(iSensorMock.popNextPressurePsiValue()).thenReturn(30.81);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
}
