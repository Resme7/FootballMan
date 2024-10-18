package Main;

import Entity.ArbitruG;
import Entity.ArbitruR;
import Objects.Coin;
import Objects.Minge;
import Objects.Poarta;
import Objects.Stadion;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

            gp.obj[0] = new Minge();
            gp.obj[0].x =1 * gp.TileSize;
            gp.obj[0].y = 9 * gp.TileSize;

            gp.obj[1] = new Minge();
            gp.obj[1].x =12 * gp.TileSize;
            gp.obj[1].y = 8 * gp.TileSize;

            gp.obj[2] = new Poarta();
            gp.obj[2].x =5 * gp.TileSize;
            gp.obj[2].y = 2 * gp.TileSize;

            gp.obj[3] = new Poarta();
            gp.obj[3].x =9 * gp.TileSize;
            gp.obj[3].y = 5 * gp.TileSize;

            gp.obj[4] = new Poarta();
            gp.obj[4].x =2 * gp.TileSize;
            gp.obj[4].y = 7 * gp.TileSize;

            gp.obj[5] = new Stadion();
            gp.obj[5].x =12 * gp.TileSize;
            gp.obj[5].y = 0 * gp.TileSize;

            gp.obj[6] = new Minge();
            gp.obj[6].x =0* gp.TileSize;
            gp.obj[6].y = 5 * gp.TileSize;

            gp.obj[7] = new Coin();
            gp.obj[7].x =1 * gp.TileSize;
            gp.obj[7].y = 4 * gp.TileSize;

            gp.obj[8] = new Coin();
            gp.obj[8].x =6* gp.TileSize;
            gp.obj[8].y = 8 * gp.TileSize;

            gp.obj[9] = new Coin();
            gp.obj[9].x =0* gp.TileSize;
            gp.obj[9].y = 8 * gp.TileSize;

            gp.obj[10] = new Coin();
            gp.obj[10].x =3* gp.TileSize;
            gp.obj[10].y = 0 * gp.TileSize;

            gp.obj[11] = new Coin();
            gp.obj[11].x =4* gp.TileSize;
            gp.obj[11].y = 9 * gp.TileSize;

            gp.obj[12] = new Coin();
            gp.obj[12].x =6* gp.TileSize;
            gp.obj[12].y = 1 * gp.TileSize;

            gp.obj[13] = new Coin();
            gp.obj[13].x =6* gp.TileSize;
            gp.obj[13].y = 3 * gp.TileSize;

            gp.obj[14] = new Coin();
            gp.obj[14].x =7* gp.TileSize;
            gp.obj[14].y = 9 * gp.TileSize;

            gp.obj[15] = new Coin();
            gp.obj[15].x =12* gp.TileSize;
            gp.obj[15].y = 5 * gp.TileSize;

            gp.obj[16] = new Coin();
            gp.obj[16].x =8* gp.TileSize;
            gp.obj[16].y = 0 * gp.TileSize;



    }



    public void setArbitru() {

        gp.arbitru[0]= new ArbitruG(gp);

        gp.arbitru[0].x = gp.TileSize *4;
        gp.arbitru[0].y = gp.TileSize *6;

        gp.arbitru[1]= new ArbitruG(gp);

        gp.arbitru[1].x = gp.TileSize *6;
        gp.arbitru[1].y = gp.TileSize *3;

        gp.arbitru[2]= new ArbitruR(gp);

        gp.arbitru[2].x = gp.TileSize *8;
        gp.arbitru[2].y = gp.TileSize *8;

        gp.arbitru[3]= new ArbitruR(gp);

        gp.arbitru[3].x = gp.TileSize *10;
        gp.arbitru[3].y = gp.TileSize *7;

        gp.arbitru[4]= new ArbitruR(gp);

        gp.arbitru[4].x = gp.TileSize *9;
        gp.arbitru[4].y = gp.TileSize *3;

        gp.arbitru[5]= new ArbitruG(gp);

        gp.arbitru[5].x = gp.TileSize *6;
        gp.arbitru[5].y = gp.TileSize *5;


    }
}
