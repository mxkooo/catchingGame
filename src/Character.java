import java.awt.*;
import java.awt.event.KeyEvent;

public class Character {
    private int x;
    private int y;
    private static final int CHARACTER_WIDTH = 50;
    private static final int CHARACTER_HEIGHT = 50;

    public Character() {
        x = CatchingGame.FRAME_WIDTH / 2 - CHARACTER_WIDTH / 2;
        y = CatchingGame.FRAME_HEIGHT - CHARACTER_HEIGHT - 20;
    }

    public void move(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT && x > 0) {
            x -= 10;
        } else if (keyCode == KeyEvent.VK_RIGHT && x < CatchingGame.FRAME_WIDTH - CHARACTER_WIDTH) {
            x += 10;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
    }
}