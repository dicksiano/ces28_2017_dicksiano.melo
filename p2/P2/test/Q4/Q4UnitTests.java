package Q4;


import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Q4.fim.Calculadora;
import Q4.fim.Despesa;
import Q4.fim.Impressora;
import Q4.fim.RelatorioDespesas;
import Q4.fim.SistemaOperacional;

public class Q4UnitTests {

	@Mock private Calculadora calculadoraMock;
	@Mock private Despesa despesaMock;
	@Mock private Impressora impressoraMock;
	@Mock private SistemaOperacional sistemaOperacionalMock;
	@Mock private Iterator<Despesa> despesasMock;
	private RelatorioDespesas relatorioDespesas;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		relatorioDespesas = new RelatorioDespesas(calculadoraMock, sistemaOperacionalMock);
	}	
	
	@Test
	public void testeRelatorioDespesas() {
		//Dado que eu sei o resultado esperado (resposta enlatada), eu sei como deve ser o
		// relatorio que a classe RelatorioDespesas deve imprimir
		String outputEsperado = "Relatorio de Despesas" + "\n Total das despesas:150.0";
		
		//Resposta enlatada de 150.0, pois eu não quero testar  a classe Calculadora e sim 
		// a classe RelatorioDespesas
		Mockito.when(calculadoraMock.calcularTotal(despesasMock)).thenReturn(150.0f);
		
		// Resposta enlatada como sendo o objeto impressoraMock, pois eu não quero testar SistemaOperacional
		// e sim a classe RelatorioDespesas
		// O teste permanece inalterado com as alterações do item C, pois eu enlatei a resposta do 
		// retorno de sistemaOperacionalMock.
		Mockito.when(sistemaOperacionalMock.getDriverImpressao()).thenReturn(impressoraMock);
		
		relatorioDespesas.ImprimirRelatorio(despesasMock);	// despesasMock é um fake object: utilizado apenas
															// como parâmetro
		
		Mockito.verify(impressoraMock, Mockito.times(1)).Imprimir(outputEsperado); // Se a função Imprimir() da
											// classe Impressora for chamada com o relatório esperado,
											// então a classe RelatorioDespesas cumpriu sua responsabilidade
	}
}
