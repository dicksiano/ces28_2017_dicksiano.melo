package main;
import controller.PersonDetailControllerImpl;
import model.PersonMVC;

public class Main {
	public static void main(String[] args) {
		PersonMVC p = new PersonMVC("Rhuan");
		new PersonDetailControllerImpl(p);
	}

}

