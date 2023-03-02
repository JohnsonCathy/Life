import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
    public static void main (String[] args) {
        JFrame board = new JFrame("Game of Life");
        /*
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(new Board(),JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(new PlayerPanel(),JLayeredPane.PALETTE_LAYER);
        board.add(layeredPane);
         */
        board.add(new Board());
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.pack();
        //layeredPane.setVisible(true);
        board.setVisible(true);

        /*PlayerPanel p = new PlayerPanel();
        * board.add(p);*/
    }
}
