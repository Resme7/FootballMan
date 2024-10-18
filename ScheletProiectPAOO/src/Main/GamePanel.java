package Main;

import Entity.Entity;
import Entity.Player;
import Objects.SuperObject;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int TileSize = 64;


    public final int maxScreenCol=13;
    public final int maxScreenRow=10;
    public final int screenWidth = TileSize * maxScreenCol;// 832 pixeli
    public final int screenHeight = TileSize * maxScreenRow;//640 pixeli

   // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int playState2 = 2;

    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    Thread gameThread;
    public UI ui=new UI(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    TileManager tileM = new TileManager(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public AssetSetter aArbitru = new AssetSetter(this);

    //Entity and objects
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    public Entity arbitru[] = new Entity[6];
    //FPS
    int FPS = 60;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));//functie JPanel
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);//pentru o performanta mai buna de redare
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void setupGame(){
        gameState = titleState;
        aSetter.setObject();
        aArbitru.setArbitru();



    }



    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(gameThread !=null)
        {
           currentTime = System.nanoTime();

           delta += (currentTime - lastTime)/ drawInterval;

           lastTime = currentTime;

           if(delta >=1)
           {
               // 1. update: pentru caracter
               update();
               // 2. draw: desenarea ecranului
               repaint();
               delta--;

           }


        }
    }

    public void update(){


          if(gameState == playState){

              player.update();

              arbitru[0].update();
              arbitru[1].update();
              arbitru[2].update();

          }


       else if(gameState == playState2){



              player.update();

              arbitru[0].update();
              arbitru[1].update();
              arbitru[2].update();
              arbitru[3].update1();
              arbitru[4].update2();
              arbitru[5].update();
       }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        //TITLE SCREEN

        if(gameState == titleState){
            ui.draw((Graphics2D) g2);
        }else{
//Tile
            if(gameState == playState){

                tileM.draw((Graphics2D) g2);
                //Obiecte
                for(int i=0; i<obj.length; i++){
                    if(obj[i] != null){
                        obj[i].draw((Graphics2D) g2, this);
                    }
                }
                //Arbitru

                arbitru[0].draw((Graphics2D) g2);
                arbitru[1].draw((Graphics2D) g2);
                arbitru[2].draw((Graphics2D) g2);


                player.draw((Graphics2D) g2);

                //UI
                ui.draw((Graphics2D) g2);
            }
            else if(gameState == playState2){

                tileM.draw((Graphics2D) g2);
                player.draw1((Graphics2D) g2);
                //Obiecte
                for(int i=0; i<obj.length; i++){
                    if(obj[i] != null){
                        obj[i].draw((Graphics2D) g2, this);
                    }
                }

                for(int i=0; i<arbitru.length; i++)
                {
                    if (arbitru[i] != null){
                        arbitru[i].draw((Graphics2D) g2);
                    }
                }



                //UI
                ui.draw((Graphics2D) g2);
            }

        }

        g2.dispose();
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
