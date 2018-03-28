import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
		<applet code="AppletFrame" height=300 width=300>
		</applet>
 */
public class AppletFrame extends Applet implements ActionListener{
	// Called first.
	Button B1;
	// Button B2;
	// Label L1;
	public void init() {
		// initialization
		this.setLayout(null);
		B1 = new Button("OK");
		// B2 = new Button("QUIT");
		// L1 = new Label("Applet Started");
		B1.setBounds(100, 150, 100, 50);
		// setStatus("NEW APPLET");
		B1.addActionListener(this);
		add(B1);
		// add(B2);
		// add(L1);
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
		// g.add(B1);
		// g.add(B2);
		// g.add(L1);
		showStatus("THIS IS STATUS!");
	}
	public void actionPerformed(ActionEvent ae){
		// System.out.print("Button was clicked");
		showStatus("B1 was Clicked !");
	}
}
