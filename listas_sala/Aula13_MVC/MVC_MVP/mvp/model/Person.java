package model;

import presenter.PersonDetailPresenterImpl;

public class Person {
	public interface PersonListener {
		void onPersonNameChanged();
	}
	
	public Person()
	{
	
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
		_presenter.fireOnNameChanged();
	}

	public void setPresenter(PersonDetailPresenterImpl presenter) {
		_presenter = presenter;
	}
	
	private String _name;
	private PersonDetailPresenterImpl _presenter;
}
