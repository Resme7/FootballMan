package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Coin extends SuperObject {


        public Coin(){
            name = "Coin";
            try{
                image = ImageIO.read(getClass().getResourceAsStream("/Objects/CoinM.png"));

            }catch(IOException e){
                e.printStackTrace();

            }
            collision = true;
        }




}
