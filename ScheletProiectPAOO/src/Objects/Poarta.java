package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Poarta extends SuperObject{

    public Poarta(){
        name = "Poarta";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/poartalateralsus.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
        collision = true;

    }
}
