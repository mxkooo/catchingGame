import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatchingGame extends JFrame {

    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 600;

    private Character character;
    private List<Item> items;
    private int score;

    public CatchingGame() {
        setTitle("Catching Game");
        setBackground(Color.BLACK);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        character = new Character();
        items = new ArrayList<>();
        score = 0;

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveItems();
                checkCollisions();
                repaint();
            }
        });

        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                character.move(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        setFocusable(true);
    }

    private void moveItems() {
        Random random = new Random();
        int itemType = random.nextInt(2); // 0 for Food, 1 for Item

        int x = random.nextInt(FRAME_WIDTH - Item.ITEM_SIZE);
        int y = 0;

        if (itemType == 0) {
            items.add(new Food(x, y));
        } else {
            items.add(new Obstacle(x, y));
        }

        List<Item> itemsToRemove = new ArrayList<>();

        for (Item item : items) {
            item.move();
            if (item.getY() > FRAME_HEIGHT) {
                itemsToRemove.add(item);
            }
        }

        items.removeAll(itemsToRemove);
    }

    private void checkCollisions() {
        Rectangle characterBounds = character.getBounds();

        for (Item item : items) {
            Rectangle itemBounds = item.getBounds();

            if (characterBounds.intersects(itemBounds)) {
                if (item instanceof Food) {
                    score++;
                } else if (item instanceof Obstacle) {
                    score--;
                }
                items.remove(item);
                break; // Break to avoid ConcurrentModificationException
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        character.draw(g);

        for (Item item : items) {
            item.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CatchingGame().setVisible(true);
            }
        });
    }
}








