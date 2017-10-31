package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PersonMVC;
import model.PersonMVC.PersonListener;

@SuppressWarnings("serial")
public class PersonDetailViewMVC extends JPanel implements PersonListener, WindowListener{

	public PersonDetailViewMVC(PersonMVC person,
			PersonDetailViewListenerMVC personDetailController) {
		this.setPerson(person);
		this.setController(personDetailController);
		this.createUI();
		this.bindUI();
		this.populateView();
	}

	private void createUI() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.label = new JLabel();
		add(label, BorderLayout.NORTH);
	
		this.nameTextField = new JTextField();
		add(nameTextField);
		
		this.changeButton = new JButton(LABEL_CHANGE_BUTTON);
		add(changeButton);
	}
	
	private void bindUI() {
		this.getPerson().addListener(this);
		this.changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_controller.changedButtonPressed();
			}
		});
	}
	
	private void populateView() {
		if (nameIsNonNullAndNonVoidString())
			this.label.setText(LABEL + this.getPerson().getName());
		else this.label.setText(LABEL + "...");
	}
	
	public String getNameFromTextField()
	{
		return nameTextField.getText();
	}

	@Override
	public void onPersonNameChanged() {
		this.populateView();
	}
	
	public void display() {
		if (this.frame == null) {
			this.frame = new JFrame() {
				{
					setTitle(FRAME_TITLE );
					setLocationRelativeTo(null);
					setContentPane(PersonDetailViewMVC.this);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					addWindowListener(PersonDetailViewMVC.this);
					pack();
				}
			};
		}

		this.frame.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		this.getController().windowClosed();
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}
	
	protected PersonMVC getPerson() {
		return _person;
	}

	protected void setPerson(PersonMVC person) {
		_person = person;
	}

	public PersonDetailViewListenerMVC getController() {
		return _controller;
	}

	public void setController(PersonDetailViewListenerMVC controller) {
		_controller = controller;
	}

	public Boolean nameIsNonNullAndNonVoidString()
	{	if ((this.getPerson().getName() != null) & (this.getPerson().getName() != ""))
				return true;
		return false;
	}

	private static final String LABEL = "The person name is ";
	private static final String LABEL_CHANGE_BUTTON = "Change";
	private static final String FRAME_TITLE = null;
	
	private PersonMVC _person;
	private PersonDetailViewListenerMVC _controller;

	private JLabel label;
	private JTextField nameTextField;
	private JButton changeButton;
	private JFrame frame;
}
