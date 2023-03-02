import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonPanel extends JPanel {
    private JButton spinButton = new JButton("spin");
    private JButton endTurnButton = new JButton("End turn");
    private JButton buyStockButton = new JButton("Buy stock");

    private final Random rand = new Random();
    int upper = 5; //max number the spinner can generate
    int moves;

    public ButtonPanel() {
        this.add(endTurnButton);
        endTurnButton.addActionListener(listener);
        this.add(spinButton);
        spinButton.addActionListener(listener);
        this.add(buyStockButton);
        buyStockButton.addActionListener(listener);
        setLayout(new GridLayout(1, 3));
    }
    /* Add all the different button actions here*/
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(spinButton)) {
                moves = rand.nextInt(upper);
                Board.movement(moves);
            }
        }
    };
}
