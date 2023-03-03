import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonPanel extends JPanel {
    private JButton spinButton = new JButton("spin");
    private JButton endTurnButton = new JButton("End turn");
    private JButton buyStockButton = new JButton("Buy stock");
    private JButton careers = new JButton("Careers"); //will be used in release 2
    private JButton salaries = new JButton("Salary");
    private JButton houses = new JButton("Houses");

    private final Random rand = new Random();
    int upper = 6; //max number the spinner can generate
    int moves;

    public ButtonPanel() {
        this.add(endTurnButton);
        endTurnButton.addActionListener(listener);
        this.add(spinButton);
        spinButton.addActionListener(listener);
        this.add(buyStockButton);
        buyStockButton.addActionListener(listener);
        this.add(careers);
        careers.addActionListener(listener);
        this.add(salaries);
        salaries.addActionListener(listener);
        this.add(houses);
        houses.addActionListener(listener);
        setLayout(new GridLayout(2, 3));
    }
    /* Add all the different button actions here*/
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(spinButton)) {
                moves = rand.nextInt(upper - 1) + 1; // +1 makes it so that player can not spin a value of 0
                Board.movement(moves);
                JOptionPane.showMessageDialog(null, "You spun a: " + moves);
            }
        }
    };
}
