import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private JLabel player1 = new JLabel("Player one profile");
    private JLabel player2 = new JLabel("Player two profile");
    private JLabel money;
    private JLabel career;
    private JLabel salary;
    private JLabel numTurns;
    private JLabel currentTurn;
    private boolean whoTurn = playerOne.isCurrentPlayer();

    public PlayerPanel(){
        this.add(player1);
        numTurns = new JLabel(String.valueOf(playerOne.getRounds()));
        this.add(numTurns);
        if (whoTurn == true) {
            currentTurn = new JLabel("Go player one");
        } else {
            currentTurn = new JLabel("Go player two");
        }
        this.add(currentTurn);
        this.add(player2);
        this.add(new JLabel("Money: "));
        money = new JLabel(String.valueOf(playerOne.getMoney()));
        this.add(money);
        this.add(new JLabel("Money: "));
        money = new JLabel(String.valueOf(playerTwo.getMoney()));
        this.add(money);
        this.add(new JLabel("Career: "));
        this.add(new JLabel("-void-"));
        // this.add(career);
        this.add(new JLabel("Career: "));
        this.add(new JLabel("-void-"));
        // this.add(career);
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
}
