import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
	<applet code = "LoginScreen" width = 360 height = 180>
	</applet>
*/

public  class LoginScreen extends Applet implements ActionListener, FocusListener{
	Button okayButton;
	Button resetButton;
	Button cancelButton;
	TextField usernameField;
	TextField passwordField;
	Label usernameLabel;
	Label passwordLabel;
	Label titleLabel;
	Font innerFont;
	Font outerFont;
	Font titleFont;
	String username;
	String password;
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
		this.passwordField.setEchoChar('•');
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
		this.username = new String("aravind");
		this.password = new String("root");
	}
	public void start(){
		okayButton.addActionListener(this);
		resetButton.addActionListener(this);
		cancelButton.addActionListener(this);
		usernameField.addFocusListener(this);
		passwordField.addFocusListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == this.okayButton){
			if(usernameField.getText().equals(username) && passwordField.getText().equals(password)){
				showStatus("Login Successful");
			}
			else{
				showStatus("Invalid Username (or) Password ! Please Try Again !");
			}
		}
		else if(ae.getSource() == this.resetButton){
			usernameField.setText("Enter Username");
			passwordField.setText("********");
			showStatus("Login Aborted !");
		}
		else if(ae.getSource() == this.cancelButton){
			usernameField.setText("");
			passwordField.setText("");
			showStatus("Login Cancelled !");
		}
		else{}
	}
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
	public void focusLost(FocusEvent fe){}
	// public void stop(){}
	// public void destroy(){}
	// public void paint(Graphics graphic){}
}
