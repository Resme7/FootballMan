package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Stadion extends SuperObject{
    public Stadion(){
        name = "Stadion";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/Objects/Stadion.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
    }
}
