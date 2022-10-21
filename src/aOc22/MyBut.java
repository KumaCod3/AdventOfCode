package aOc22;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


public class MyBut extends JButton{
	private Color col1=Color.YELLOW;
	private Color col2=Color.MAGENTA;
	private Color scri=Color.WHITE;
	
	public MyBut(String a) {
		super(a );
		setContentAreaFilled(false);
		setForeground(scri);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(10,20,10,20));
		
	}
	
	protected void paintComponent(Graphics g) {
		int wi=getWidth();
		int he=getHeight();
		BufferedImage img=new BufferedImage(wi,he, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2=img.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint pa=new GradientPaint(0,0,col1,wi,0,col2);
		g2.setPaint(pa);
		g2.fillRoundRect(0,0,wi,he,he,he);
		createStyle(g2);
		g.drawImage(img,0,0,null);
		super.paintComponent(g);
		
	}
	
	
	//MAKE SHADOW
	private void createStyle(Graphics2D g2) {
		int wi=getWidth();
		int he=getHeight();
		GradientPaint pa=new GradientPaint(0,0,Color.WHITE,0,he,new Color(255,255,255,60));
		g2.setPaint(pa);
		Path2D.Float f=new Path2D.Float();
		int controll=he+he/2;
		f.moveTo(0,0);
		f.curveTo(0,0,wi/2,controll,wi,0);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,0.3f));
		g2.fill(f);
	}

}
