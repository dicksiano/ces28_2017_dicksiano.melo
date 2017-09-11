package Q4;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class TesteControladorPTC {

	@Mock private Datacenter datacenterMock;
	@Mock private PainelCondutor painelCondutorMock;
	@Mock private Sensor sensorMock;
	private ControladorPTC controladorPTC;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controladorPTC = new ControladorPTC(sensorMock, datacenterMock, painelCondutorMock);
	}	
	
	
	/*@Test
	public void testInicializacaoControladorPTC()  {
		ControladorPTC controladorPTCSpy = Mock(this.controladorPTC);
		Mockito.verify(controladorPTCSpy).ControladorPTC(sensorMock, datacenterMock, painelCondutorMock);
	}*/
	
	@Test
	public void testTremNaoSeEncontraNoCruzamento()  {
		ControladorPTC controladorPTCSpy = Mockito.spy(this.controladorPTC);
		Mockito.when(sensorMock.isCruzamento()).thenReturn(false);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(5.0);
		controladorPTCSpy.run();
		
		
		Mockito.verify(controladorPTCSpy, Mockito.times(1)).enviaMsgDatacenter(new Double(5), datacenterMock);
		Mockito.verify(controladorPTCSpy, Mockito.times(1)).enviaMsgNormalPainel(new Double(5), painelCondutorMock);
	}
	
	@Test
	public void testTremNoCruzamentoVelocidadeSuperior100KM()  {
		ControladorPTC controladorPTCSpy = Mockito.spy(this.controladorPTC);
		Mockito.when(sensorMock.isCruzamento()).thenReturn(true);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(150.0);
		controladorPTCSpy.run();
		
		Mockito.verify(controladorPTCSpy,Mockito.times(1)).enviaMsgPrioritariaPainel("Velocidade alta", painelCondutorMock);
	}
	
	@Test
	public void testTremNoCruzamentoVelocidadeInferior20KM()  {
		ControladorPTC controladorPTCSpy = Mockito.spy(this.controladorPTC);
		Mockito.when(sensorMock.isCruzamento()).thenReturn(true);
		Mockito.when(sensorMock.getVelocidade()).thenReturn(15.0);
		controladorPTCSpy.run();
		
		Mockito.verify(controladorPTCSpy,Mockito.times(1)).enviaMsgPrioritariaPainel("Velocidade Baixa", painelCondutorMock);
	}
	
	
	
}