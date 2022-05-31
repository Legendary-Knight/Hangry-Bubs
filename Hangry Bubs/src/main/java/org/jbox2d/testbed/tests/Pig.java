package org.jbox2d.testbed.tests;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Pig{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0;
	private double scale =.06;
	
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

	public Pig(int x, int y) {
		//System.out.println("redBird");
		img = getImage("/imgs/King_Pig.png"); //load the image for Tree
		this.x=x-25;
		this.y=y-35;

		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		update();
	}
	
	public void paint(Graphics2D g, Double a) {
		//these are the 2 lines of code needed draw an image on the screen
		//System.out.println("paintRedBird");
		//Graphics2D g2 = (Graphics2D) g;
		//System.out.println("OOGA");
		g.drawImage(img, tx, null);
		//System.out.println("bOOGA");
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
			URL imageURL = RedBird.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
