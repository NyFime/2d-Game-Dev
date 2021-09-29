package jeu2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Base extends JPanel {
	
	private int posX = 0;
	private int posY = 0;
	private Image img = Toolkit.getDefaultToolkit().getImage("bg.png");
	private String perso = "FACE";
	
	public void paintComponent(Graphics g) {

		g.drawImage(img, posX, posY, null);
		draw(g);
        repaint();

    }
	
	   public void draw(Graphics g) {
		   
		   if (perso.equals("FACE")) {
			   
			   try {
			        Image img = ImageIO.read(new File("perso_face.png"));
			        g.drawImage(img, this.getWidth()/2, this.getHeight()/2, this);
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			   
		   }
		   
		   if (perso.equals("DOS")) {
			   
			   try {
			        Image img = ImageIO.read(new File("perso_dos.png"));
			        g.drawImage(img, this.getWidth()/2, this.getHeight()/2, this);
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			   
		   }
		   
		  if (perso.equals("LEFT")) {
			   
			   try {
			        Image img = ImageIO.read(new File("perso_left.png"));
			        g.drawImage(img, this.getWidth()/2, this.getHeight()/2, this);
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			   
		   }
		   
		   if (perso.equals("RIGHT")) {
			   
			   try {
			        Image img = ImageIO.read(new File("perso_right.png"));
			        g.drawImage(img, this.getWidth()/2, this.getHeight()/2, this);
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			   
		   }


	    }
	   
		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}
		
		public String getPerso() {
			return perso;
		}
		
		public void setPerso(String perso) {
			this.perso = perso;
		}

	



}
