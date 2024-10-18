package Main;

import Objects.Minge;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    Graphics2D g2;
    GamePanel gp;
    Font arial;
    Font arial2, arial3;
    BufferedImage MingeImage;
    public boolean gameFinished = false;
    public boolean gameInteractiune = false;
    public  int commandNum = 0;
    public int titleScreenState = 0;//0 pentru primu ecran, 1: pentru al doilea
    public static Database database = Database.getInstance();


    public UI(GamePanel gp) {
        this.gp = gp;
        arial = new Font("Arial", Font.PLAIN, 17);
        arial2 = new Font("Arial2", Font.BOLD, 80);
        arial3 = new Font("Arial", Font.PLAIN, 30);
        Minge minge = new Minge();
        MingeImage = minge.image;
    }

    public void draw(Graphics2D g2) {
        if(gp.gameState == gp.titleState){
            drawTitleScreen(g2);
        }
        else{
            if (gameFinished == true) {
                g2.setFont(arial2);
                g2.setColor(Color.yellow);
                String text = "YOU WIN";
                g2.drawString(text, 260, 320);
                g2.setFont(arial3);
                g2.setColor(Color.black);
                text = "Your score: ";
                g2.drawString(text + gp.player.Score, 300, 350 );
                database.addScore(gp.player.Score);
                database.Close();
                gp.ui.titleScreenState= 0;
                gp.gameThread.stop();


            } else if (gameInteractiune == true) {
                g2.setFont(arial2);
                g2.setColor(Color.red);
                String text = "GAME OVER";
                g2.drawString(text, 220, 320);
                if (gp.player.interactiune == 2) {
                    g2.setFont(arial3);
                    g2.setColor(Color.black);
                    String text1 = "You have got 2 yellow cards";
                    g2.drawString(text1, 260, 360);
                    gp.ui.titleScreenState = 1;
                    database.addScore(gp.player.Score);
                    database.Close();
                    gp.gameThread.stop();


                }
                if (gp.player.interactiune1 == 1) {
                    g2.setFont(arial3);
                    g2.setColor(Color.black);
                    String text2 = "You have got a red card";
                    g2.drawString(text2, 260, 360);
                    gp.ui.titleScreenState = 0;
                    database.addScore(gp.player.Score);
                    database.Close();
                    gp.gameThread.stop();
                }
            } else {
                g2.setFont(arial);
                g2.setColor(Color.black);
                g2.drawImage(MingeImage, 0, 0, 40, 40, null);
                g2.drawString(" x " + gp.player.hasMinge, 30, 25);
                g2.drawString("Galben:" + gp.player.interactiune, 61, 25);
                g2.drawString("Score:" + gp.player.Score, 10,40);
            }
        }





    }

    public void drawTitleScreen(Graphics2D g2){
        if(titleScreenState == 0){
            g2.setColor(new Color(70,120,80));
            g2.fillRect(0,0,13 * gp.TileSize, 10* gp.TileSize);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "FootballMan";
            //Shadow
            g2.setColor(Color.black);
            g2.drawString(text, 165, 125);
            //Main color
            g2.setColor(Color.white);
            g2.drawString(text, 160, 120);
            g2.drawImage(gp.player.down1, -64, 320, gp.TileSize *6, gp.TileSize * 6, null );
            g2.drawImage(gp.obj[0].image, 160, 540, gp.TileSize *2 , gp.TileSize*2 , null );
            //Meniu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
            text = "New Game";
            g2.drawString(text, 320,320);
            if(commandNum == 0){
                g2.drawString(">", 290,320);

            }

            text = "Quit";
            g2.drawString(text, 320, 360);
            if(commandNum == 1){
                g2.drawString(">", 290,360);

            }
        }
        else if(titleScreenState == 1){

            g2.setColor(new Color(70,120,80));
            g2.fillRect(0,0,13 * gp.TileSize, 10* gp.TileSize);
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));
            String text ="Choose the level:";
            g2.drawString(text, 320, 260);

            text ="Level 1";
            g2.drawString(text, 320, 300);
            if(commandNum == 0){
                g2.drawString(">", 290, 300);
            }
            text ="Level 2";
            g2.drawString(text, 320, 340);
            if(commandNum == 1){
                g2.drawString(">", 290, 340);
            }
            text ="Back";
            g2.drawString(text, 320, 400);
            if(commandNum == 2){
                g2.drawString(">", 290, 400);
            }




        }

    }
}

