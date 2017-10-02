package Q4.fim;

public class SistemaOperacional {
	/*
	 * Em vez de sistema operacional retornar um tipo de impressora, ele deve retornar uma interface
	 * para que seja possivel imprimir o relatorio com qualquer tipo de impressora
	 */
	public InterfaceImpressora getDriverImpressao() {
		
		/* Nessa parte do código, o sistema operacional iria decidir qual
		 * impressora seria utilizada
		 * 
		 * 
		 * if(systemType == 1) {
		 * 	return new ImpressoraMatricial();
		 * }		 * 
		 * else if(systemType == 2) {
		 * 	return new ImpressoraJato();
		 * }
		 * 
		 * else if(systemType == 3) {
		 * 	return new ImpressoraLaser();
		 * }
		 * 
		 *  	...
		 */
		return new Impressora();
	}
}

