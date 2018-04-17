import java.awt.*;import java.awt.event.*;import java.util.regex.Matcher;import java.util.regex.Pattern;

class Calculator extends Frame implements ActionListener{
	int width = 600,height = 600;Panel p1 = new Panel();Panel cont = new Panel(new BorderLayout(50,50));TextField tf1 = new TextField();Button[] b1 = new Button[25];double memory = 0.0;
	String[] lbl = {"M+","M-","MC","MR","C","CE","<-","Sqrt","1","2","3","+","4","5","6","-","7","8","9","*","0",".","=","/"};
	Calculator(){
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}});
		setLayout(null);
		setVisible(true);
		this.setSize(width,height);
		cont.setBounds(25,50,550,500);
		tf1.setPreferredSize(new Dimension(600,100));
		tf1.addActionListener(this);
		p1.setLayout(null); p1.setLayout(new GridLayout(6,4,10,10));
		for (int i =0; i < lbl.length;i++){
			b1[i] = new Button(lbl[i]);
			b1[i].addActionListener(this);p1.add(b1[i]);
		}
		cont.add(tf1,BorderLayout.NORTH);cont.add(p1,BorderLayout.CENTER);
		add(cont);
	}
	double calculate(double a, double b,String op){
		switch(op){
			case "+": return a+b;
			case "-": return a-b;
			case "*": return a*b;
			case "/": return a/b;
		}
		return 0.0;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == tf1){
			b1[20].dispatchEvent(new ActionEvent((Object)b1[22], ActionEvent.ACTION_PERFORMED, b1[22].getLabel()));
		}
		switch(e.getActionCommand()){
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case ".":
			case "+":
			case "-":
			case "*":
			case "/":
				String T = tf1.getText() + e.getActionCommand();
				tf1.setText(T);break;
			case "=":
			  String term = "";
	      do{
  				String pat = "([\\d\\.]+)([+\\-\\*/])([\\d\\.]+)(.*)";
  				Pattern r = Pattern.compile(pat);
  				String Tstr = tf1.getText();
  				Matcher m = r.matcher(Tstr);
  				if(m.find()){
  					Tstr = calculate(Double.parseDouble(m.group(1)),Double.parseDouble(m.group(3)),m.group(2)) + m.group(4);
  					tf1.setText(Tstr);term = m.group(4);
  				}else{
  					System.out.println("Hap");
  				}
		    }while (!(term.equals("")));break;
			case "Sqrt":
			   String Tstr = Math.sqrt(Double.parseDouble(tf1.getText())) + "";
         tf1.setText(Tstr);break;
			case "<-":
			   Tstr = tf1.getText().substring(0,tf1.getText().length()-1);tf1.setText(Tstr);break;
			case "M+":
				memory += Double.parseDouble(tf1.getText());
				tf1.setText("");Tstr = "";break;
			case "M-":
				memory -= Double.parseDouble(tf1.getText());;
				tf1.setText("");Tstr = "";break;
			case "MR":
				tf1.setText(memory+"");Tstr = tf1.getText();break;
			case "MC":
				memory = 0.0;break;
			case "C":
				tf1.setText("");Tstr = "";break;
			case "CE":
				tf1.setText("");Tstr = "";memory = 0.0;break;
		}
	}
}

public class CalculatorProgram{
	public static void main(String[] args) {
		Calculator a = new Calculator();
	}
}
