import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
		<applet code="AppletFrame" height=400 width=600>
		</applet>
 */

public class AppletFrame extends Applet implements FocusListener, MouseMovementListener, ActionListener{
	// Called first.
	Button B1;
	Button B2;
	Label L1;
	public void init() {
		// initialization
		B1 = new Button("OK");
		B2 = new Button("QUIT");
		L1 = new Label("Applet Started");
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

/*
 * <param name="width" value=600>
 * <param name="height" value=400>
 */
