import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
    public static void main (String[] args) {
        JFrame board = new JFrame("Game of Life");
        String start = JOptionPane.showInputDialog(board, "Would you like to go to college or start a career?");
        Board gameBoard = new Board(start);
        ActionPanel display = new ActionPanel();
        board.add(gameBoard);
        board.add(display);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(1,2));
        board.pack();
        board.setVisible(true);
    }
}
