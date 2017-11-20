import java.io.File;

import model.Model;
import presenter.Presenter;
import view.View;

public class MyInterpolationAppMVP {
	public static void main(String[] args) {
		
		View view = new View();
				
		view.setMethod("Lagrange");// RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		view.setXInput(10.3f);// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		view.setFileInput("./data.dat");// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		
		view.printResult();
		
		View view2 = new View(); // Troquei a instância de View
		
		view2.setMethod("Lagrange");// RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		view2.setXInput(7.3f);// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		view2.setFileInput("./data.dat");// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		
		view2.printResult();
	}
}
