package inputs;

import java.awt.event.KeyEvent;
import java.security.Key;

public class InputManager {
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean xPressed = false;
    public boolean startAgain= false;
    public boolean exit = false;
    public static InputManager instance = new InputManager();

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            startAgain=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            exit = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            startAgain=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            exit = false;
        }
    }
}
