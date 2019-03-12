package Mytanchishe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Main extends MyFrame{
	snake b=new snake();
	Image BG=GameUtil.getImage("piont/bg.jpg") ;
	food f=new food();
	Stone s=new Stone();

	public static void main(String[] args) {
		new Main().launchFrame();
	}
	public void launchFrame()
	{
		super.launchFrame();
	  addKeyListener(new key());
	}

	public void paint(Graphics g) {
		g.drawImage(BG, 0, 0, null);
		try {
			b.draw(g);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		f.draw(g);
		s.draw(g); 
		if(b.list.get(b.list.size()-1).getX()<0||b.list.get(b.list.size()-1).getX()>700)
		{
			b.setLive(false);
		}
		if(b.list.get(b.list.size()-1).getY()<20||b.list.get(b.list.size()-1).getY()>700)
		{
			b.setLive(false);
		}
		boolean p=b.getRect().intersects(f.getRect());
		boolean p1 = false;
		for (int i=0;i<20;i++)
		{
			p1=b.getRect().intersects(s.r[i]);
			if (p1)
				break;
		}
		if(p1)
		{
			b.setLive(false);
		}
		if(p)
		{
			f.setLive(true);
			b.len();
		}
	} 
	class key extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
		b.direction(e);
		}
	}

}
