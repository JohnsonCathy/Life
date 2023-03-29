import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayerPanel extends JPanel implements ActionListener {
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private JLabel player1 = new JLabel("Player one profile");
    private JLabel player2 = new JLabel("Player two profile");
    private static JLabel money1;
    private static JLabel money2;
    private static JLabel career;
    private static JLabel salary;
    private static JLabel numTurns;
    private static JLabel currentTurn;
    private boolean whoTurn = playerOne.isCurrentPlayer();


    public PlayerPanel(){
        this.add(player1);
        numTurns = new JLabel(String.valueOf(playerOne.getRounds()));
        this.add(numTurns);
        if (whoTurn) {
            currentTurn = new JLabel("Go player one");
        } else {
            currentTurn = new JLabel("Go player two");
        }
        this.add(currentTurn);
        this.add(player2);

        this.add(new JLabel("Money: "));
        money1 = new JLabel(String.valueOf(playerOne.getMoney()));
        this.add(money1);

        this.add(new JLabel("Money: "));
        money2 = new JLabel(String.valueOf(playerTwo.getMoney()));
        this.add(money2);

        this.add(new JLabel("Career: "));
        career = new JLabel(playerOne.getCareer());
        this.add(career);
        this.add(new JLabel("Career: "));
        career = new JLabel(playerTwo.getCareer());
        this.add(career);
        this.add(new JLabel("Salary: "));
        this.add(new JLabel("-void-"));
        //  this.add(salary);
        this.add(new JLabel("Salary: "));
        this.add(new JLabel("-void-"));
        //  this.add(salary);

        /*Grid size will need to be adjusted when label containing actual values are added
         * most likely will be 4,4 but im not sure yet*/
        setLayout(new GridLayout(4,4));

    }

    public void actionPerformed(ActionEvent event) {
        if(ButtonPanel.spinButton == event.getSource()) {
            playerOne.setMoney(500);
            money1.setText(String.valueOf(playerOne.getMoney()));
        }
        else if(event.getSource() == ButtonPanel.careers){
            career.setText(playerOne.getCareer());
        }

    }

}
