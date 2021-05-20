import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GraphicHelper {
	private static JFrame graphicWindow;
	private static Container graphicContentPane;
	public static Graphics graphicDrawer;
	public static Graphics graphicClearer;
	private static Dimension screenSize;
	
	public GraphicHelper() {
		//create large window frame for drawing graphics
		graphicWindow = new JFrame("Collision Drawing Window");
		graphicWindow.setTitle("Collision Drawing Window");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		graphicWindow.setSize(screenSize.width, screenSize.height);
		graphicWindow.setLocation(0,0);
		graphicWindow.setVisible(true);
		graphicWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		//Create and define a graphics container object
		graphicContentPane = graphicWindow.getContentPane();
		graphicContentPane.setBackground(Color.BLACK);
		//Initialize a graphics object and link it to the frame's pane
		graphicDrawer = graphicContentPane.getGraphics();
		graphicDrawer.setColor(Color.WHITE);
		graphicClearer = graphicContentPane.getGraphics();
		graphicClearer.setColor(Color.BLACK);
		try { Thread.sleep(100) ; }catch(Exception e) {}
	}
	public void drawCircle( Particle particle ) {
		int radius = particle.radius;
		int diameter = 2*radius;
		graphicDrawer.fillRoundRect( (int)(particle.xPos-radius), (int)(particle.yPos-radius), diameter, diameter, diameter, diameter );
	}
	public void clearScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		graphicClearer.fillRect( 0, 0, screenSize.width, screenSize.height);
	}
}