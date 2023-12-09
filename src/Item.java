import java.awt.*;

abstract class Item {
    protected int x;
    protected int y;
    public static final int ITEM_SIZE = 30;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void move() {
        y += 5; // Adjust the falling speed
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ITEM_SIZE, ITEM_SIZE);
    }

    public abstract void draw(Graphics g);
}
