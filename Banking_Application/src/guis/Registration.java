package guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_objs.MyJDBC;

public class Registration extends Baseframe {

    public Registration() {
        super("Banking App Registration");
    }

    protected void addGuiComponents() {
        JLabel registrationLabel = new JLabel("User Registration");
        registrationLabel.setBounds(0, 20, super.getWidth(), 40);
        registrationLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        registrationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registrationLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 120, getWidth() - 30, 24);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 160, getWidth() - 50, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 220, getWidth() - 30, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 260, getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 360, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (MyJDBC.register(username, password)) {
                    JOptionPane.showMessageDialog(Registration.this, "Registration successful!");
                    Registration.this.dispose();
                    new Login().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Registration.this, "Registration failed...");
                }
            }
        });
        add(registerButton);
    }

	@Override
	protected void addGuiComponets() {
		// TODO Auto-generated method stub
		
	}
}
