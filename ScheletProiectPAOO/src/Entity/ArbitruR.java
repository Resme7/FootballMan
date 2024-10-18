package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ArbitruR extends Entity{

    public ArbitruR(GamePanel gp){
        super(gp);

        direction= "down";
        speed = 1;

        name = "ArbitruRosu";

        getArbitruImage();
    }

    public void getArbitruImage(){

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruSpate2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruSpate3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosu2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosu3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosustg2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosustg3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosudr2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruRosudr3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction1(){
//       actionLockCounter++;
//       if(actionLockCounter == 10)
//       {


        if(gp.arbitru[2].y <576 && direction == "down") {
           // gp.arbitru[2].y -= speed;
           // System.out.println(gp.arbitru[2].y);
        }
        else{
            direction = "up";
        }

        if( direction == "up" && gp.arbitru[2].y > 512) {
            //gp.arbitru[2].y -= speed;
        }
        else
        {
            direction = "down";
        }
//       }
//       actionLockCounter = 0;

    }
    public void setAction12(){
//       actionLockCounter++;
//       if(actionLockCounter == 10)
//       {


        if(gp.arbitru[3].y <530 && direction == "down") {
            // gp.arbitru[2].y -= speed;
            // System.out.println(gp.arbitru[3].y);
        }
        else{
            direction = "up";
        }

        if( direction == "up" && gp.arbitru[3].y > 400) {
            //gp.arbitru[2].y -= speed;
        }
        else
        {
            direction = "down";
        }
//       }
//       actionLockCounter = 0;

    }

    public void setAction13(){
//       actionLockCounter++;
//       if(actionLockCounter == 10)
//       {


        if(gp.arbitru[4].x > 578 && direction == "left") {
            //gp.arbitru[0].x -= speed;
             //System.out.println(gp.arbitru[4].x);
        }
        else{
            direction = "right";
        }

        if( direction == "right" && gp.arbitru[4].x < 660) {
            //gp.arbitru[0].x += speed;
        }
        else
        {
            direction = "left";
        }
//       }
//       actionLockCounter = 0;

    }
}
