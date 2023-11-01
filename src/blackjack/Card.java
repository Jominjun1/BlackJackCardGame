package blackjack;

import java.awt.Image;



public class Card  {
	public int[] num = new int[52]; // 0~51까지의 숫자를 저장 
    public Image[] cardImages = new Image[52]; // 52개의 앞면 저장 
    public Image[] playerImageFront = new Image[15]; // 플레이어 카드의 앞면 저장 
    public Image[] computerImageFront = new Image[15]; // 딜러 카드의 앞면 저장 
    public Image imageBack;  // 1개의 뒷면 저장 
    public int[]  playerwx= new int[15]; // 플레이어 카드의 x좌표 
    public int[]  playerwy= new int[15]; // 플레이어 카드의 y좌표 
    public int[]  computerwx= new int[15]; // 딜러 카드의 x좌표 
    public int[]  computerwy= new int[15]; // 딜러 카드의 y좌표 
}
