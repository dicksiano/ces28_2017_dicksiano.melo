package Q4.fim;

import java.util.Iterator;


public class Calculadora {
	public float calcularTotal(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
		}
		return totalDespesa;
	}
}

