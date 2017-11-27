package utm_v1;

import Presenter.UTM_CTR;
import View.AnotherDrone;
import View.GCS;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Teste3Drones {
	private GCS gcsFirst = new GCS(UTM_CTR.getInstance());
	private GCS gcsSecond = new GCS(UTM_CTR.getInstance());
	private GCS gcsThird = new GCS(UTM_CTR.getInstance());
	
	/*
	 * O primeiro GCS vai comandar uma velocidade para a coordenada X.
	 * As outras coordenadas devem permanecer em 0.
	 */
	@Test
	public void comandaVelocidadeXPrimeiroDrone() {
		gcsFirst.commandMoveX(1);
		assertEquals(1.0, gcsFirst.getMyDroneX(), 0.0001);
		
		assertEquals(0.0, gcsFirst.getMyDroneY(), 0.0001);
		assertEquals(0.0, gcsFirst.getMyDroneZ(), 0.0001);
	}
	
	/*
	 * O primeiro GCS vai comandar uma velocidade para a coordenada Y.
	 * As outras coordenadas devem permanecer em 0.
	 */
	@Test
	public void comandaVelocidadeYPrimeiroDrone() {
		gcsFirst.commandMoveY(1);
		assertEquals(1.0, gcsFirst.getMyDroneY(), 0.0001);
		
		assertEquals(0.0, gcsFirst.getMyDroneX(), 0.0001);
		assertEquals(0.0, gcsFirst.getMyDroneZ(), 0.0001);
	}
	
	/*
	 * O primeiro GCS vai comandar uma velocidade para a coordenada Z.
	 * As outras coordenadas devem permanecer em 0.
	 */
	@Test
	public void comandaVelocidadeZPrimeiroDrone() {
		gcsFirst.commandMoveZ(1);
		assertEquals(1.0, gcsFirst.getMyDroneZ(), 0.0001);
		
		assertEquals(0.0, gcsFirst.getMyDroneY(), 0.0001);
		assertEquals(0.0, gcsFirst.getMyDroneX(), 0.0001);
	}
	
	/*
	 * Comandamos uma mudança no primeiro Drone e os outros devem permanecer na 
	 * posição inicial (0,0,0)
	 */
	@Test
	public void comandaVelocidadePrimeiroDroneOutrosPermacemParados() {
		gcsFirst.commandMoveX(10);
		gcsFirst.commandMoveY(5);
		gcsFirst.commandMoveZ(0);
		
		
		assertEquals(10.0, gcsFirst.getMyDroneX(), 0.0001);
		assertEquals(5.0, gcsFirst.getMyDroneY(), 0.0001);
		assertEquals(0.0, gcsFirst.getMyDroneZ(), 0.0001);
		
		assertEquals(0.0, gcsSecond.getMyDroneX(), 0.0001);
		assertEquals(0.0, gcsSecond.getMyDroneY(), 0.0001);
		assertEquals(0.0, gcsSecond.getMyDroneZ(), 0.0001);
		
		assertEquals(0.0, gcsThird.getMyDroneX(), 0.0001);
		assertEquals(0.0, gcsThird.getMyDroneY(), 0.0001);
		assertEquals(0.0, gcsThird.getMyDroneZ(), 0.0001);
	}
	

	
	
	
}
