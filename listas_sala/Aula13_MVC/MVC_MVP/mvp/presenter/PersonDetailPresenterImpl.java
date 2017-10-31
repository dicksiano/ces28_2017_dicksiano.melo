package presenter;

import java.util.ArrayList;
import java.util.List;

import model.PersonMVC;
import model.Person.PersonListener;
import view.PersonDetailViewMVC;
import view.PersonDetailViewListenerMVC;

public class PersonDetailPresenterImpl implements PersonDetailViewListenerMVC {

	public PersonDetailPresenterImpl(PersonMVC person)
	{
		this.setModel(person);
		this.setView(person); 
	}

	@Override
	public void changedButtonPressed() {
		final String newName = _view.getNameFromTextField();
		if (isNotEmpty(newName))
		{	
			this.getModel().setName(getSizedName(getValidName(newName)));
		}
	}
	
	@Override
	public void windowClosed() {
		System.exit(0);
	}
	
	protected PersonDetailViewMVC getView() {
		return _view;
	}
	
	protected void setView(PersonMVC person){
		_view = new PersonDetailViewMVC(person, this);
		this.getView().display();
	}
	
	protected PersonMVC getModel() {
		return _model;
	}

	protected void setModel(PersonMVC model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}
	
	private String getValidName(String name) {
		name = name.replaceAll("[^a-zA-Z]+","");
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		return name;
	}
	
	private String getSizedName(String name) {
		if(name.length() <= 6) {
			return "VERMELHO" + name;
		} else if(name.length() <= 10) {
			return "VERDE" + name;			
		} else {
			return "AMARELO" + name;
		}
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	public void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private PersonMVC _model;
	private PersonDetailViewMVC _view;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
