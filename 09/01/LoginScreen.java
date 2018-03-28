import java.awt.*;
import java.awt.event.*;
import java.applet.*;

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

		setSize(300,300);
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


public  class LoginScreen extends Applet{
	public static void main(String[] args) {
		Auth a = new Auth();
	}
}

// <applet code="LoginScreen" width=0 height=0></applet>
