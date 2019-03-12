package Mytanchishe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stone {
	int[] x=new int[20];
	int[] y=new int[20];
	Rectangle[] r=new Rectangle[20];
	public void draw(Graphics g  )
	{
		int w=10;
		int h=10;
		Color a=g.getColor();
		g.setColor(Color.yellow);
		for(int i=0;i<20;i++)
		g.fillOval( x[i], y[i], w, h);
		g.setColor(a);
	}
	public Stone ()
	{
		for (int i=0;i<20;i++)
		{
			x[i]=(int)(Math.random()*700);
			y[i]=(int)(Math.random()*700);
			for (int i1=0;i1<20;i1++)
			r [i1]= new Rectangle(x[i1],y[i1],10,10);
		}	
	}
}
