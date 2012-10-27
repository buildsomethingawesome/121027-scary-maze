import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaryMazeGame extends JComponent {

    BufferedImage intro;

    public ScaryMazeGame() throws IOException {
        intro = ImageIO.read(getClass().getResource("Intro.png"));
    }

    public static void main(String args[]) throws IOException {
        JFrame window = new JFrame("Scary Maze by Aaron");
        ScaryMazeGame game = new ScaryMazeGame();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(intro, 0, 0, null);
    }
}
