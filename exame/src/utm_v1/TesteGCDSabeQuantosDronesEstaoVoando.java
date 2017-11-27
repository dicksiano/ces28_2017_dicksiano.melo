package utm_v1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Presenter.UTM_CTR;
import View.GCS;

public class TesteGCDSabeQuantosDronesEstaoVoando {
	private GCS gcsFirst = new GCS(UTM_CTR.getInstance());
	private GCS gcsSecond = new GCS(UTM_CTR.getInstance());
	private GCS gcsThird = new GCS(UTM_CTR.getInstance());
	
	/*
	 * Cada GCD sabe quantos outros drones estão no ar além do seu Drone
	 */
	@Test
	public void outrosGCDsSabemQuantosDronesEstaoVoando() {
		
		assertEquals(2, gcsFirst.getAnotherDrones().size());
		assertEquals(2, gcsSecond.getAnotherDrones().size());
		assertEquals(2, gcsThird.getAnotherDrones().size());
	}
}
