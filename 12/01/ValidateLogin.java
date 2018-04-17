import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import java.lang.*;

	// <applet code = "ValidateLogin" width = 360 height = 180>
	// </applet>

public  class ValidateLogin extends Applet implements ActionListener, FocusListener{
	// Buttons
	Button okayButton;
	Button resetButton;
	Button cancelButton;

	// Text Fields
	TextField usernameField;
	TextField passwordField;

	// Labels
	Label usernameLabel;
	Label passwordLabel;
	Label titleLabel;

	// Fonts
	Font innerFont;
	Font outerFont;
	Font titleFont;

	// Input Strings
	// String username;
	// String password;

	// validate boolean
	public boolean validate;

	// SQL objects
	Connection connection;
	Statement statement;
	ResultSet resultset;

	// initialisation
	public void init(){
		this.setLayout(null);
		this.okayButton = new Button("OK");
		this.resetButton = new Button("RESET");
		this.cancelButton = new Button("CANCEL");
		this.usernameField = new TextField("Enter Username");
		this.passwordField = new TextField("Enter Password");
		this.usernameLabel = new Label("Username : ");
		this.passwordLabel = new Label("Password : ");
		this.titleLabel = new Label("USER LOGIN");
		this.innerFont = new Font("Monospace", Font.BOLD, 14);
		this.outerFont = new Font("Fira Code", Font.BOLD, 18);
		this.titleFont = new Font("Consolas", Font.BOLD, 24);
		this.okayButton.setFont(this.outerFont);
		this.resetButton.setFont(this.outerFont);
		this.cancelButton.setFont(this.outerFont);
		this.usernameLabel.setFont(this.outerFont);
		this.passwordLabel.setFont(this.outerFont);
		this.titleLabel.setFont(this.titleFont);
		this.usernameField.setFont(this.innerFont);
		this.passwordField.setFont(this.innerFont);
		this.passwordField.setEchoChar('•');					// U+2022
		this.titleLabel.setBounds(0, 10, 360, 30);
		this.titleLabel.setAlignment(Label.CENTER);
		this.usernameLabel.setBounds(20, 60, 160, 20);
		this.usernameField.setBounds(180, 60, 160, 20);
		this.passwordLabel.setBounds(20, 100, 160, 20);
		this.passwordField.setBounds(180, 100, 160, 20);
		this.cancelButton.setBounds(20, 140, 100, 20);
		this.resetButton.setBounds(130, 140, 100, 20);
		this.okayButton.setBounds(240, 140, 100, 20);
		add(this.titleLabel);
		add(this.usernameLabel);
		add(this.usernameField);
		add(this.passwordLabel);
		add(this.passwordField);
		add(this.cancelButton);
		add(this.resetButton);
		add(this.okayButton);
		// this.username = new String("");
		// this.password = new String("");
		this.validate = false;
		// try{
		// 	Class.forName("com.mysql.jdbc.Driver").newInstance();
		// 	this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123456");
		// }
		// catch(Exception e){
		// 	e.printStackTrace();
		// }
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception c){
			System.out.print(c);
		}
	}

	// start method
	public void start(){
		okayButton.addActionListener(this);
		resetButton.addActionListener(this);
		cancelButton.addActionListener(this);
		usernameField.addFocusListener(this);
		passwordField.addFocusListener(this);
		// try{

		// }
		// catch(Exception e){
			// e.printStackTrace();
		// }
	}

	// actionPerformed method for ActionListener
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == this.okayButton){
			// this.username = usernameField.getText();
			// this.password = passwordField.getText();
			try{
				checkLogin(this.usernameField.getText(), this.passwordField.getText());
			}
			catch(Exception e){
				System.out.println(e);
			}
			if(this.validate){
				showStatus("Login Validated using Database !");
			}
			else{
				showStatus("Invalid Username (or) Password !");
			}
		}
		else if(ae.getSource() == this.resetButton){
			usernameField.setText("Enter Username");
			passwordField.setText("********");
			showStatus("Login Aborted !");
			// this.username = new String("");
			// this.password = new String("");
			this.validate = false;
		}
		else if(ae.getSource() == this.cancelButton){
			usernameField.setText("");
			passwordField.setText("");
			showStatus("Login Cancelled !");
			// this.username = new String("");
			// this.password = new String("");
			this.validate = false;
		}
		else{}
	}

	// focusGained method for FocusListener
	public void focusGained(FocusEvent fe){
		if(fe.getSource() == this.usernameField){
			usernameField.setText("");
			showStatus("Enter a valid User Name !");
		}
		else if(fe.getSource() == this.passwordField){
			passwordField.setText("");
			showStatus("Enter the Password for Username: " + usernameField.getText() + " !");
		}
		else{}
	}

	// focusLost method for FocusListener
	public void focusLost(FocusEvent fe){}

  public void checkLogin(String username, String password) throws SQLException{
		this.validate = false;
		// String databaseUsername;
		// String databasePassword;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","123456");
			this.statement = connection.createStatement();
			this.resultset = statement.executeQuery("select * from credential");
			while(this.resultset.next()){
				if(username.equals(new String(resultset.getString("username"))) && password.equals(new String(resultset.getString("password")))){
					this.validate = true;
					break;
				}
				// System.out.println(resultset.getInt(1) + "  " + resultset.getString(2));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
