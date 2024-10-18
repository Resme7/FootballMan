package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Minge extends  SuperObject{

    public Minge(){
        name = "Minge";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/101Minge.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
    }



}
