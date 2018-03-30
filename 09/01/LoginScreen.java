import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
	<applet code = "LoginScreen" width = 360 height = 180>
	</applet>
*/

public  class LoginScreen extends Applet{
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
		this.titleFont = new Font("Herculanum", Font.BOLD, 24);
		this.okayButton.setFont(this.outerFont);
		this.resetButton.setFont(this.outerFont);
		this.cancelButton.setFont(this.outerFont);
		this.usernameLabel.setFont(this.outerFont);
		this.passwordLabel.setFont(this.outerFont);
		this.titleLabel.setFont(this.titleFont);
		this.usernameField.setFont(this.innerFont);
		this.passwordField.setFont(this.innerFont);
		this.passwordField.setEchoChar('•');
		this.titleLabel.setBounds(120, 10, 200, 20);
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
	}
	public void start(){

	}
	public void stop(){

	}
	public void destroy(){

	}
	public void paint(Graphics graphic){

	}
}

/*	OLD PRG:
class Auth extends Frame{
	Button okbtn = new Button("OK");
	Button cancelbtn = new Button("CANCEL");
	Label lbl = new Label("SASTRA DEEMED TO BE UNIVERSITY");
	TextField usertf = new TextField("Enter Username");
	TextField passtf = new TextField("Enter Password");
	Panel p = new Panel();
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Label user = new Label("Username:");
	Label pass = new Label("Password");
	Font original;
	Font trb = new Font("TimesRoman", Font.BOLD, 12);
	Auth(){
		original = lbl.getFont();
		this.setSize(300,300);
		setLayout(null);
		setVisible(true);
		lbl.setFont(trb);
		lbl.setBounds(50,50,250,30);
		add(lbl);
		p.setBounds(10,100,300,25);
		p.add(user);
		p.add(usertf);
		p.setVisible(true);
		p1.setBounds(10,150,300,25);
		p1.add(pass);
		p1.add(passtf);
		p1.setVisible(true);
		p2.setBounds(10,200,300,25);
		p2.add(okbtn);
		p2.add(cancelbtn);
		p2.setVisible(true);
		add(p);
		add(p1);
		add(p2);
		lbl.requestFocus();
		okbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lbl.setFont(original);
				if(usertf.getText().equals("jaikanth") && passtf.getText().equals("jay") ){
					lbl.setText("Login Sucessful");
				} else {
					lbl.setText("Invalid Username or Password");
				}
			}
		});
		cancelbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				usertf.setText("");
				passtf.setText("");
				lbl.setText("SASTRA DEEMED TO BE UNIVERSITY");
				lbl.setFont(trb);
			}
		});
		usertf.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				usertf.setText("");
				System.out.println("focusGained");
			}
			public 	void focusLost(FocusEvent e){}
		});
		passtf.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				passtf.setText("");
				passtf.setEchoChar('*');
				System.out.println("focusGained");
			}
			public 	void focusLost(FocusEvent e){}
		});
	}
}

public class LoginScreen{
	public static void main(String[] args){
		Auth a = new Auth();
	}
}
*/
