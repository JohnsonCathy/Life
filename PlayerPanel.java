import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel implements ActionListener {
    private static final Player playerOne = ButtonPanel.player;
    private static final Player playerTwo = ButtonPanel.player;
    private final JLabel player1 = new JLabel("Player one profile");
    private final JLabel player2 = new JLabel("Player two profile");
    private static JLabel money1;
    private static JLabel money2;
    private static JLabel career1;
    private static JLabel career2;
    private static JLabel salary1;
    private static JLabel salary2;
    private static JLabel house1;
    private static JLabel house2;
    private static JLabel ownedStock1;
    private static JLabel ownedStock2;
    private static JLabel numTurns;
    private static JLabel currentTurn;
    private boolean whoTurn = playerOne.isCurrentPlayer();


    public PlayerPanel(){
        this.add(player1);
        numTurns = new JLabel("Turn: " + playerOne.getRounds());
        this.add(numTurns);
        currentTurn = new JLabel("Go player one!");
        this.add(currentTurn);
        this.add(player2);

        this.add(new JLabel("Money: "));
        money1 = new JLabel(String.valueOf(playerOne.getMoney()));
        this.add(money1);

        this.add(new JLabel("Money: "));
        money2 = new JLabel(String.valueOf(playerTwo.getMoney()));
        this.add(money2);

        this.add(new JLabel("Career: "));
        career1 = new JLabel(playerOne.getCareer());
        this.add(career1);

        this.add(new JLabel("Career: "));
        career2 = new JLabel(playerTwo.getCareer());
        this.add(career2);

        this.add(new JLabel("Salary: "));
        salary1 = new JLabel(String.valueOf(playerOne.getSalary()));
        this.add(salary1);

        this.add(new JLabel("Salary: "));
        salary2 = new JLabel(String.valueOf(playerTwo.getSalary()));
        this.add(salary2);

        this.add(new JLabel("House: "));
        house1 = new JLabel(playerOne.getHouse());
        this.add(house1);

        this.add(new JLabel("House: "));
        house2 = new JLabel(String.valueOf(playerTwo.getHouse()));
        this.add(house2);

        this.add(new JLabel("Stock: "));
        ownedStock1 = new JLabel(String.valueOf(playerOne.getStock()));
        this.add(ownedStock1);

        this.add(new JLabel("Stock: "));
        ownedStock2 = new JLabel(String.valueOf(playerTwo.getStock()));
        this.add(ownedStock2);

        /*Grid size will need to be adjusted when label containing actual values are added
         * most likely will be 4,4 but im not sure yet*/
        setLayout(new GridLayout(6,4));
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == ButtonPanel.spinButton){
            if(!whoTurn) {
                money1.setText(String.valueOf(playerOne.getMoney()));
            } else {
                money2.setText(String.valueOf(playerTwo.getMoney()));
            }
        }
        if(event.getSource() == ButtonPanel.careers){
            if(!whoTurn) {
                career1.setText(playerOne.getCareer());
            } else {
                career2.setText(playerTwo.getCareer());
            }
        }
        else if(ButtonPanel.endTurnButton == event.getSource()) {
            playerOne.setRounds(playerOne.getRounds() + 2);
            numTurns.setText("Turn: " + playerOne.getRounds());
            if(playerOne.getRounds() % 2 == 1){
                playerOne.isCurrentPlayer = false;
            } else if(playerOne.getRounds() % 2 == 0) {
                playerOne.setCurrentPlayer();
            }
            whoTurn = playerOne.isCurrentPlayer;
            if (!whoTurn) {
                currentTurn.setText("Go player one!");
            } else{
                currentTurn.setText("Go player two!");
            }
        }
        else if(ButtonPanel.houses == event.getSource()) {
            if(!whoTurn) {
                house1.setText(playerOne.getHouse());
            } else {
                house2.setText(playerTwo.getHouse());
            }
        }
        else if(ButtonPanel.salaries == event.getSource()) {
            if(!whoTurn) {
                salary1.setText(String.valueOf(playerOne.getSalary()));
            } else {
                salary2.setText(String.valueOf(playerTwo.getSalary()));
            }
        }
        else if(ButtonPanel.buyStockButton == event.getSource()) {
            if(!whoTurn) {
                ownedStock1.setText(String.valueOf(playerOne.getStock()));
            } else {
                ownedStock2.setText(String.valueOf(playerTwo.getStock()));
            }
        }
    }
}
