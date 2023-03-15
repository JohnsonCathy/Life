import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    static JTextArea[][] jLabelBoard = new JTextArea[6][6];
    
    /**
     * default constructor, sets board to size 6
     */
    public Board(int start) {
        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 6; col ++) {
                this.setLayout(new GridLayout(6, 6));
                if(row==0 && col==0){
                    jLabelBoard[row][col] = new JTextArea("Start");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(211,211,211));
                }
                else if(start == JOptionPane.YES_OPTION && (row == 1 && col ==0)){
                    jLabelBoard[row][col] = new JTextArea(" Life! \n Player");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (255,165,0));
                }
                else if(start == JOptionPane.NO_OPTION && (row == 0 && col ==1)){
                    jLabelBoard[row][col] = new JTextArea("PayDay\nPlayer");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (0,255,0));
                }
                else if(row==5&&col==5){
                    jLabelBoard[row][col] = new JTextArea("End");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(211,211,211));
                }
                else if(row==5 && col==0){
                    jLabelBoard[row][col] = new JTextArea("GetJob");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if (row ==2 && col==2){
                    jLabelBoard[row][col] = new JTextArea("Marry!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if(row ==3&&col==3){
                    jLabelBoard[row][col] = new JTextArea("House!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                }
                else if((row==0 && col==1)||(row==5 &&col==1)||(row==1&col==3)||(row==4&&col==4)||(row==2&&col==5)){
                    jLabelBoard[row][col] = new JTextArea("PayDay");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,255,0));
                }
                else {
                    jLabelBoard[row][col] = new JTextArea(" Life!");
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
                        str = jLabelBoard[row][col].getText().substring(0, 6);
                        jLabelBoard[row][col].setText(str); //revert the tile back to what it said before
                    }
                    for (int i = 0; i < moves; i++)
                        if(col == 5 && row == 5){
                            JOptionPane.showInputDialog("Congrats you reached the end! Where would you like to retire?");
                        }
                        else if ((col%2 != 0 || col==0) && row!=5) //if in even col or col zero and not at the turn point
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
