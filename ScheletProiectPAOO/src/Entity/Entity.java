package Entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;
    public String name;

    GamePanel gp;
    public BufferedImage up1,up2, down1, down2, left1, left2, right1, right2, up11,up22, down11, down22, left11, left22, right11, right22;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0, 0 , 20, 20);

    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public int actionLockCounter = 0;

    public Entity(GamePanel gp){
        this.gp=gp;

    }
    public void setAction(){
    }
    public void setAction1(){
    }
    public void setAction12(){
    }
    public void setAction13(){
    }

    public void update() {
        setAction();
        setAction1();
        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    if (y > 0)
                        y -= speed;
                    break;
                case "down":
                    if (y < 9 * 64)
                        y += speed;
                    break;
                case "left":
                    if (x >= 0)
                        x -= speed;
                    break;
                case "right":
                    if (x < 12 * 64)
                        x += speed;
                    break;

            }
        }
        spriteCounter ++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2)
                spriteNum =1;
            spriteCounter =0;
        }
    }
    public void update1() {

        setAction12();

        int speed1 = 2;
        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    if (y > 0)
                        y -= speed1;
                    break;
                case "down":
                    if (y < 9 * 64)
                        y += speed1;
                    break;
                case "left":
                    if (x >= 0)
                        x -= speed1;
                    break;
                case "right":
                    if (x < 12 * 64)
                        x += speed1;
                    break;

            }
        }
        spriteCounter ++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2)
                spriteNum =1;
            spriteCounter =0;
        }
    }
    public void update2() {

        setAction13();

        int speed1 = 2;
        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    if (y > 0)
                        y -= speed1;
                    break;
                case "down":
                    if (y < 9 * 64)
                        y += speed1;
                    break;
                case "left":
                    if (x >= 0)
                        x -= speed1;
                    break;
                case "right":
                    if (x < 12 * 64)
                        x += speed1;
                    break;

            }
        }
        spriteCounter ++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2)
                spriteNum =1;
            spriteCounter =0;
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
}
