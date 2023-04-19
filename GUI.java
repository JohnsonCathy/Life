import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
    public static void main (String[] args) {
        JFrame board = new JFrame("Game of Life");
        //int start = JOptionPane.showConfirmDialog(board, "Would you like to go to college?\n If not you'll start a career","Choose a starting path!",JOptionPane.YES_NO_OPTION);
        Object[] options1 = { "College", "Career"};
        int start = JOptionPane.showOptionDialog(board, "Would you like to go to college or start your career?","Choose a starting path!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
        int start2 =JOptionPane.showOptionDialog(board, "Player 2, would you like to go to college or start your career?","Choose a starting path!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
        Board gameBoard = new Board(start, start2);
        ActionPanel display = new ActionPanel();
        board.add(gameBoard);
        board.add(display);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLayout(new GridLayout(1,2));
        board.pack();
        board.setLocationRelativeTo(null);
        board.setVisible(true);
    }
}
