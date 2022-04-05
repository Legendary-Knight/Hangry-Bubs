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

import java.util.Scanner;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.testbed.framework.TestbedTest;

public class DominoTest extends TestbedTest {

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
      sd.setAsBox(50.0f, 10.0f);
      fd.shape = sd;

      BodyDef bd = new BodyDef();
      bd.position = new Vec2(0.0f, -10.0f);
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
    	for(float j=0; j<=24; j+=6)
	    	for(float i=-24+(j/2);i<=24-(j/2);i+=6) {
	    		box(3.0f,3.0f,.3f,i,j+((j/3)*.3f));
	    	}
    	//bd.angle = (float)Math.PI/2;
    	/*
    	 FixtureDef fd = new FixtureDef();
         PolygonShape sd = new PolygonShape();
         sd.setAsBox(.25f, 2f);
         fd.shape = sd;
         fd.density = 25.0f;
         BodyDef bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         float friction = .5f;
         System.out.println(friction);
         int numPerRow = 10;
         fd.friction = friction;
         bd.position = new Vec2(-2f, 1.2f);
         bd.angle = 0;
         Body myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         
         
         fd = new FixtureDef();
         sd = new PolygonShape();
         sd.setAsBox(.25f, 2f);
         fd.shape = sd;
         fd.density = 25.0f;
         bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         System.out.println(friction);
         fd.friction = friction;
         bd.position = new Vec2(2f, 1.2f);
         bd.angle = 0;
         myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         
         
         fd = new FixtureDef();
         sd = new PolygonShape();
         sd.setAsBox(.25f, 3f);
         fd.shape = sd;
         fd.density = 25.0f;
         bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         System.out.println(friction);
         fd.friction = friction;
         bd.position = new Vec2(0, 4.2f);
         bd.angle = (float)Math.PI/2;
         myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         
         fd = new FixtureDef();
         sd = new PolygonShape();
         sd.setAsBox(.25f, 2f);
         fd.shape = sd;
         fd.density = 25.0f;
         bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         System.out.println(friction);
         fd.friction = friction;
         bd.position = new Vec2(1.5f, 6.2f);
         bd.angle = 0;
         myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         
         
         fd = new FixtureDef();
         sd = new PolygonShape();
         sd.setAsBox(.25f, 2f);
         fd.shape = sd;
         fd.density = 25.0f;
         bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         System.out.println(friction);
         fd.friction = friction;
         bd.position = new Vec2(-1.5f, 6.2f);
         bd.angle = 0;
         myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         
         fd = new FixtureDef();
         sd = new PolygonShape();
         sd.setAsBox(.25f, 2f);
         fd.shape = sd;
         fd.density = 25.0f;
         bd = new BodyDef();
         bd.type = BodyType.DYNAMIC;
         System.out.println(friction);
         fd.friction = friction;
         bd.position = new Vec2(0, 11.2f);
         bd.angle = (float)Math.PI/2;
         myBody = getWorld().createBody(bd);
         myBody.createFixture(fd);
         */
    	/*
      FixtureDef fd = new FixtureDef();
      PolygonShape sd = new PolygonShape();
      sd.setAsBox(.5f, 2f);
      fd.shape = sd;
      fd.density = 25.0f;

      BodyDef bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      float friction = .5f;
      System.out.println(friction);
      int numPerRow = 10;
      /*
      Scanner sc=new Scanner(System.in);  
      float ang = sc.nextFloat();
      
      for (int i = 0; i < 4; ++i) {
    	  int n=1;
    	  if(i%2==0) {
    		  n=2;
    	  }
          for (int j = 0; j < (numPerRow*n); j++) {
            fd.friction = friction;
            bd.position = new Vec2(-14.75f + j * (29.5f / ((numPerRow*n) - 1)), 7.3f + 2f * i);
            if (i%2== 0) {
              bd.angle = 0;
              //bd.position.x += .1f;
            }
            else {
              bd.angle = (float)Math.PI/2;
            }
            Body myBody = getWorld().createBody(bd);
            myBody.createFixture(fd);
          }
          numPerRow-=2;
        }
      */
      /*
      for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < numPerRow; j++) {
          fd.friction = friction;
          bd.position = new Vec2(-14.75f + j * (29.5f / (numPerRow - 1)), 7.3f + 5f * i);
          if (i == 2 && j == 0) {
            bd.angle = -.1f;
            bd.position.x += .1f;
          } else if (i == 3 && j == numPerRow - 1) {
            bd.angle = .1f;
            bd.position.x -= .1f;
          } else
            bd.angle = 90f;
          Body myBody = getWorld().createBody(bd);
          myBody.createFixture(fd);
        }
      }
      */
    } 
  }
  public void box(float width, float height, float thickness, float x, float y) {
	  FixtureDef fd = new FixtureDef();
      PolygonShape sd = new PolygonShape();
      sd.setAsBox(thickness, height);
      fd.shape = sd;
      fd.density = 50.0f;
      BodyDef bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      float friction = .5f;
      System.out.println(friction);
      fd.friction = friction;
      bd.position = new Vec2(x+(thickness), y+height);
      bd.angle = 0;
      Body myBody = getWorld().createBody(bd);
      myBody.createFixture(fd);
      
      
      fd = new FixtureDef();
      sd = new PolygonShape();
      sd.setAsBox(thickness, height);
      fd.shape = sd;
      fd.density = 50.0f;
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
      fd.density = 50.0f;
      bd = new BodyDef();
      bd.type = BodyType.DYNAMIC;
      System.out.println(friction);
      fd.friction = friction;
      bd.position = new Vec2(x+width, y+height*2+thickness);
      bd.angle = (float)Math.PI/2;
      myBody = getWorld().createBody(bd);
      myBody.createFixture(fd);
  }
  @Override
  public String getTestName() {
    return "Hangury Burbs";
  }
}
