package main;
import controller.PersonDetailControllerImplMVC;
import model.PersonMVC;

public class MainMVC {
	public static void main(String[] args) {
		PersonMVC p = new PersonMVC("Rhuan");
		new PersonDetailControllerImplMVC(p);
	}

}

