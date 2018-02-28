import java.awt.*;
import java.awt.event.*;  
class WaterTank extends Frame {
	int height = 10;
	int width  = 200; 
	int currX  = 200;
	int currY  = 400 - height;
	int filledBox = 0;
	int[] xPoints = {200,200,400,400};
    int[] yPoints = {200,400,400,200};
    boolean stop = false;
	
	public void paint(Graphics g) {
    	super.paint(g);
    	g.drawPolyline(xPoints,yPoints,4);   	
	}

	WaterTank(){
		setSize(600,600);
		setLayout(new FlowLayout());
		setVisible(true);
		setTitle("AWT Program");
		Button btn = new Button("Start");
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stop = false;
				clear();
				new Thread(){
					public void run(){
						startFill();
					}
				}.start();
					
			}
		});
		btn.setBounds(100,500,120,30);
		add(btn);
		
		Button stopBtn = new Button("Stop");
		stopBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				stop = true;
			}
		});
		stopBtn.setBounds(250,500,120,30);
		add(stopBtn);
	}

	void clear(){
		Graphics g = getGraphics();
			for (int i = 0; i < 20 ; i++){
				if(filledBox<1) break;
				g.clearRect(currX,currY-(filledBox-1)*height,width, height);
				filledBox--;
				g.drawPolyline(xPoints,yPoints,4);
			}
			
		
	}

	void startFill(){
		while(!stop){
			Graphics g = getGraphics();
			if(filledBox > 20){ clear();}
		
		try{
    		Thread.sleep(100);
    	} catch(Exception e) {}
    	g.fillRect(currX,currY-filledBox*height, width, height);
    	filledBox++;

		}
		
	}

}






public class Ex8{
	public static void main(String[] args) {
		WaterTank a = new WaterTank();
		
	}
}