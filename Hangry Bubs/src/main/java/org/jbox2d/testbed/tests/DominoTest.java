/*******************************************************************************
 * Copyright (c) 2013, Daniel Murphy
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 	* Redistributions of source code must retain the above copyright notice,
 * 	  this list of conditions and the following disclaimer.
 * 	* Redistributions in binary form must reproduce the above copyright notice,
 * 	  this list of conditions and the following disclaimer in the documentation
 * 	  and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package org.jbox2d.testbed.tests;

import java.awt.Graphics; 
import java.util.Scanner;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.testbed.framework.TestbedModel;
import org.jbox2d.testbed.framework.TestbedTest;
import org.jbox2d.testbed.framework.j2d.DebugDrawJ2D;
import org.jbox2d.testbed.framework.j2d.TestPanelJ2D;

import java.awt.AWTError;
import java.awt.Color; 
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DominoTest extends TestbedTest  {
	final TestbedModel TBM = new TestbedModel();
	final TestPanelJ2D TPJ = new TestPanelJ2D(TBM);
	final DebugDrawJ2D draw = new DebugDrawJ2D(TPJ);
	public static boolean AngryBirdsMapIsLoaded =false;
	public static int numberOfPigs=2;
  @Override
  public boolean isSaveLoadEnabled() {
    return true;
  }

  public void initTest(boolean argDeserialized) {

    if(argDeserialized){
      return;
    }
    
    { // Floor
      FixtureDef fd = new FixtureDef();
      PolygonShape sd = new PolygonShape();
      sd.setAsBox(100.0f, 40.0f);
      fd.shape = sd;

      BodyDef bd = new BodyDef();
      bd.position = new Vec2(0.0f, -40.0f);
      getWorld().createBody(bd).createFixture(fd);

    }

    { // Platforms
    /*
      for (int i = 0; i < 1; i++) {
        FixtureDef fd = new FixtureDef();
        PolygonShape sd = new PolygonShape();
        sd.setAsBox(15.0f, 0.125f);
        fd.shape = sd;

        BodyDef bd = new BodyDef();
        bd.position = new Vec2(0.0f, 5f + 5f * i);
        getWorld().createBody(bd).createFixture(fd);
        
      }
      */
    }

    {
    
    	
    	
    /*
     * Comments
     * 
     * 
     * 
     */
    	
    /*
     * Notes:
     * Top 3 People will win chips
     * left Click and drag on the slingshot to shoot bird 
     * Hit both pigs to win
     * Record top score and name and google sheets
     * 
     * Scoring
     * 10000 for each bird left
     * 5000 for each pig hit
     * 500 for each wood broken
     */

        float thickness =2f;
    	for(float j=8; j<=24; j+=8) {
	    	for(float i=-24+j;i<=24-(j);i+=8) {
	    		box(4.0f,4.0f,thickness,i*1.021f,(j-8)+(((j-8)/3)*(thickness+.1f)));
	    	}
    	}
    	BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(12f, 10.5f);
        bd.bullet = true;
        Body myBody = getWorld().createBody(bd);
        CircleShape circle = new CircleShape();
        circle.m_radius = 2f;

        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 10f; 
        fd.restitution = 0;
        myBody.createFixture(fd);

    	bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position.set(-12f, 10.5f);
        bd.bullet = true;
        myBody = getWorld().createBody(bd);
        circle = new CircleShape();
        circle.m_radius = 2f;

        fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 10f; 
        fd.restitution = 0;
        myBody.createFixture(fd);
		//Music AB = new Music("AngryBirds.wav",true);
		//AB.play();
        AngryBirdsMapIsLoaded =true;

    } 
  }
  public void box(float width, float height, float thickness, float x, float y) {
	  FixtureDef fd = new FixtureDef();
      PolygonShape sd = new PolygonShape();
      sd.setAsBox(thickness, height);
      fd.shape = sd;
      fd.density = 30.0f;
      BodyDef bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      float friction = .5f;
      System.out.println(friction);
      fd.friction = friction;
      bd.position = new Vec2(x+(thickness), y+height);
      bd.angle = 0;
      //MediumWoodBlock mwb = new MediumWoodBlock(bd,0,0);
      //mwb.paint(g);
      Body myBody = getWorld().createBody(bd);
      myBody.createFixture(fd);
      
      
      fd = new FixtureDef();
      sd = new PolygonShape();
      sd.setAsBox(thickness, height);
      fd.shape = sd;
      fd.density = 30.0f;
      bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      System.out.println(friction);
      fd.friction = friction;
      bd.position = new Vec2(x+(width*2)-(thickness), y+height);
      bd.angle = 0;
      myBody = getWorld().createBody(bd);
      myBody.createFixture(fd);
      
      
      fd = new FixtureDef();
      sd = new PolygonShape();
      sd.setAsBox(thickness, width); 
      fd.shape = sd;  
      fd.density = 30.0f;
      bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      System.out.println(friction);
      fd.friction = friction;
      bd.position = new Vec2(x+width, (y)+height*2+(thickness+.1f));
      bd.angle = (float)Math.PI/2;
      myBody = getWorld().createBody(bd);
      myBody.createFixture(fd);
      
  }
  @Override
  public String getTestName() {
    return "Hangry Bubs Level 1";
  }
}
