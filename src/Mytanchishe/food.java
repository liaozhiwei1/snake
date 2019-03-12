package Mytanchishe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class food {
	int x;
	int y;
	boolean live=true;
	 public void draw(Graphics g)
	 {
		 Color a=g.getColor();
		 g.setColor(Color.blue);
		 if(live)
		 {
			 x=(int)(Math.random()*700);
			 y=(int)(Math.random()*700);
		 }
		 g.fillOval(x, y, 10, 10);
		 live=false;
		 if(y<40)
			 live=true;
		 g.setColor(a);
	 }
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Rectangle getRect()
	{
		return new Rectangle((int)x,(int)y,10,10);	
	}	 
}
