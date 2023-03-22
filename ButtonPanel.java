import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ButtonPanel extends JPanel {
    private JButton spinButton = new JButton();
    private JButton endTurnButton = new JButton("End turn");
    private JButton buyStockButton = new JButton();
    private JButton careers = new JButton(); //will be used in release 2
    private JButton salaries = new JButton();
    private JButton houses = new JButton();
    private boolean myTurn = true;
    private final Random rand = new Random();
    int upper = 6; //max number the spinner can generate
    int moves;
    private ImageIcon houseCardIcon;
    private ImageIcon salaryCardIcon;
    private ImageIcon careerCardIcon;
    private ImageIcon stockCardIcon;
    private ImageIcon spinnerIcon;
    private Player player = new Player();

    public ButtonPanel() {
        houseCardIcon = new ImageIcon("src/house_card.png");
        salaryCardIcon = new ImageIcon("src/salary_card.png");
        careerCardIcon = new ImageIcon("src/career_card.png");
        stockCardIcon = new ImageIcon("src/stock_card.png");
        spinnerIcon = new ImageIcon("src/spinner.jpg");

        this.add(endTurnButton);
        endTurnButton.addActionListener(listener);
        spinButton.setIcon(spinnerIcon);
        this.add(spinButton);
        spinButton.addActionListener(listener);
        buyStockButton.setIcon(stockCardIcon);
        this.add(buyStockButton);
        buyStockButton.addActionListener(listener);
        careers.setIcon(careerCardIcon);
        this.add(careers);
        careers.addActionListener(listener);
        salaries.setIcon(salaryCardIcon);
        this.add(salaries);
        salaries.addActionListener(listener);
        houses.setIcon(houseCardIcon);
        this.add(houses);
        houses.addActionListener(listener);
        setLayout(new GridLayout(2, 3));
    }

    /* Add all the different button actions here*/
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(spinButton)) {
                if (myTurn == true) {
                    moves = rand.nextInt(upper - 1) + 1; // +1 makes it so that player can not spin a value of 0
                    Board.movement(moves);
                    JOptionPane.showMessageDialog(null, "You spun a: " + moves);
                    myTurn = false;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Slow down! You have already spun this turn. Please finish any remaining actions and press end turn.");
                }
            }

            if (e.getSource().equals(endTurnButton)) {
                JOptionPane.showMessageDialog(null, "Your turn has been ended, The next player may now move.");
                myTurn = true;
                player.setRounds(player.getRounds() + 1);
            }
            if (e.getSource().equals(careers)) {
                Object[] options = {careerCardIcon, careerCardIcon, careerCardIcon, careerCardIcon, careerCardIcon};
                int choice = JOptionPane.showOptionDialog(null, "Please draw a career card: ","Draw a card!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }
            if (e.getSource().equals(houses)) {
                Object[] options = { houseCardIcon, houseCardIcon, houseCardIcon, houseCardIcon, houseCardIcon};
                int choice = JOptionPane.showOptionDialog(null, "Please draw a house card: ","Draw a card!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION || choice == JOptionPane.YES_NO_OPTION || choice == JOptionPane.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null,"it works");
                }
                else{
                    JOptionPane.showMessageDialog(null,"it kinda works");
                }
            }
            if (e.getSource().equals(salaries)) {
                Object[] options = {salaryCardIcon, salaryCardIcon, salaryCardIcon, salaryCardIcon, salaryCardIcon};
                int choice = JOptionPane.showOptionDialog(null, "Please draw a salary card: ","Draw a card!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }
            if (e.getSource().equals(buyStockButton)) {
                //Object[] options = { new JButton("one", houseCardIcon), new JButton("two", houseCardIcon), new JButton("three", houseCardIcon), new JButton("four", houseCardIcon), new JButton("five", houseCardIcon)};
                JOptionPane.showMessageDialog(null,"This button is useless, carry on.");
                //int choice = JOptionPane.showOptionDialog(null, "Please draw a house card: ","Draw a card!",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            }
            
        }
    };

