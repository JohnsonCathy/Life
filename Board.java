import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    static JTextField[][] jLabelBoard = new JTextField[6][6];
    private ImageIcon P1Icon = new ImageIcon("src/icons/black-car.jpg");
    private ImageIcon P2Icon = new ImageIcon("src/icons/white-car.png"); //not currently used, will change in 2nd release

    /**
     * default constructor, sets board to size 6
     */
    public Board(String start) {
        JPanel mainPanel = new JPanel();

        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 6; col ++) {
                this.setLayout(new GridLayout(6, 6));
                if(row==0 && col==0){
                    jLabelBoard[row][col] = new JTextField("Start");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(211,211,211));
                }
                else if(start.equals("college") && (row == 1 && col ==0)){
                    jLabelBoard[row][col] = new JTextField("Player");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (255,165,0));
                }
                else if(start.equals("career") && (row == 0 && col ==1)){
                    jLabelBoard[row][col] = new JTextField("Pay \n Player");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (0,255,0));
                }
                else if(row==5&&col==5){
                    jLabelBoard[row][col] = new JTextField("End");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(211,211,211));
                }
                else if(row==5 && col==0){
                    jLabelBoard[row][col] = new JTextField("Job");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if (row ==2 && col==2){
                    jLabelBoard[row][col] = new JTextField("Marry");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if(row ==3&&col==3){
                    jLabelBoard[row][col] = new JTextField("House");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if((row==0 && col==1)||(row==5 &&col==1)||(row==1&col==3)||(row==4&&col==4)||(row==2&&col==5)){
                    jLabelBoard[row][col] = new JTextField("Pay");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,255,0));
                }
                else {
                    jLabelBoard[row][col] = new JTextField();
                    jLabelBoard[row][col].setBackground(new Color (255,165,0));
                }
                jLabelBoard[row][col].setEditable(false);
                jLabelBoard[row][col].setOpaque(true);
                jLabelBoard[row][col].setBorder(new LineBorder(Color.black, 1));
                jLabelBoard[row][col].setPreferredSize(new Dimension(75, 75));
                this.add(jLabelBoard[row][col]);
            }
        }
    }


    public static void movement(int moves) {
        String str = "";
        String newStr ="";
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (jLabelBoard[row][col].getText().contains("Player")) { //if the player is in this tile
                    if(jLabelBoard[row][col].getText().equals("Player")){ // if the tile *only* says player
                        jLabelBoard[row][col].setText("");
                    }
                    else { //if tile says something + player
                        /*
                        int start = 0;
                        int end = 0;
                        try {
                            start = jLabelBoard[row][col].getLineEndOffset(0);
                            end = jLabelBoard[row][col].getLineEndOffset(1);
                        } catch (BadLocationException ex) {
                            System.out.println(ex);
                        }
                        jLabelBoard[row][col].replaceRange("", start, end);
                         */
                        str = jLabelBoard[row][col].getText().substring(0, 6);
                        jLabelBoard[row][col].setText(str); //revert the tile back to what it said before
                    }
                    for (int i = 0; i < moves; i++)
                        if ((col%2 != 0 || col==0) && row!=5) //if in even col or col zero and not at the turn point
                            row++;
                        else if ((col%2 != 0 || col == 0) && row == 5) //if in even col or col zero and at the turn point
                            col++;
                        else if (col % 2 == 0 && row != 0) //if in an even col and not at turn point
                            row--;
                        else if (col % 2 == 0 && row == 0) //if in an even col and at turn point
                            col++;
                        if(col == 5 && row == 5){
                            JOptionPane.showInputDialog("Congrats you reached the end! Where would you like to retire?");
                        }
                    newStr = jLabelBoard[row][col].getText().concat("\n Player");
                    jLabelBoard[row][col].setText(newStr); //puts the player at that tile
                    break;
                }
            }
        }
    }
}
