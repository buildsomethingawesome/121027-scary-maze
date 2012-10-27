import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaryMazeGame extends JComponent implements MouseMotionListener {

    BufferedImage intro;
    BufferedImage level1;
    BufferedImage currentLevel;

    public ScaryMazeGame() throws IOException {
        intro = ImageIO.read(getClass().getResource("Intro.png"));
        level1 = ImageIO.read(getClass().getResource("Level 1.png"));

        currentLevel = intro;
    }

    public static void main(String args[]) throws IOException {
        JFrame window = new JFrame("Scary Maze by Aaron");
        ScaryMazeGame game = new ScaryMazeGame();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        game.addMouseMotionListener(game);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(currentLevel, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // check the color of the pixel the the mouse is over, and
        // go to the next level, or show the game over screen

        int x = e.getX();
        int y = e.getY();
        int color = currentLevel.getRGB(x, y);

        System.out.println(color);

        if (color == -15549808) {
            currentLevel = level1;
        }

        repaint();
    }
}
