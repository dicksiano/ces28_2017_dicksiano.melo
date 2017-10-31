package controller;
import model.PersonMVC;
import view.PersonDetailViewMVC;
import view.PersonDetailViewListenerMVC;

public class PersonDetailControllerImplMVC implements PersonDetailViewListenerMVC {

	public PersonDetailControllerImplMVC(PersonMVC person)
	{
		this.setModel(person);
		this.setView(person); 
	}

	@Override
	public void changedButtonPressed() {
		final String newName = _view.getNameFromTextField();
		if (isNotEmpty(newName))
		{	
			this.getModel().setName(newName);
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

	private PersonMVC _model;
	private PersonDetailViewMVC _view;
}
