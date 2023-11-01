package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BlackJackGame extends JFrame {
    ImageIcon i = new ImageIcon("img/1.png");
    Image im = i.getImage();

    
    BlackJackGame() {
        
        this.setTitle("Black Jack Card Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        panel.setLayout(null);

        this.add(panel);
        this.setSize(1600, 900);
        this.setVisible(true);


        JButton Start = new JButton("start");
        JButton HowToPlay = new JButton("HowToPlay");
        JButton Exit = new JButton("Exit");

        Start.setBounds(700, 300, 200, 80);
        HowToPlay.setBounds(600, 400, 400, 80);
        Exit.setBounds(700, 500, 200, 80);

        Font font1 = new Font("맑은 고딕", Font.BOLD, 40);

        Start.setForeground(Color.white);
        Start.setBorderPainted(false);
        Start.setFocusPainted(false);
        Start.setOpaque(false);
        Start.setContentAreaFilled(false);
        Start.setFont(font1);

        HowToPlay.setForeground(Color.white);
        HowToPlay.setBorderPainted(false);
        HowToPlay.setFocusPainted(false);
        HowToPlay.setOpaque(false);
        HowToPlay.setContentAreaFilled(false);
        HowToPlay.setFont(font1);

        Exit.setForeground(Color.white);
        Exit.setBorderPainted(false);
        Exit.setFocusPainted(false);
        Exit.setOpaque(false);
        Exit.setContentAreaFilled(false);
        Exit.setFont(font1);

        panel.add(Start);
        panel.add(HowToPlay);
        panel.add(Exit);

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        HowToPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HowToPlay();
                setVisible(false); 
            }
        });

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

    class MyPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String args[]) {
        new BlackJackGame();
    }
}
