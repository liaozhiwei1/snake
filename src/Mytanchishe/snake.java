package Mytanchishe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class snake {
	List<ZB> list=new ArrayList<ZB>();
	private boolean live = true;
	boolean zuo ,you,shang,xia=true;
	int speed=10;
	Font f=new Font("宋体",Font.BOLD,50);
	//int x[]=new int[500];
	//int y[]=new int[500];
	//int length=3;
	public void draw (Graphics g) throws InterruptedException
	{	
		if(live)
		{
		Color a=g.getColor();		
		g.setColor(Color.red);
		for (int j=list.size();j>0;j--)
		{
		g.fillOval(list.get(j-1).getX(),list.get(j-1).getY(),10, 10);
		}
		Thread.sleep(40);
		move();
		g.setColor(a);
		}
		else
		{
		Color a=g.getColor();		
		g.setColor(Color.red);
		g.setFont(f);
		g.drawString("游戏结束", 250, 300);
		g.drawString("游戏得分"+ Integer.toString( list.size()*10-100),220, 400);
		g.setColor(a);
		}
	}
/*	public void move()
	{
		if (zuo)
		{
			for (int i=0;i<length;i++)
			{
				x[i]=x[i+1];
				y[i]=y[i+1];
			}
			x[length]=x[length]-speed;
		}
		if (you)
		{
			for (int i=0;i<length;i++)
			{
				x[i]=x[i+1];
				y[i]=y[i+1];
			}
			x[length]=x[length]+speed;
		}
		if (xia)
		{
			for (int i=0;i<length;i++)
			{
				x[i]=x[i+1];
				y[i]=y[i+1];
			}
			y[length]=y[length]+speed;
		}
		if (shang)
		{
			for (int i=0;i<length;i++)
			{
				x[i]=x[i+1];
				y[i]=y[i+1];
			}
			y[length]=y[length]-speed;
		}	
	}*/
	public void move (){
		if (zuo)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX()-speed,list.get(list.size()-1).getY()));
			list.remove(0);	
		}
		if (you)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX()+speed,list.get(list.size()-1).getY()));
			list.remove(0);	
		}
		if (shang)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX(),list.get(list.size()-1).getY()-speed));
			list.remove(0);	
		}
		if (xia)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX(),list.get(list.size()-1).getY()+speed));
			list.remove(0);	
		}
		
		
	}
	public void direction(KeyEvent e){//检测按键
		switch (e.getKeyCode()) {
		case 37:
			if (you)
				break;
			zuo=true;
			shang=false;
			you=false;
			xia=false;
			break;
		case 38:
			if (xia)
				break;
			shang=true;
			you=false;
			xia=false;
			zuo=false;
			break;
		case 39:
			if (zuo)
				break;
			you=true;
			shang=false;
			xia=false;
			zuo=false;
			break;
		case 40:
			if (shang)
				break;
			xia=true;
			you=false;
			shang=false;
			zuo=false;
			break;
		default:
		break;
		}
	}
	/*public  snake()
	{
		for(int i=0;i<=length;i++)
		{
			x[i]=100;
			y[i]=100+i*10;
		}	
	}*/
	
	public snake(){
		for(int i=0;i<10;i++)
		list.add(new ZB(100,100+i*10));
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(list.get(list.size()-1).getX(),list.get(list.size()-1).getY(),10,10);	
	}
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	/*public void setlenght(int x,int y)
	{
		this.length=this.length+1;
		this.x[length]=x;
		this.y[length]=y;
	}*/
	public void len(){
		if (zuo)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX()-10,list.get(list.size()-1).getY()));
		}
		if (you)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX()+10,list.get(list.size()-1).getY()));
		}
		if (shang)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX(),list.get(list.size()-1).getY()-10));
		}
		if (xia)
		{
			list.add(
					new ZB(
							list.get(list.size()-1).getX(),list.get(list.size()-1).getY()+10));
		}
	}
}
