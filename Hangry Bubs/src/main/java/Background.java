import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0;
	private double scale =.12;
	public Background(int x, int y) {
		img = getImage("/imgs/Red Bird.png"); //load the image for Tree
		this.x=x;
		this.y=y;

		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		update();
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);

		update();
		
	}
	
	private void update() {
		tx.setToTranslation(x,y);
		tx.scale(scale, scale);
	}
	
	public double getX() {
		return x; 
	}
	

	
	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scale, scale);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
