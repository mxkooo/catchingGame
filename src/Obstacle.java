import java.awt.*;

class Obstacle extends Item {
    public Obstacle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, ITEM_SIZE, ITEM_SIZE);
    }
}