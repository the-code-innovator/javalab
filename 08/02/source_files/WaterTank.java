import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.frame.*;

/*
 * <applet code="WaterTank" width=300 height=100></applet>
 */

public class WaterTank extends Applet {
	// Called first.
	public void init() {
		// initialization
	}
	/* Called second, after init().
	 * Also called whenever the applet is restarted.
	 */
	public void start() {
		// start or resume execution
	}
	// Called when the applet is stopped.
	public void stop() {
		// suspends execution
	}
	/* Called when applet is terminated.
	 * This is the last method executed.
	 */
	public void destroy() {
		// perform shutdown activities
	}
	// Called when an applet’s window must be restored.
	public void paint(Graphics g) {
		// redisplay contents of window
	}
}
// ------------------------------------------------------------------------
// class Tank extends Applet{
// 	int tankHeight = 200;
// 	int tankWidth = 100;
// 	// int
// }
// public class WaterTank{
// 	public static void main(String[] args){
// 	}
// }
// -----------------------------------------------------------------
// class Tank extends Frame{
// 	int height = 100;
// 	int width = 200;
// 	int currX = 200;
// 	int currY = 400 - height;
// 	int filledBox = 0;
// 	int[] xP = {200, 200, 400, 400};
// 	int[] yP = {200, 400, 400, 200};
// 	boolean stopFlow = false;
// 	Tank(){
// 		setSize(600, 600);
// 		setLayout(new FlowLayout());
// 		setVisible(true);
// 		setTitle("Water Tank Flow Control");
// 		Button startButton = new Button("Start Flow");
// 		startButton.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent ae){
// 				this.stopFlow = false;
// 				clear();
// 				new Thread(){
// 					public void run(){
// 						startFill();
// 					}
// 				}.start();
// 			}
// 		});
// 		startButton.setBounds(100, 500, 120, 30);
// 		add(startButton);
// 		Button stopButton = new Button("Stop Flow");
// 		stopButton.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent ae){
// 				this.stopFlow = true;
// 			}
// 		});
// 		stopButton.setBounds(250, 500, 120, 30);
// 		add(stopButton);
// 	}
// 	public void paint(Graphics g){
// 		super.paint(g);
// 		g.drawPolyline(xP, yP, 4);
// 	}
// 	public void repaint(Graphics g){
// 	}
// 	public static void main(String[] args){
// 	}
// }
// public class WaterTank{
// 	public static void main(String[] args){
// 	}
// }
// ------------------------------------------------------------------------
// class WaterTank extends Frame {
// 	int height = 10;
// 	int width  = 200;
// 	int currX  = 200;
// 	int currY  = 400 - height;
// 	int filledBox = 0;
// 	int[] xPoints = {200,200,400,400};
//     int[] yPoints = {200,400,400,200};
//     boolean stop = false;
//     boolean suspend = false;
// 	public void paint(Graphics g) {
//     	super.paint(g);
//     	g.drawPolyline(xPoints,yPoints,4);
// 	}
// 	WaterTank(){
// 		setSize(600,600);
// 		//setLayout(new FlowLayout());
// 		setVisible(true);
// 		setTitle("AWT Program");
// 		Container c = new Container();
// 		c.setLayout(new FlowLayout());
// 		Button btn = new Button("Start");
// 		btn.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				stop = false;
// 				clear();
// 				new Thread(){
// 					public void run(){
// 						while(true){
// 							if(stop) {clear(); break;}
// 							if(!suspend){
// 								startFill();
// 							}
// 						}
// 					}
// 				}.start();
// 			}
// 		});
// 		//btn.setBounds(100,500,120,30);
// 		c.add(btn);
// 		Button stopBtn = new Button("Stop");
// 		stopBtn.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				stop = true;
// 			}
// 		});
// 		//stopBtn.setBounds(250,500,120,30);
// 		c.add(stopBtn);
// 		Button suspendBtn = new Button("Suspend");
// 		suspendBtn.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				suspend = true;			}
// 		});
// 		//suspendBtn.setBounds(380,500,120,30);
// 		c.add(suspendBtn);
// 		Button resumeBtn = new Button("Resume");
// 		resumeBtn.addActionListener(new ActionListener(){
// 			public void actionPerformed(ActionEvent e){
// 				suspend = false;
//
// 			}
// 		});
// 		//resumeBtn.setBounds(500,500,120,30);
// 		c.add(resumeBtn);
// 		c.setVisible(true);
// 		c.setBounds(0,0,600,120);
// 		add(c);
// 		setVisible(true);
// 	}
// 	void clear(){
// 		Graphics g = getGraphics();
// 			for (int i = 0; i < 20 ; i++){
// 				if(filledBox<1) break;
// 				g.clearRect(currX,currY-(filledBox-1)*height,width, height);
// 				filledBox--;
// 				g.drawPolyline(xPoints,yPoints,4);
// 			}
// 	}
// 	void startFill(){
// 			Graphics g = getGraphics();
// 			if(filledBox > 20){ clear();}
// 		try{
//     		Thread.sleep(100);
//     	} catch(Exception e) {}
//     	g.fillRect(currX,currY-filledBox*height, width, height);
//     	filledBox++;
// 	}
// }
// public class Ex8{
// 	public static void main(String[] args) {
// 		WaterTank a = new WaterTank();
// 	}
// }
