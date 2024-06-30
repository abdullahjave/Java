package guis;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import db_objs.MyJDBC;
import db_objs.User;

// Allows user to launch the Register gui or login 
public class Login extends Baseframe 
{
	public Login() 
	{
		super("Banking App Login");
	}

	@Override
	protected void addGuiComponets() 
	{
		// This is the Tittle Setting 
		
		// Label created
		JLabel bankingappLabel = new JLabel("Banking Application");
		//Set location and size   x   y                      height
		bankingappLabel.setBounds(0 , 20 , super.getWidth() , 40);
		
		bankingappLabel.setFont(new Font("Dialog", Font.BOLD , 32));
		
		bankingappLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(bankingappLabel);
		
		// Username Label on GUI
		
		JLabel usernameLabel = new JLabel("Username");
		
		usernameLabel.setBounds(20 ,120 , getWidth()-30, 24 );
	
		usernameLabel.setFont(new Font("Dialog" , Font.PLAIN , 20));
		add(usernameLabel);
		
		// create user name text feilds 
		JTextField usernameField = new JTextField();
		
		usernameField.setBounds(20 ,160 ,getWidth()-50 , 40);
		
		usernameField.setFont(new Font("Dialog" , Font.PLAIN ,20));
		add(usernameField);
		
		//creating password label 
		JLabel passwordLabel = new JLabel("Password");
		
		passwordLabel.setBounds(20 ,280 , getWidth()-50 , 24);
		
		passwordLabel.setFont(new Font("Dialog", Font.PLAIN , 20));
		add(passwordLabel);
		
		// creating Tect feild of Password
		JPasswordField passwordFeild = new JPasswordField();
		passwordFeild.setBounds(20 ,320 , getWidth()-50, 40 );
		
		passwordFeild.setFont(new Font("Dialog" , Font.PLAIN , 20));
		add(passwordFeild);
		
//		//create login button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(20 ,460 , getWidth()-50, 40 );
		
		loginButton.setFont(new Font("Dialog" , Font.BOLD , 20));
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String username = usernameField.getText();
				
				//get password
				String password = String.valueOf(passwordFeild.getPassword());
				
				//validate login
				User user = MyJDBC.validatelogin(username, password);
			
				if(user != null)
				{
					Login.this.dispose();
					
					// lanch bank app gui 
					BankingApp bankingApp = new BankingApp(user);
					bankingApp.setVisible(true);
					
					// Show success dialog
					JOptionPane.showMessageDialog(bankingApp, "Login Successfully!");
				}
				else 
				{
					JOptionPane.showMessageDialog(Login.this, "Login failed...");
				}
					
			}
		});
		
		add(loginButton);
		
		//creating Register label 
		
		JLabel registerationJLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>");
		registerationJLabel.setBounds(8, 510, getWidth() - 10, 30);

		registerationJLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		registerationJLabel.setHorizontalAlignment(SwingConstants.CENTER);
	
		//When we Click on register here text :  Mouse Clicked Event launch register gui
		registerationJLabel.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				//dispose of the gui
				Login.this.dispose();
				
				// launch the register ggui
				new Registration().setVisible(true);
			}
		});
		
		add(registerationJLabel);
		
		
		
	}
}
