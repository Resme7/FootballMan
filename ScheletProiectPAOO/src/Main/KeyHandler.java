package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    GamePanel gp;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //Title state
        if(gp.gameState == gp.titleState) {
            if (gp.ui.titleScreenState == 0) {
                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 1;
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 1) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;

                    }
                    if (gp.ui.commandNum == 1) {
                        System.exit(0);
                    }
                }
            } else if (gp.ui.titleScreenState == 1) {
                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                        gp.ui.titleScreenState = 1;
                    }
                    if (gp.ui.commandNum == 1) {
                        gp.gameState = gp.playState2;
                        gp.playMusic(0);
                        gp.ui.titleScreenState = 1;

                    }
                    if (gp.ui.commandNum == 2) {
                        gp.ui.titleScreenState = 0;
                    }
                }
            }
        }

            if(gp.gameState == gp.playState){

                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    upPressed = true;
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    downPressed = true;
                }
                if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                    leftPressed = true;
                }
                if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                    rightPressed = true;
                }

            }
            else if(gp.gameState == gp.playState2){
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                    upPressed = true;
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                    downPressed = true;
                }
                if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
                    leftPressed = true;
                }
                if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
                    rightPressed = true;
                }
            }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();


        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }
}
