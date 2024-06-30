package guis;

import javax.swing.JFrame;

import db_objs.User;


public abstract class Baseframe extends JFrame
{
	
	//store user information
	protected  User user;
	
	public Baseframe(String tittle)
	{
		initialize(tittle) ;
	}
	
	public Baseframe(String tittle , User user)
	{
		this.user = user ;
		
		initialize(tittle);
		
	}
	private void initialize(String tittle)
	{
		//tittle od the bar
		setTitle(tittle);
		// set size (pixels)
		setSize(420 , 600 );
		//Exit the panel 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// allows manully to specify the size and position 
		setLayout(null);
		// prevent gui from resized 
		setResizable(false);
		// Start in Center 
		setLocationRelativeTo(null);
		//calling sub class 
		addGuiComponets();
		
	}
	
	protected abstract void addGuiComponets();
}
