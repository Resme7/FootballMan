package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public Tile[] tile1;
    public int mapTileNumber[][];

    public TileManager(GamePanel gp){
        this.gp=gp;


        tile = new Tile[20];
        mapTileNumber= new int [gp.maxScreenCol][gp.maxScreenRow+1];
        getTileImage();
        loadMap("/maps/map01.txt");

//        if(gp.gameState == gp.playState2){
//            tile = new Tile[20];
//            mapTileNumber= new int [gp.maxScreenCol][gp.maxScreenRow+1];
//            getTileImage();
//            loadMap("/maps/map02.txt");
//        }
    }


    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-4-column-4.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tile-uri/tufis32x32.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-1-column-8.png"));


            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-1-column-15.png"));


            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-2-column-1.png"));


            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-12-column-1.png"));


            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-12-column-11.png"));


            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-12-column-8.png"));


            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-12-column-15.png"));


            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-2-column-15.png"));


            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-11-column-8.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-1-column-1.png"));


            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/TileTeren1/row-1-column-3.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Tile-uri/Stadion.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void loadMap(String filePath){

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader((new InputStreamReader(is)));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row <gp.maxScreenRow){

                String line = br.readLine();

                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;

                }
                if(col == gp.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }

    public  void draw(Graphics2D g2){

        int col =0;
        int row=0;
        int x=0;
        int y = 0;

        while(col < gp.maxScreenCol && row <gp.maxScreenRow){
            int tileNum = mapTileNumber[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.TileSize, gp.TileSize, null);

            col++;
            x += gp.TileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x=0;
                row++;
                y += gp.TileSize;
            }

        }
    }

//    public  void draw1(Graphics2D g2){
//
//        int col =0;
//        int row=0;
//        int x=0;
//        int y = 0;
//
//        while(col < gp.maxScreenCol && row <gp.maxScreenRow){
//            int tileNum = mapTileNumber[col][row];
//
//            g2.drawImage(tile[tileNum].image, x, y, gp.TileSize, gp.TileSize, null);
//
//            col++;
//            x += gp.TileSize;
//
//            if(col == gp.maxScreenCol){
//                col = 0;
//                x=0;
//                row++;
//                y += gp.TileSize;
//            }
//
//        }
//    }
}
