package org.jbox2d.testbed.tests;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.testbed.framework.TestbedModel;
import org.jbox2d.testbed.framework.j2d.DebugDrawJ2D;
import org.jbox2d.testbed.framework.j2d.TestPanelJ2D;

public class MediumWoodBlock{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0;
	private double scale =.50;
	private Graphics2D G2;
	
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

	
	public MediumWoodBlock(int x, int y) {
		//System.out.println("redBird");
		img = getImage("/imgs/Medium Wood Plank.png"); //load the image for Tree
		this.x=x+520;
		this.y=y+180;
		//Graphics2D g2 = (Graphics2D) g;
		//G2 = g2;
		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		update();
	}
	
	public void paint(Graphics2D g) {
		//these are the 2 lines of code needed draw an image on the screen
		//private Graphics2D dbg = null;
		//Graphics g = dbg.getGraphics();
		//System.out.println("paintRedBird");
		//Graphics2D g2 = (Graphics2D) g;
		//final TestbedModel TBM = new TestbedModel();
		//final TestPanelJ2D TPJ = new TestPanelJ2D(TBM);
		//final DebugDrawJ2D draw = new DebugDrawJ2D(TPJ);
		//Graphics g = TPJ.getGraphics();
		//Graphics2D g2 = (Graphics2D) g;

		g.drawImage(img, tx, null);
		update();
		
	}
	
	private void update() {
		tx.setToTranslation(x,y);
		tx.scale(scale, scale);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scale, scale);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = MediumWoodBlock.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
