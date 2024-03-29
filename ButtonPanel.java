import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class ButtonPanel extends JPanel {
    public static JButton spinButton = new JButton();
    public static JButton endTurnButton = new JButton("End turn");
    public static JButton buyStockButton = new JButton();
    public static JButton careers = new JButton();
    public static JButton salaries = new JButton();
    public static JButton houses = new JButton();
    private boolean myTurn = true;
    private boolean haveSpun = false;
    private final Random rand = new Random();
    int upper = 6; //max number the spinner can generate +1
    int moves;
    int card;
    private final ImageIcon houseCardIcon;
    private final ImageIcon salaryCardIcon;
    private final ImageIcon careerCardIcon;
    private final ImageIcon stockCardIcon;
    private final ImageIcon spinnerIcon;
    public static Player player = new Player();

    public ButtonPanel() {
        houseCardIcon = new ImageIcon("src/icons/house_card.png");
        salaryCardIcon = new ImageIcon("src/icons/salary_card.png");
        careerCardIcon = new ImageIcon("src/icons/career_card.png");
        stockCardIcon = new ImageIcon("src/icons/stock_card.png");
        spinnerIcon = new ImageIcon("src/icons/spinner.jpg");
        ActionListener listener1 = new PlayerPanel();

        this.add(endTurnButton);
        endTurnButton.addActionListener(listener);
        endTurnButton.addActionListener(listener1);

        spinButton.setIcon(spinnerIcon);
        this.add(spinButton);
        spinButton.addActionListener(listener);
        spinButton.addActionListener(listener1);

        buyStockButton.setIcon(stockCardIcon);
        this.add(buyStockButton);
        buyStockButton.addActionListener(listener);
        buyStockButton.addActionListener(listener1);

        careers.setIcon(careerCardIcon);
        this.add(careers);
        careers.addActionListener(listener);
        careers.addActionListener(listener1);

        salaries.setIcon(salaryCardIcon);
        this.add(salaries);
        salaries.addActionListener(listener);
        salaries.addActionListener(listener1);

        houses.setIcon(houseCardIcon);
        this.add(houses);
        houses.addActionListener(listener);
        houses.addActionListener(listener1);

        setLayout(new GridLayout(2, 3));
    }

    /* Add all the different button actions here*/
    private final ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(spinButton)) {
                if (myTurn) {
                    moves = rand.nextInt(upper - 1) + 1; // +1 makes it so that player can not spin a value of 0
                    Board.movement(moves);
                    JOptionPane.showMessageDialog(null, "You spun a: " + moves);
                    myTurn = false;
                    haveSpun = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Slow down! You have already spun this turn. Please finish any remaining actions and press end turn.");
                }
            }

            if (e.getSource().equals(endTurnButton)) {
                if (haveSpun) {
                    JOptionPane.showMessageDialog(null, "Your turn has been ended, The next player may now move.");
                    myTurn = true;
                    haveSpun = false;
                    player.hasStock = false;
                    JOptionPane.showMessageDialog(null,"Player 2 has completed their turn");
                } else {
                    JOptionPane.showMessageDialog(null, "Slow down! You have not spun this turn. Please finish any remaining actions and press spin.");
                }
            }
            if (e.getSource().equals(careers)) {
                Object[] options = {careerCardIcon, careerCardIcon, careerCardIcon, careerCardIcon, careerCardIcon};
                JOptionPane.showOptionDialog(null, "Please draw a career card: ", "Draw a card!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                String[] careerOptions = {"Doctor", "Teacher", "Pilot", "Police Officer", "Salesman"};
                card = rand.nextInt(upper - 1) + 1;
                String pick = careerOptions[card];
                player.setCareer(pick);
            }
            if (e.getSource().equals(houses)) {
                Object[] options = {houseCardIcon, houseCardIcon, houseCardIcon, houseCardIcon, houseCardIcon};
                int choice = JOptionPane.showOptionDialog(null, "Please draw a house card: ", "Draw a card!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (choice == JOptionPane.YES_OPTION) {
                    card = rand.nextInt(upper - 1) + 1;
                    if (card == 1) {
                        player.setHouse("Beach House");
                    }
                    if (card == 2) {
                        player.setHouse("Mansion");
                    }
                    if (card == 3) {
                        player.setHouse("Log Cabin");
                    }
                    if (card == 4) {
                        player.setHouse("Trailer park");
                    }
                    if (card == 5) {
                        player.setHouse("Apartment");
                    }
                }
            }
            if (e.getSource().equals(salaries)) {
                Object[] options = {salaryCardIcon, salaryCardIcon, salaryCardIcon, salaryCardIcon, salaryCardIcon};
                int choice = JOptionPane.showOptionDialog(null, "Please draw a salary card: ", "Draw a card!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (choice == JOptionPane.YES_OPTION) {
                    card = rand.nextInt(upper - 1) + 1;
                    if (card == 1) {
                        player.setSalary(20000);
                    }
                    if (card == 2) {
                        player.setSalary(40000);
                    }
                    if (card == 3) {
                        player.setSalary(60000);
                    }
                    if (card == 4) {
                        player.setSalary(100000);
                    }
                    if (card == 5) {
                        player.setSalary(150000);
                    }
                }
            }
            if (e.getSource().equals(buyStockButton)) {
                Object[] options = {1, 2, 3, 4, 5};
                int choice = JOptionPane.showOptionDialog(null, "Please select the stock you want to buy: ", "Draw a card!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if(!player.hasStock()) {
                    if (choice == 0) {
                        int pick = 1;
                        player.setStock(pick);
                        player.setStock();
                    }
                    if (choice == 1) {
                        int pick = 2;
                        player.setStock(pick);
                        player.setStock();
                    }
                    if (choice == 2) {
                        int pick = 3;
                        player.setStock(pick);
                        player.setStock();
                    }
                    if (choice == 3) {
                        int pick = 4;
                        player.setStock(pick);
                        player.setStock();
                    }
                    if (choice == 4) {
                        int pick = 5;
                        player.setStock(pick);
                        player.setStock();
                    }
                }
                else if(player.hasStock()) {
                    JOptionPane.showMessageDialog(null, "Hang on captain wall street, you already have a stock! You can only have one stock at a time please finish other actions then end your turn.");
                }
            }
        }
    };
}
