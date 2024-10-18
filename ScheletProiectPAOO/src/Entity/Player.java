package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Objects;

public class Player extends Entity{


    KeyHandler keyH;
    public int hasMinge=0;
    public int Score=0;
    public int interactiune = 0;
    public int interactiune1 = 0;

    public Player(GamePanel gp, KeyHandler keyH)
    {
        super(gp);

        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 20;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y =20;
        solidArea.width = 32;
        solidArea.height =32;


        setDefaultValues();
        getPlayerImage();
        getPlayerImage1();
    }

    public void setDefaultValues(){
        x=32;
        y=40;
        speed = 3;
        direction= "down";
    }

    public void getPlayerImage(){

            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMspate2.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMspate3.png"));

                down1 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMFATA2.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMFATA3.png"));

                left1 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMstanga2.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMstanga3.png"));

                right1 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMdreapta2.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/PlayerRM/RMdreapta3.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void getPlayerImage1(){

        try {
            up11 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAspate2.png"));
            up22 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAspate3.png"));

            down11 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAFATA2.png"));
            down22 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAFATA3.png"));

            left11 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAstanga2.png"));
            left22 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAstanga3.png"));

            right11 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAdreapta2.png"));
            right22 = ImageIO.read(getClass().getResourceAsStream("/PlayerBARCA/BARCAdreapta3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(){
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {  //Pentru ca player-ul sa nu se miste cand nu e apasata nicio tasta corespunzatoare
            if (keyH.upPressed == true) {
                direction = "up";


            } else if (keyH.downPressed == true) {
                direction = "down";


            } else if (keyH.leftPressed == true) {
                direction = "left";


            } else if (keyH.rightPressed == true) {
                direction = "right";


            }
            collisionOn = false;
            gp.cChecker.checkTile(this);
            //verificam coleziunile cu obiectele
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //coleziunile cu arbitrii
            int arbIndex = gp.cChecker.checkEntity(this, gp.arbitru);
            interactArbitru(arbIndex);

            if(collisionOn == false)
            {
                switch(direction) {
                    case "up":
                        if (y>0)
                            y -= speed;
                        break;
                    case "down":
                        if (y<9*64)
                            y += speed;
                        break;
                    case "left":
                        if (x>=0)
                            x -= speed;
                        break;
                    case "right":
                        if(x<12 * 64)
                            x += speed;
                        break;

                }
            }

            spriteCounter++;
            if(spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void interactArbitru(int i) {

        if (i != 999) {
            String ArbitruName = gp.arbitru[i].name;


            switch (ArbitruName) {
                case "ArbitruGalben":

                    if(collisionOn == true)
                    {
                        interactiune++;
                        x= 32;
                        y= 40;
                    }
                    if(interactiune == 2){
                        //System.out.println("Coleziune Arbitru galben");
                        gp.ui.gameInteractiune = true;
                    }
                    break;
                case "ArbitruRosu":
                    //System.out.println("Coleziune Arbitru rosu");
                    if(collisionOn==true){
                        interactiune1++;
                    }
                    if(interactiune1 == 1){
                        gp.ui.gameInteractiune = true;
                       // System.out.println(gp.ui.gameInteractiune);
                        // System.out.println(interactiune1);
                    }
                    break;
            }
        }
    }

    public void pickUpObject(int i){
        if(i!=999){
            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Minge":
                    hasMinge++;
                    gp.obj[i] = null;
                    break;
                case "Poarta":
                    if(hasMinge > 0){
                        gp.obj[i] = null;
                        hasMinge--;
                    }
                    break;
                case "Coin":
                    Score= Score+10;
                    gp.obj[i] = null;
                    break;
                case "Stadion":
                    gp.ui.gameFinished = true;

                    break;


            }

        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                if(spriteNum == 1){
                image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }

                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }

                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }

                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }

                break;
        }
        g2.drawImage(image, x,y, gp.TileSize, gp.TileSize, null);
    }

    public void draw1(Graphics2D g2){

        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                if(spriteNum == 1){
                    image = up11;
                }
                if(spriteNum == 2) {
                    image = up22;
                }

                break;
            case "down":
                if(spriteNum == 1) {
                    image = down11;
                }
                if(spriteNum == 2) {
                    image = down22;
                }

                break;
            case "left":
                if(spriteNum == 1) {
                    image = left11;
                }
                if(spriteNum == 2) {
                    image = left22;
                }

                break;
            case "right":
                if(spriteNum == 1) {
                    image = right11;
                }
                if(spriteNum == 2) {
                    image = right22;
                }

                break;
        }
        g2.drawImage(image, x,y, gp.TileSize, gp.TileSize, null);
    }

}
