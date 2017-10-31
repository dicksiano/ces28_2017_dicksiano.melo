import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import controllerV2.PersonDetailControllerImplMVC;
import model.PersonMVC;

import org.mockito.InjectMocks;

import view.PersonDetailViewMVC;

public class testes {
	@Mock private PersonDetailViewMVC viewFake;
	@Mock private PersonMVC person;
	private PersonDetailControllerImplMVC controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new PersonDetailControllerImplMVC(person, viewFake);
	}
	
	@Test
	public void controllerNotNull() {
		assertNotNull(controller);
	}
	
	@Test
	public void controllerChangeButtonPressed() {
		Mockito.when(viewFake.getNameFromTextField()).thenReturn("Lionel Dick");
		controller.changedButtonPressed();
		
		Mockito.verify(viewFake, Mockito.times(1)).getNameFromTextField();
	}
}
