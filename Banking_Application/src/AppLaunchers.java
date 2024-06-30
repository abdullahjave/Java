import java.math.BigDecimal;

import javax.swing.SwingUtilities;

import db_objs.User;
import guis.BankingApp;
import guis.Login;
import guis.Registration;
import guis.Registration;

public class AppLaunchers {

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run() {
					new Login().setVisible(true);
					
//					new Registration().setVisible(true);
//					new BankingApp(
//							new User(1,"username","Password", new BigDecimal("20.00"))).setVisible(true);
			}
		});
	}

}
