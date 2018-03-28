import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
		<applet code="WaterTank" width=600 height=600>
		</applet>
 */

public class WaterTank extends Applet implements ActionListener, Runnable{
	Button startButton;
	Button stopButton;
	Button suspendButton;
	Button resumeButton;
	int tankHeight = 480;
	int tankWidth = 400;
	int heightValue = 0;
	Thread fillThread;
	boolean stopValue = false;
	boolean suspendValue = false;
	boolean doNothing = false;
	int[] xcoords = {
		100, 100, 500, 500, 100
	};
	int[] ycoords = {
		90, 570, 570, 90, 90
	};
	// Called first.
	public void init() {
		// initialization
		this.setLayout(null);
		startButton = new Button("START");
		stopButton = new Button("STOP");
		suspendButton = new Button("SUSPEND");
		resumeButton = new Button("RESUME");
		startButton.setBounds(125, 40, 80, 20);
		stopButton.setBounds(215, 40, 80, 20);
		suspendButton.setBounds(305, 40, 80, 20);
		resumeButton.setBounds(395, 40, 80, 20);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		suspendButton.addActionListener(this);
		resumeButton.addActionListener(this);
		this.add(this.startButton);
		this.add(this.stopButton);
		this.add(this.suspendButton);
		this.add(this.resumeButton);
	}
	/* Called second, after init().
	 * Also called whenever the applet is restarted.
	 */
	public void start() {
		// start or resume execution
		if(this.doNothing){
			// do nothing !
		}
		else{
			if(this.fillThread == null){
				this.fillThread = new Thread(this);
			}
		}
		showStatus("Water Tank Simulation has STARTED");
	}
	// Called when the applet is stopped.
	public void stop() {
		this.fillThread = null;
		// suspends execution
		showStatus("Water Tank Simulation is STOPPED");
	}
	/* Called when applet is terminated.
	 * This is the last method executed.
	 */
	public void destroy() {
		// perform shutdown activities
		startButton.removeActionListener(this);
		stopButton.removeActionListener(this);
		suspendButton.removeActionListener(this);
		resumeButton.removeActionListener(this);
		showStatus("Water Tank Simulation is EXITTED");
	}
	// Called when an applet’s window must be restored.
	public void paint(Graphics g) {
		// redisplay contents of window
		g.drawPolyline(this.xcoords, this.ycoords, 5);
		g.setColor(Color.blue);
		g.fillRect(100, (570 - this.heightValue), this.tankWidth, this.heightValue);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == this.startButton){
			this.stopValue = false;
			this.heightValue = 0;
			fillThread.start();
			showStatus("START IS CLICKED");
		}
		else if(ae.getSource() == this.stopButton){
			this.stopValue = true;
			try{
				fillThread.sleep(100);
			}
			catch(Exception e){
				System.out.print(e);
			}
			showStatus("STOP IS CLICKED");
		}
		else if(ae.getSource() == this.suspendButton){
			this.suspendValue = true;
			showStatus("SUSPEND IS CLICKED");
		}
		else if(ae.getSource() == this.resumeButton){
			this.suspendValue = false;
			fillThread.notifyAll();
			showStatus("RESUME IS CLICKED");
		}
		else{
			showStatus("No Button is Clicked");
			// do nothing !
		}
	}
	public void run(){
		while(!this.stopValue){
			try{
				if(this.suspendValue){
					fillThread.wait();
				}
				repaint();
				this.heightValue++;
				if(this.heightValue >= this.tankHeight){
					this.heightValue = 0;
				}
				fillThread.sleep(5);
			}
			catch(InterruptedException ie){
				System.out.print(ie);
				// break;
			}
		}
	}
}
