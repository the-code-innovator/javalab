import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
		<applet code="AppletFrame" height=300 width=300>
		</applet>
 */

// class AppletFrame extends Frame{
// 	public Button B1;
// 	public Label L1;
// 	public AppletFrame(){
// 		B1 = new Button("OK");
// 		L1 = new
// 		B1.addActionListener(new ActionEvent(){
// 			public void actionPerformed(ActionEvent ae){
// 				set
// 			}
// 		});
// 	}
// 	public void paint(){
//
// 	}
// }

public class AppletFrame extends Applet{
	// Called first.
	Button B1;
	// Button B2;
	// Label L1;
	public void init() {
		// initialization
		B1 = new Button("OK");
		// B2 = new Button("QUIT");
		// L1 = new Label("Applet Started");
		B1.setBounds(100, 150, 100, 50);
		// setStatus("NEW APPLET");
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
}
