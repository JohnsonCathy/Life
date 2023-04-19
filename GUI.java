import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static void main (String[] args) {
        JFrame board = new JFrame("Game of Life");
        Object[] options1 = { "College", "Career"};
        int start = JOptionPane.showOptionDialog(board, "Player 1, would you like to go to college or start your career?","Choose a starting path!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
        Board gameBoard = new Board(start);
        ActionPanel display = new ActionPanel();
        board.add(gameBoard);
        board.add(display);
        board.setDefaultCloseOperation(EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(1,2));
        board.pack();
        board.setVisible(true);
    }
}
