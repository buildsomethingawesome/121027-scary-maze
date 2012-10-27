import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaryMazeGame extends JComponent implements MouseMotionListener,
        MouseListener {

    BufferedImage intro;
    BufferedImage level1;
    BufferedImage level2;
    BufferedImage level3;
    BufferedImage gameOver;
    BufferedImage currentLevel;
    AudioClip scream = JApplet.newAudioClip(getClass().getResource("scream.aiff"));

    public ScaryMazeGame() throws IOException {
        intro = ImageIO.read(getClass().getResource("Intro.png"));
        level1 = ImageIO.read(getClass().getResource("Level 1.png"));
        level2 = ImageIO.read(getClass().getResource("Level 2.png"));
        level3 = ImageIO.read(getClass().getResource("Level 3.png"));
        gameOver = ImageIO.read(getClass().getResource("Game Over.jpg"));

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
        game.addMouseListener(game);
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

        int level1WallColor = -4758784;
        int level2WallColor = -9628998;
        int level3WallColor = -7272684;
        int goalColor = -15549808;

        if (color == goalColor) {
            if (currentLevel == intro) {
                currentLevel = level1;
            } else if (currentLevel == level1) {
                currentLevel = level2;
            } else if (currentLevel == level2) {
                currentLevel = level3;
            }
        }
        if (color == level1WallColor) {
            currentLevel = intro;
        }
        if (color == level2WallColor) {
            showGameOver();
        }
        if (color == level3WallColor) {
            showGameOver();
        }

        repaint();
    }

    private void showGameOver() {
        scream.play();
        currentLevel = gameOver;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (currentLevel == gameOver) {
            currentLevel = intro;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
