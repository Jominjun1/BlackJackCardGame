package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Table extends JPanel{
	Random random = new Random();
	public Card card = new Card(); 
	public Image bgImage;
	public Image[] btImg = new Image[3]; 
	public int betAmount = 10; 
	private int balance = 200; 
	private int numCard = 0; 
	private int PlayerCard = 0; 
	private int playerAce = 0; 
	private int computerAce = 0; 
	private int resultPlayer = 0;
	private int ComputerCard = 0; 
	private int resultComputer = 0; 
	public boolean player = true; 
	public boolean game = true; 
	private String bet = "";
	private int win =0;
	private int loss = 0;
	private int onePlayerCard = 0;
	private int oneComputerCard =0;

	private String winRate = "";
	private String lossRate = "";
	int flag =0;

	public Table() {
		
		loadImages(); 
		shuffle();
		distCards(true); 
		distCards(true); 
		distCards(false);
		distCards(false); 
	}

	public String winner() {
		winRate = "win :  ";
		winRate += win;
		return winRate;
	}
	public String losser() {
		lossRate = "loss :  ";
		lossRate += loss;
		return lossRate;
	}
	
	public String betText() {
		bet = "betting :  ";
		bet += betAmount;
		bet += " balance : " + balance;
		return bet;
	}
	
	

	private void loadImages() {
		try {
			card.imageBack = ImageIO.read(new File("img/card.png"));
			bgImage = ImageIO.read(new File("img/table.png"));
			for (int i = 0; i < 13; i++) {
				card.cardImages[i] = ImageIO.read(new File("img/c" + (i + 1) + ".png"));
			}
			for (int i = 13, j = 0; i < 26; i++, j++) {
				card.cardImages[i] = ImageIO.read(new File("img/d" + (j + 1) + ".png"));
			}
			for (int i = 26, j = 0; i < 39; i++, j++) {
				card.cardImages[i] = ImageIO.read(new File("img/h" + (j + 1) + ".png"));
			}
			for (int i = 39, j = 0; i < 52; i++, j++) {
				card.cardImages[i] = ImageIO.read(new File("img/h" + (j + 1) + ".png"));
			}
			btImg[0] = ImageIO.read(new File("img/hit.png"));
			btImg[1] = ImageIO.read(new File("img/stay.png"));
			btImg[2] = ImageIO.read(new File("img/betting.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void shuffle() { 
		Random rnd = new Random();
		int t;
		for (int i = 0; i < card.num.length; i++) {
			do {
				t = rnd.nextInt(card.num.length);
			} while (card.num[t] != 0);
			card.num[t] = i;
		}
	}
	

	private void distCards(boolean player) {
		int index = 0; 
		try {
			if (player) {
				
				card.playerwx[PlayerCard] += 400 + PlayerCard * 20;
				card.playerwy[PlayerCard] += 250;
			
				card.playerImageFront[PlayerCard] = card.cardImages[card.num[numCard]];
				
				index = card.num[numCard];

				if (index % 13 < 10 && index % 13 != 0)
					resultPlayer += index % 13 + 1;
				else if (index % 13 == 0) {            
					playerAce++;
					resultPlayer += 11;
				} else
					resultPlayer += 10;
				if (resultPlayer > 21) {           
					int temp = playerAce;
					for (int i = 0; i < playerAce; i++) {
						resultPlayer -= 10;
						temp--;                        
						if (resultPlayer <= 21) { 
							playerAce = temp;
							break;
						}
					}
				}
				PlayerCard++;
				numCard++;
				
			} else {
				card.computerwx[ComputerCard] += 400 + ComputerCard * 20;
				card.computerwy[ComputerCard] += 50;
				card.computerImageFront[ComputerCard] = card.cardImages[card.num[numCard]];
				index = card.num[numCard];

				if (index % 13 < 10 && index % 13 != 0)
					resultComputer += index % 13 + 1;
				else if (index % 13 == 0) { 
					computerAce++;
					resultComputer += 11;
				} else
					resultComputer += 10;
				if (resultComputer > 21) {
					int temp = computerAce;
					for (int i = 0; i < computerAce; i++) {
						resultComputer -= 10;
						temp--;
						if (resultComputer <= 21) {
							computerAce = temp;
							break;
						}
					}
				}
				ComputerCard++;
				numCard++;
				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "덱을 모두 소진하였습니다.");
			restart();
		}
	}

	
	public void buttonAction(int x, int y) { 
		if ((x > 0 && x < 200) && (y > 100 && y < 170)) {
			System.out.println(numCard);
			checkWinLost();
			initialize();
		}

		if ((x > 0 && x < 200) && (y > 200 && y < 270)) {
			distCards(true);
			if (resultPlayer > 21) {
				while (true) {
					if (resultComputer >= 17)
						break;
					distCards(false);
				}
				game = false;
				JOptionPane.showMessageDialog(null, "합계 " + resultPlayer + "  로 패배하셨습니다. " + "배팅 금액 " +betAmount + "만큼 잃었습니다.");
				game = true;
				balance -= betAmount;
				loss++;
				checkBankrupt();
				betText();
				initialize();
			}
		}
		if ((x > 0 && x < 200) && (y > 300 && y < 370)) {
			int temp=0;
			while(true) {
				temp = Integer.parseInt(JOptionPane.showInputDialog("배팅 금액을 수정하세요."));
				if(temp>balance) {
					JOptionPane.showMessageDialog(null, "잔액보다 적게 입력을 다시하세요.");
					continue;
				}
				else if(temp<0) {
					JOptionPane.showMessageDialog(null, "금액을 -로 입력하지 마세요.");
					continue;
				}
				else {
					betAmount = temp;
					betText();
					break;
				}
			}
		}

	}

	private void checkWinLost() {
		while (true) {
			if (resultComputer >= 17)
				break;
			distCards(false);
		}
		if (resultComputer > 21) {
			game = false;
			JOptionPane.showMessageDialog(null, "딜러합계 " + resultComputer + " 로 승리하셨습니다." + "배팅 금액 " +betAmount  + "만큼 얻었습니다.");
			game = true;
			balance += betAmount;
			win++;
			winner();
			losser();
			betText();
		} else {
			if (resultComputer > resultPlayer) {
				game = false;
				JOptionPane.showMessageDialog(null, "딜러합계 " + resultComputer + " 내합계 " + resultPlayer + " 임으로 패배하셨습니다." + "배팅 금액 " + betAmount  + "만큼 잃었습니다.");
				game = true;
				balance -= betAmount;
				loss++;
				checkBankrupt();
				winner();
				losser();
				betText();
			} else if (resultComputer == resultPlayer) {
				while(flag == 0) {
				JOptionPane.showMessageDialog(null, "무승부 임으로 한장의 카드를 다시 뽑습니다.");
				onePlayerCard = random.nextInt(13)+1;
				oneComputerCard = random.nextInt(13)+1;
				if (oneComputerCard > onePlayerCard) {
						game = false;
						JOptionPane.showMessageDialog(null,"컴퓨터의 숫자(" +  oneComputerCard + ")보다 작으므로(" + onePlayerCard  + ")패배 하셨습니다." +  "배팅 금액 " +betAmount  + "만큼 잃었습니다.");
						game = true;
						balance -= betAmount;
						loss++;
						flag = 1;
						checkBankrupt();
						winner();
						losser();
						betText();
					}
				else if(oneComputerCard < onePlayerCard) {
						game = false;
						JOptionPane.showMessageDialog(null,"컴퓨터의 숫자(" +  oneComputerCard + ")보다 큼으로(" + onePlayerCard  + ")승리 하셨습니다." +  "배팅 금액 " +betAmount  + "만큼 얻었습니다.");
						game = true;
						balance += betAmount;
						win++;
						flag = 1;
						winner();
						losser();
						betText();
					}
				}
				
			} else {
				game = false;
				JOptionPane.showMessageDialog(null, "딜러합계 " + resultComputer + " 내합계 " + resultPlayer + " 임으로 승리하셧습니다."  + "배팅 금액 " +betAmount  + "만큼 얻었습니다.");
				game = true;
				balance += betAmount;
				win++;
				winner();
				losser();
				betText();
			}
		}
	}

	private  void initialize() { 
		resultPlayer = 0;
		resultComputer = 0;
		PlayerCard = 0;
		ComputerCard = 0;
		playerAce = 0; 
		computerAce = 0; 
		onePlayerCard = 0;
		oneComputerCard =0;
		for (int i = 0; i < 15; i++) {
			card.computerwx[i] = 0;
			card.computerwy[i] = 0;
			card.playerwx[i] = 0;
			card.playerwy[i] = 0;
		}
		distCards(false);
		distCards(false);
		distCards(true);
		distCards(true);			
	
	}
	
	private void checkBankrupt() { 
		if(balance<=0) {
			JOptionPane.showMessageDialog(null, "파산했습니다. 기본금으로 다시 시작합니다.");
			betAmount = 10; 
			balance = 200;
			win =0;
		    loss = 0;
		}
	}
	
	private void restart(){
		for(int i=0; i<card.num.length; i++){
			card.num[i] = 0;
		}
		shuffle(); 
		game = false;
		JOptionPane.showMessageDialog(null, "새 덱으로 게임을 다시 시작합니다.");
		game = true;
		resultPlayer = 0;
		resultComputer = 0;
		PlayerCard = 0;
		ComputerCard = 0;
		numCard=0;
		playerAce = 0; 
		computerAce = 0; 
		onePlayerCard = 0;
		oneComputerCard =0;
		flag = 0;
		for (int i = 0; i < 15; i++) {
			card.computerwx[i] = 0;
			card.computerwy[i] = 0;
			card.playerwx[i] = 0;
			card.playerwy[i] = 0;
		}
		distCards(false);
		distCards(false);
		distCards(true);
		distCards(true);
	}
}


