package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class BlackJack extends JPanel implements Runnable, MouseListener{
	
	Table table;
	public  BlackJack() {
		table=new Table();
		addMouseListener(this);
		Thread thread = new Thread(this);
		thread.start();
		BGM introMusic = new BGM("sleepMusic.mp3",true);
	  	introMusic.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage( table.bgImage, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		g.drawString( table.betText(),700,200);   
		g.drawString(table.winner(), 700, 50);
		g.drawString(table.losser(), 700, 100);
		g.drawImage( table.btImg[0], 0,200, this); 
		g.drawImage( table.btImg[1], 0,100, this);
		g.drawImage( table.btImg[2], 0,300, this);
		for(int i=0; i<table.card.playerImageFront.length; i++) { 
			if(table.card.playerwx[i]==0) break;;
			g.drawImage( table.card.playerImageFront[i], table.card.playerwx[i], table.card.playerwy[i], null);
		}
		for(int i=0; i<table.card.computerImageFront.length; i++) { 
			if(table.card.computerwx[i]==0) break;
			if(i==0 && table.game) 
				g.drawImage(table.card.imageBack, 400, 50, null );				
			else{
				g.drawImage( table.card.computerImageFront[i], table.card.computerwx[i], table.card.computerwy[i], null);
			}
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) { 
		table.buttonAction(e.getX(), e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				Thread.yield();
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				break;
			}
		}
	}
}
