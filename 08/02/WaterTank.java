import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code="WaterTank" width=600 height=600></applet>
 */

public class WaterTank extends Applet implements ActionListener{
	Button startButton;
	Button stopButton;
	Button suspendButton;
	Button resumeButton;
	int tankHeight = 200;
	int tankWidth = 100;
	int heightValue = 0;
	int fillRate = 3;
	// Called first.
	public void init() {
		// initialization
		this.setLayout(null);
		startButton = new Button("START");
		stopButton = new Button("STOP");
		suspendButton = new Button("SUSPEND");
		resumeButton = new Button("RESUME");
		startButton.setBounds(125, 10, 80, 20);
		stopButton.setBounds(215, 10, 80, 20);
		suspendButton.setBounds(305, 10, 80, 20);
		resumeButton.setBounds(395, 10, 80, 20);
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
	public void actionPerformed(ActionEvent ae){
		// System.out.print("Button was clicked");
		// showStatus("B1 was Clicked !");
	}
}
