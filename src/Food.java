import java.awt.*;

class Food extends Item {
    public Food(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, ITEM_SIZE, ITEM_SIZE);
    }
}