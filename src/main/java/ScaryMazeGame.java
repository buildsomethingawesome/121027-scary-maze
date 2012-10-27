import javax.swing.*;

public class ScaryMazeGame extends JComponent {

    public static void main(String args[]) {
        JFrame window = new JFrame("Scary Maze by Aaron");
        ScaryMazeGame game = new ScaryMazeGame();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
