package utm_v1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Presenter.UTM_CTR;
import View.AnotherDrone;
import View.GCS;

public class TesteGCDConhecemOutrosDrones {
	private GCS gcsFirst = new GCS(UTM_CTR.getInstance());
	private GCS gcsSecond = new GCS(UTM_CTR.getInstance());
	private GCS gcsThird = new GCS(UTM_CTR.getInstance());
	
		
	/*
	 * Comandamos uma mudança no primeiro Drone e os outros GCSs devem 
	 * conhecer a nova posicao do primeiro drone
	 */
	@Test
	public void comandaVelocidadePrimeiroDroneOutrosGCSConhecemNovaPosicao() {
		gcsFirst.commandMoveX(10);
		gcsFirst.commandMoveY(5);
		gcsFirst.commandMoveZ(0);
		
		
		assertEquals(10.0, gcsThird.getAnotherDrones().get(1).getX(), 0.0001);
		assertEquals(5.0, gcsThird.getAnotherDrones().get(1).getY(), 0.0001);
		assertEquals(0.0, gcsThird.getAnotherDrones().get(1).getZ(), 0.0001);
		
		assertEquals(10.0, gcsSecond.getAnotherDrones().get(1).getX(), 0.0001);
		assertEquals(5.0, gcsSecond.getAnotherDrones().get(1).getY(), 0.0001);
		assertEquals(0.0, gcsSecond.getAnotherDrones().get(1).getZ(), 0.0001);
	}
}
