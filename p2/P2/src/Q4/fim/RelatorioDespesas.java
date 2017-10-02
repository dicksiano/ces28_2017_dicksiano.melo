package Q4.fim;

import java.util.Iterator;

public class RelatorioDespesas {
	public RelatorioDespesas(Calculadora calculadora, SistemaOperacional sistemaOperacional) {
		_calculadora = calculadora; // Nao faz sentido RelatorioDespesas instanciar Calculadora,
									// pois ela não é um Creator
		_so = sistemaOperacional; // Nao faz sentido RelatorioDespesas instanciar SistemaOperacional,
								  // pois ela não é um Creator
	}
	
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = this._calculadora.calcularTotal(despesas); // Calculadora tem responsabilidade única
		
		
		String conteudo = "Relatorio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);

		this._so.getDriverImpressao().Imprimir(conteudo); // Sistema Operacional, assim como Impressora, tem 
														// responsabilidade única
		
														// Observe que RelatorioDespesas é transparente
														// perante o tipo de Impressora, ou seja, ele funciona
														// com qualquer impressora
	}																	
		
	private Calculadora _calculadora;
	private SistemaOperacional _so;
}