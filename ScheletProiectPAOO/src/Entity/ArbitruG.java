package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class ArbitruG extends Entity{

    public ArbitruG(GamePanel gp){
        super(gp);

        direction= "left";
        speed = 1;

        name = "ArbitruGalben";

        getArbitruImage();
    }

    public void getArbitruImage(){

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruSpate2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruSpate3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalben12.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalben13.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalbenstg2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalbenstg3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalbendr2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Arbitru/ArbitruGalbendr3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction(){
//       actionLockCounter++;
//       if(actionLockCounter == 10)
//       {


            if(gp.arbitru[0].x >= 200 && direction == "left") {
                //gp.arbitru[0].x -= speed;
               // System.out.println(gp.arbitru[0].x);
            }
            else{
                direction = "right";
            }

            if( direction == "right" && gp.arbitru[0].x <= 270) {
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
