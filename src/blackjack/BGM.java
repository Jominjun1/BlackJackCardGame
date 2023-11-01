package blackjack;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

import javazoom.jl.player.Player;

public class BGM extends Thread{
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public BGM(String name, boolean isLoop){
        try{
            this.isLoop = isLoop;
            file = new File("img/" + name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public int getTime(){
        if(player == null)
            return 0;
        return player.getPosition();
    }
    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }
    @Override
    public void run(){
        try{
            do{
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isLoop);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
