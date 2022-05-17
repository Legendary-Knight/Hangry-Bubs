package org.jbox2d.testbed.tests;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.testbed.framework.TestbedModel;
import org.jbox2d.testbed.framework.j2d.DebugDrawJ2D;
import org.jbox2d.testbed.framework.j2d.TestPanelJ2D;

public class MediumWoodBlock{
	private BufferedImage img; 	
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
		try {
			img = ImageIO.read(new File("\\\\dohome4.pusd.dom\\home4$\\Student4\\1904731\\git\\Hangry-Bubs\\Hangry-Bubs\\Hangry-Bubs\\Hangry Bubs\\src\\main\\java\\imgs\\Medium Wood Plank.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load the image for Tree
		this.x=x+520;
		this.y=y+180;
		
		//Graphics2D g2 = (Graphics2D) g;
		//G2 = g2;
		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}
	
	public MediumWoodBlock(int x, int y, int a) {
		//System.out.println("redBird");
		try {
			img = ImageIO.read(new File("\\\\dohome4.pusd.dom\\home4$\\Student4\\1904731\\git\\Hangry-Bubs\\Hangry-Bubs\\Hangry-Bubs\\Hangry Bubs\\src\\main\\java\\imgs\\Medium Wood Plank.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load the image for Tree
		this.x=x+520;
		this.y=y+180;
		System.out.println("angle" + a);
		//Graphics2D g2 = (Graphics2D) g;
		//G2 = g2;
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx.rotate(a);
		update(); 				//initialize the location of the image
									//use your variables
	}
	/*
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		update();
	}
	*/
	
	public void paint(Graphics2D g) {
		g.drawImage(img, tx, null);
		update();
		
	}
	
	public void paint(Graphics2D g, double a) {
		/*
		System.out.println(a);
		g.drawImage(img, tx, null);
		*/
		a= (Math.PI/2)-a;
		System.out.println("angle" + a);

		// Drawing the rotated image at the required drawing locations
		AffineTransform backup = g.getTransform();
	    //rx is the x coordinate for rotation, ry is the y coordinate for rotation, and angle
	    //is the angle to rotate the image. If you want to rotate around the center of an image,
	    //use the image's center x and y coordinates for rx and ry.
	    AffineTransform A = AffineTransform.getRotateInstance(a, x, y);
	    //Set our Graphics2D object to the transform
	    g.setTransform(A);
	    //Draw our image like normal
	    g.drawImage(img, (int) x,(int) y, null);
	    //Reset our graphics object so we can draw with it again.
	    g.setTransform(backup);

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
