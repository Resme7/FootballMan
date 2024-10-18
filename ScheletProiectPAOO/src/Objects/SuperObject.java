package Objects;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {


    public BufferedImage image;
    public String name;
    public boolean collision =false;
    public int x, y;
    public Rectangle solidArea = new Rectangle(0, 0 ,64, 64);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gp){

        g2.drawImage(image, x, y, gp.TileSize, gp.TileSize, null);
    }




}
