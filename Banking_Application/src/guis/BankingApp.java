package guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_objs.User;

public class BankingApp extends Baseframe implements ActionListener {
	
	private JTextField currentBalanceField;
	public JTextField getCurrentBalanceField()
	{
		return currentBalanceField;
	};
	public BankingApp(User user) 
	{
		super("Banking App" , user);
	}

	@Override
	protected void addGuiComponets() 
	{
		
		// Creating wellcome pade
		String welcomeMessageString = "<html>" + 
		"<body style='text-align:center'>" +
				"<b>Hello " + user.getUsername() + "</b><br>" +
		"What would you like to do today?</body></html>" ;
		JLabel welcomeMessageJLabel = new JLabel(welcomeMessageString);
		welcomeMessageJLabel.setBounds(0 , 20 ,getWidth()-10 , 40);
		welcomeMessageJLabel.setFont(new Font("Dialog" ,Font.PLAIN, 16));
		welcomeMessageJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(welcomeMessageJLabel);
		
		// Create current Balance lab4l
		JLabel currentBalanceJLabel = new JLabel("Current Balance");
		currentBalanceJLabel.setBounds(0 , 80 ,getWidth()-10 , 30);
		currentBalanceJLabel.setFont(new Font("Dialog" ,Font.BOLD, 22));
		currentBalanceJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(currentBalanceJLabel);
		
		// creating current balance feild
		currentBalanceField = new JTextField("RS" + user.getCurrentBalance());
		currentBalanceField.setBounds(15 , 120 ,getWidth()-50 , 40);
		currentBalanceField.setFont(new Font("Dialog" ,Font.BOLD, 28));
		currentBalanceField.setHorizontalAlignment(SwingConstants.RIGHT);
//		Disable Eddit Currentprice
		currentBalanceField.setEditable(false);
		
		add(currentBalanceField);
		
		// deposit Button
		JButton depositButton = new JButton("Deposit");
		depositButton.setBounds(15 , 180 ,getWidth()-50 , 50);
		depositButton.setFont(new Font("Dialog" ,Font.BOLD, 22));
		depositButton.addActionListener(this);
		add(depositButton);
		// Withdraw Buton
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(15 , 250 ,getWidth() - 50 , 50);
		withdrawButton.setFont(new Font("Dialog" ,Font.BOLD, 22));
		withdrawButton.addActionListener(this);
		add(withdrawButton);
		// Transaction button
		JButton transactionButton = new JButton("Transaction");
		transactionButton.setBounds(15 , 320 ,getWidth() - 50 , 50);
		transactionButton.setFont(new Font("Dialog" ,Font.BOLD, 22));
		transactionButton.addActionListener(this);
		add(transactionButton);
		//transfer Button
		JButton transferButton = new JButton("Transfer");
		transferButton.setBounds(15 , 390 ,getWidth() - 50 , 50);
		transferButton.setFont(new Font("Dialog" ,Font.BOLD, 22));
		transferButton.addActionListener(this);
		add(transferButton);
		//Logout Button
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(15 , 500 ,getWidth() - 50 , 50);
		logoutButton.setFont(new Font("Dialog" ,Font.BOLD, 22));
		logoutButton.addActionListener(this);
		add(logoutButton);
		
		
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		
		// user pressed Logout button
		if(buttonPressed.equalsIgnoreCase("Logout"))
		{
			//return user to login gui
			new Login().setVisible(true);
			// Dispose of this gui
			this.dispose();
			// dont bother running rest of code
			return;
		}
		
		//other function
		BankappDialog bankappDialog = new BankappDialog(user , this );
		
//		bankappDialog.setTitle(buttonPressed);
////		bankappDialog.setVisible(true);
//		
//		if(buttonPressed.equalsIgnoreCase("Logout"))
//		{
//			//return user to login gui
//			new Login().setVisible(true);
//			// Dispose of this gui
//			this.dispose();
//			// dont bother running rest of code
//			return;
//		}
		
		//other function
//		BankappDialog bankappDialog = new BankappDialog(user , this );
		// tittle set hoga har Button ke sath
		bankappDialog.setTitle(buttonPressed);
		if(buttonPressed.equalsIgnoreCase("Deposit") || buttonPressed.equalsIgnoreCase("Withdraw") || buttonPressed.equalsIgnoreCase("Transfer"))
		{
			bankappDialog.addCurrentBalandAmount();
			//add Action Button
			bankappDialog.addActionButton(buttonPressed);
//			bankappDialog.setVisible(true);
			
			// for the Transfer Action 
			if (buttonPressed.equalsIgnoreCase("Transfer") )
			{
				bankappDialog.addUserField();
			}
			bankappDialog.setVisible(true);
		} 
	}
	
}
