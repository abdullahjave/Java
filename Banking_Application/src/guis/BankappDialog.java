package guis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db_objs.MyJDBC;
import db_objs.Transaction;
import db_objs.User;

public class BankappDialog extends JDialog implements ActionListener {
    private User user;
    private BankingApp bankingapp;
    private JLabel balanceLabel, enterUserLabel, enterAmountJLabel;
    private JTextField enterAmountFeild;
    private JButton actionButton;
    private JTextField enterUserField;

    public BankappDialog(User user, BankingApp bankingapp) {
        setSize(400, 400);
        setModal(true);
        setLocationRelativeTo(bankingapp);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        this.bankingapp = bankingapp;
        this.user = user;

        addCurrentBalandAmount();
        addActionButton("Deposit");
    }

    public void addCurrentBalandAmount() {
        balanceLabel = new JLabel("Balance $ " + user.getCurrentBalance());
        balanceLabel.setBounds(0, 10, getWidth() - 20, 20);
        balanceLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel);

        enterAmountJLabel = new JLabel("Enter Amount:");
        enterAmountJLabel.setBounds(0, 50, getWidth() - 20, 20);
        enterAmountJLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterAmountJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountJLabel);

        enterAmountFeild = new JTextField();
        enterAmountFeild.setBounds(15, 80, getWidth() - 50, 40);
        enterAmountFeild.setFont(new Font("Dialog", Font.BOLD, 20));
        enterAmountFeild.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountFeild);
    }

    public void addActionButton(String actionButtonType) {
        actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Dialog", Font.BOLD, 20));
        actionButton.addActionListener(this);
        add(actionButton);
    }

    public void addUserField() {
        enterUserLabel = new JLabel("Enter User:");
        enterUserLabel.setBounds(0, 160, getWidth() - 20, 20);
        enterUserLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        enterUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserLabel);

        enterUserField = new JTextField();
        enterUserField.setBounds(0, 190, getWidth() - 50, 40);
        enterUserField.setFont(new Font("Dialog", Font.BOLD, 20));
        enterUserField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserField);
    }

    private void handleTransaction(String transactiontype, float amountval) {
        Transaction transaction;
        if (transactiontype.equalsIgnoreCase("Deposit")) {
            user.setCurrentBalance(user.getCurrentBalance().add(new BigDecimal(amountval)));
            transaction = new Transaction(user.getId(), transactiontype, new BigDecimal(amountval), null);
        } else {
            user.setCurrentBalance(user.getCurrentBalance().subtract(new BigDecimal(amountval)));
            transaction = new Transaction(user.getId(), transactiontype, new BigDecimal(-amountval), null);
        }

        if (MyJDBC.addTransactionToDatabase(transaction) && MyJDBC.updateCurrentBalance(user)) {
            JOptionPane.showMessageDialog(this, transactiontype + " Successfully ");
            resetFeildAndUpdateCurrentBalance();
        } else {
            JOptionPane.showMessageDialog(this, transactiontype + " Failed...");
        }
    }

    private void resetFeildAndUpdateCurrentBalance() 
    {
        enterAmountFeild.setText("");

        if (enterUserField != null) 
        {
            enterUserField.setText("");
        }

        balanceLabel.setText("Balance: $" + user.getCurrentBalance());
        bankingapp.getCurrentBalanceField().setText("$" + user.getCurrentBalance());
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        // Get the text from the amount field
        String amountText = enterAmountFeild.getText().trim();

        if (!amountText.isEmpty()) {
            try {
                float amountVal = Float.parseFloat(amountText);

                if (buttonPressed.equalsIgnoreCase("Deposit")) {
                    handleTransaction(buttonPressed, amountVal);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount format. Please enter a valid number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Amount field cannot be empty.");
        }
    }
}