package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HowToPlay extends JFrame {
	
	
    ImageIcon is = new ImageIcon("img/2.png");
    Image im=is.getImage();
    HowToPlay() {
        this.setTitle("게임 방법");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hwPlay panel = new hwPlay();
        panel.setLayout(null);

        this.add(panel);
        this.setSize(1600,900);
        this.setVisible(true);
        JButton Start = new JButton("start");
        Start.setBounds(700,750 , 200, 80);
        Font font1 = new Font("맑은 고딕" , Font.BOLD , 40);
        Start.setForeground(Color.white);
        Start.setBorderPainted(false);
        Start.setFocusPainted(false);
        Start.setOpaque(false);
        Start.setContentAreaFilled(false);
        Start.setFont(font1);

        panel.add(Start);

        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = new JFrame("BlackJackCardGame");
        		frame.setSize(980,580);
        		frame.setLocationRelativeTo(null);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		BlackJack panel = new BlackJack();
        		frame.add(panel);
        		frame.setVisible(true);
                setVisible(false); 
            }
        });
    }

    public static void addActionListener(ActionListener actionListener) {
    }

    class hwPlay extends JPanel{

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }

}