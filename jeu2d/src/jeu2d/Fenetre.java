package jeu2d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

    private JPanel conteneur = new JPanel();
    private Base base = new Base();
    private boolean stop = false;
    

    public Fenetre() {
        
        this.setTitle("salut");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initControl();
        worldCollide();
        
        conteneur.setLayout(new BorderLayout());
        conteneur.add(base, BorderLayout.CENTER);
        this.setContentPane(conteneur);

        this.setVisible(true);

    }
    
    public void worldCollide() {
    			
    	Thread t = new Thread(new PlayLoop());
    	t.start();
    	
    	
    }


    public void initControl() {
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Z) {
                	base.setPosY(base.getPosY() + 5);
                	base.setPerso("DOS");
                }
                
                if (e.getKeyCode() == KeyEvent.VK_S) {
                	base.setPosY(base.getPosY() - 5);
                	base.setPerso("FACE");
                }
                	
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                	base.setPosX(base.getPosX() + 5);
                	base.setPerso("LEFT");
                }
                
                if (e.getKeyCode() == KeyEvent.VK_D) {
                	base.setPosX(base.getPosX() - 5);
                	base.setPerso("RIGHT");
                }
                
            }
            
        });

    }

 
    public class PlayLoop implements Runnable {
    	
    	

		@Override
		public void run() {
			
			while (!stop) {
				
				try {
					Thread.sleep(1000/60);
					System.out.println(base.getPosX() + " "+ base.getPosY());
	            	
	            	if (base.getPosY() >= 0)
	                	base.setPosY(0);
	            	
	            	if (base.getPosX() >= 0)
	                	base.setPosX(0);
	            	
	            	if (base.getPosY() <= 500)
	            		base.setPosY(500);
	            	
	            	if (base.getPosX() <= 500)
	            		base.setPosX(500);
	            	
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
			
		}
    	
    }


}