import Presenter.UTM_CTR;
import View.AnotherDrone;
import View.GCS;

public class Main {

	public static void main(String[] args) {
		
		GCS gcsFirst = new GCS(UTM_CTR.getInstance());	// Primeiro gcs
														// Seu drone inicia em (0,0,0)
		
		GCS gcsSecond = new GCS(UTM_CTR.getInstance());	// Segundo gcs
														// Seu drone inicia em (0,0,0)	
		
		GCS gcsThird = new GCS(UTM_CTR.getInstance());	// Terceiro gcs
														// Seu drone inicia em (0,0,0)
		
		gcsFirst.commandMoveX(1);
		gcsFirst.commandMoveY(2);
		gcsFirst.commandMoveZ(0);
		
		gcsSecond.commandMoveX(4);
		gcsSecond.commandMoveY(5);
		gcsSecond.commandMoveZ(6);
		
		gcsThird.commandMoveX(7);
		gcsThird.commandMoveY(8);
		gcsThird.commandMoveZ(9);
		
		gcsFirst.commandMoveX(0);
		gcsFirst.commandMoveY(0);
		gcsFirst.commandMoveZ(3);
		
		/*
		 * A classe UTM_CTR é do tipo Singleton, isso resolve o problema 5.c
		 * Para detalhes de implementação veja a classe UTM_CTR e o método
		 * getInstance().
		 */
		
		/*
		 * Uma maneira de testar o funcionamento correto do sistema é comandar posições 
		 * diferentes para cada um dos Drones. No fim, eu devo checar se cada drone está
		 * na posição que eu espero que ele esteja.
		 * 
		 * Como pedido, foram criados 3 GCS. Cada um dele está associado a um Drone.
		 * Vou comandar uma posição diferente para cada Drone:
		 * 
		 * Drone 1: (x,y,z) = (1,2,3)
		 * Drone 2: (x,y,z) = (4,5,6)
		 * Drone 3: (x,y,z) = (7,8,9)
		 */
		
		System.out.println("Primeiro Drone - gcsFirst:\n" +
							"ID: " + gcsFirst.getID() + "\n" + 
							"A posição deve ser (1,2,3) e ela é: (" + 
							gcsFirst.getMyDroneX() + "," +
							gcsFirst.getMyDroneY() + "," +
							gcsFirst.getMyDroneZ() + ")\n" ); 
		
		System.out.println("Segundo Drone - gcsSecond:\n" +
				"ID: " + gcsSecond.getID() + "\n" + 
				"A posição deve ser (4,5,6) e ela é: (" + 
				gcsSecond.getMyDroneX() + "," +
				gcsSecond.getMyDroneY() + "," +
				gcsSecond.getMyDroneZ() + ")\n" ); 
		
		
		System.out.println("Terceiro Drone  - gcsThird:\n" +
				"ID: " + gcsThird.getID() + "\n" + 
				"A posição deve ser (7,8,9) e ela é: (" + 
				gcsThird.getMyDroneX() + "," +
				gcsThird.getMyDroneY() + "," +
				gcsThird.getMyDroneZ() + ")\n" ); 
		
		/*
		 * Quando cada drone mudar de posição, todos  GCSs são notificados.
		 * Logos, além de saber a posição do seu próprio Drone, cada GCS
		 * deve saber a posicao dos outros drones.
		 */
		
		System.out.println("Primeiro GCS deve conhecer a posição dos outros Drones:");
		for( AnotherDrone anotherDrone : gcsFirst.getAnotherDrones().values()) {
			System.out.println("ID: " + anotherDrone.getID() + 
					" - Posicao de acordo com o primeiro GCS: (" + anotherDrone.getX()
					+ "," + anotherDrone.getY()
					+ "," + anotherDrone.getZ() + ")");
		}
		
		System.out.println("Sgundo GCS deve conhecer a posição dos outros Drones:");
		for( AnotherDrone anotherDrone : gcsSecond.getAnotherDrones().values()) {
			System.out.println("ID: " + anotherDrone.getID() + 
					" - Posicao de acordo com o segundo GCS: (" + anotherDrone.getX()
					+ "," + anotherDrone.getY()
					+ "," + anotherDrone.getZ() + ")");
		}
		
		System.out.println("Terceiro GCS deve conhecer a posição dos outros Drones:");
		for( AnotherDrone anotherDrone : gcsThird.getAnotherDrones().values()) {
			System.out.println("ID: " + anotherDrone.getID() + 
					" - Posicao de acordo com o terceiro GCS: (" + anotherDrone.getX()
					+ "," + anotherDrone.getY()
					+ "," + anotherDrone.getZ() + ")");
		}
		
	}
}
