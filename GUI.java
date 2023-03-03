import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
    public static void main (String[] args) {
        JFrame board = new JFrame("Game of Life");
        int start = JOptionPane.showConfirmDialog(board, "Would you like to go to college?\n If not you'll start a career", null, JOptionPane.YES_NO_OPTION);
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
