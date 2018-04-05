import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;




class LabelTFPanel extends Panel{
	Label l1 = new Label();
	TextField tf1 = new TextField();
	LabelTFPanel(String lbl,String TF,FocusListener e){
		super();
		setLayout(null);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		tf1 = new TextField(TF);
		l1.setText(lbl);
		tf1.addFocusListener(e);
		add(l1);
		add(tf1);
		
	}
}

class LabelChoicePanel extends Panel{
	Label l1 = new Label();
	Choice c1 = new Choice();
	LabelChoicePanel(String lbl, String[] Choice){
		super();
		setLayout(null);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		l1.setText(lbl);
		for(String a: Choice){
			c1.add(a);
		}
		add(l1);
		add(c1);	
	}
}


class AWT extends Frame implements FocusListener,ItemListener{
	Panel head = new Panel();
	Panel left = new Panel(new GridLayout(9,1));
	Panel right = new Panel(new GridLayout(3,1));
	LabelTFPanel regno = new LabelTFPanel("    Register No","Enter regno",this);
	LabelTFPanel name  = new LabelTFPanel("           Name","Enter name ",this);

	CheckboxGroup gender = new CheckboxGroup();
	Checkbox male = new Checkbox("Male",false, gender);
	Checkbox female = new Checkbox("Female",false, gender);
	Panel genderFrame = new Panel();

	String[] degrees = {"B.Tech","M.Tech","MBA"};
	LabelChoicePanel degree = new LabelChoicePanel("Degree",degrees);
	String[] yrs = {"I","II","III","IV"};
	LabelChoicePanel year = new LabelChoicePanel("Year",yrs);
	String[] branches = {"CSE","IT"};
	LabelChoicePanel br = new LabelChoicePanel("Branch",branches);
	
	Choice d = new Choice(), m  = new Choice(), y = new Choice();
	Panel dob, address= new Panel();
	Panel email = new Panel();
	TextArea addr = new TextArea(3,20);
	TextField emailTF = new TextField("appleseed@example.com");

	Panel hobby = new Panel();
	Checkbox stamp = new Checkbox("Stamp Collection",false);
	Checkbox novel = new Checkbox("reading Novel",false);
	Checkbox tennis = new Checkbox("Playing Tennis",false);

	Panel excurr = new Panel();
	List exlist = new List(2,true);
	Panel op = new Panel();
	TextArea output = new TextArea(7,40);
	
	AWT(){
		
		setSize(800,800);
		setLayout(new BorderLayout(50,50));
		head.add(new Label("Student Response Form"));
		left.add(regno);
		left.add(name);
		genderFrame.add(male);
		genderFrame.add(female);
		left.add(genderFrame);
		
		left.add(degree);
		left.add(year);
		left.add(br);
		dob = createDOB();
		left.add(dob);

		address.add(new Label("Address"));	
		address.add(addr);
		left.add(address);

		email.add(new Label("Email     "));
		email.add(emailTF);
		left.add(email);

		hobby.add(stamp);
		hobby.add(novel);
		hobby.add(tennis);
		right.add(hobby);
		
		exlist.add("Tennis");
		exlist.add("Cricket");
		exlist.addItemListener(this);
		excurr.add(exlist);
		right.add(excurr);
		op.add(output);
		right.add(op);



		add(head,BorderLayout.NORTH);
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		setVisible(true);
		
	}

	public void focusGained(FocusEvent e){
		TextField tmp = (TextField)e.getSource();
		tmp.setText("");

	}

	public void focusLost(FocusEvent e){}

	Panel createDOB(){
		Panel a = new Panel();
		a.add(new Label("DOB"));
		for (int i =1; i <=31; i++){
			d.add(i+"");
		}
		a.add(d);
		for (int i =1; i <=31; i++){
			m.add(i+"");
		}
		a.add(m);
		for (int i =1990; i <=2018; i++){
			y.add(i+"");
		}
		a.add(y);

		return a;

	}

	public void itemStateChanged(ItemEvent e){
		if(regno.tf1.getText().length() < 9 || name.tf1.getText().length() == 0 ){
			output.setText("Error");
		}
		String[] a = exlist.getSelectedItems();
		String ex="";
		String hob="";
		for(String x:a){
			ex+= x+",";
		}
		ex=ex.substring(0,ex.length()-1);
		if(stamp.getState()){
			hob += "Stamp Collection";
		}
		if(novel.getState()){
			hob+=",Reading Novel";
		}
		if(tennis.getState()){
			hob+=",Playing Tennis";
		}
			

		String noun,salu;
		if(male.getState()){
			noun = "He";
			salu = "Shri";
		} else{
			noun = "She";
			salu = "Sow";
		}
		String op = String.format("%s %s's register number is %s\n%s is styding in %s year %s degree %s branch\n%s was born on %s-%s-%s\n%s is resding at %s\n%s is interested in %s\n%s plays %s well ",salu,name.tf1.getText(),regno.tf1.getText(),noun,year.c1.getSelectedItem(),degree.c1.getSelectedItem(),br.c1.getSelectedItem(),noun,d.getSelectedItem(),m.getSelectedItem(),y.getSelectedItem(),noun,addr.getText(),noun,hob,noun,ex);

		output.setText(op);
		try{
			FileWriter oup = new FileWriter("output.txt");
		oup.write(op.replace("\n","\r\n"));
		oup.close();
		} catch(Exception file){}

		
	}



}




class Ex11 {
	public static void main(String[] args) {
		AWT a = new AWT();
	}
}