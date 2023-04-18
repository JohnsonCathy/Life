import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel {
    static JTextArea[][] jLabelBoard = new JTextArea[6][9];
    private boolean canDraw = false;
    private JLabel backgrounds;
    private ImageIcon grassIcon;
    /**
     * default constructor, sets board to size 6
     */
    public Board(int start) {
        grassIcon = new ImageIcon("src/grass_small.jpg");
        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 9; col ++) {
                this.setLayout(new GridLayout(6, 9));
                if(row==0 && col==0) {
                    jLabelBoard[row][col] = new JTextArea("Start");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,255,255));
                }
                else if(start == JOptionPane.YES_OPTION && (row == 1 && col ==0)){
                    jLabelBoard[row][col]= new JTextArea(" Life! \n Player");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (255,165,0));
                }
                else if(start == JOptionPane.NO_OPTION && (row == 0 && col ==2)){
                    jLabelBoard[row][col]= new JTextArea("PayDay\nPlayer");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color (0,255,0));
                }
                else if(row==5&&col==8){
                    jLabelBoard[row][col]= new JTextArea("End");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,255,255));
                }
                else if((row==0 || row==1 || row ==2 || row==3 || row==4) && col==1){
                    jLabelBoard[row][col]= new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(00,100,00));
                    jLabelBoard[row][col].setForeground(new Color(0,120,0));
                }
                else if((row==0 || row==1 || row ==2 || row==3 || row==4) && col==5){
                    jLabelBoard[row][col]= new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,100,0));
                    jLabelBoard[row][col].setForeground(new Color(0,120,0));
                }
                else if((row==1 || row==2 || row ==3 || row==4 || row==5) && col==7){
                    jLabelBoard[row][col]= new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,100,0));
                    jLabelBoard[row][col].setForeground(new Color(0,120,0));
                    //backgrounds.setIcon(grassIcon);
                    //jLabelBoard[row][col].add(backgrounds);
                }
                else if((row==1 || row==2 || row ==3 || row==4 || row==5) && col==3){
                    jLabelBoard[row][col]= new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,100,0));
                    jLabelBoard[row][col].setForeground(new Color(0,120,0));
                }
                else if(row==5 && col==0){
                    jLabelBoard[row][col]= new JTextArea("GetJob");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                    jLabelBoard[row][col].setForeground(Color.black);
                }
                else if (row ==2 && col==2){
                    jLabelBoard[row][col]= new JTextArea("Marry!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                    jLabelBoard[row][col].setForeground(Color.black);
                }
                else if(row ==3&&col==4){
                    jLabelBoard[row][col]= new JTextArea("House!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255,0,0));
                    jLabelBoard[row][col].setForeground(Color.black);
                }
                else if((row==0 && col==1)||(row==5 &&col==1)||(row==1&&col==3)||(row==4&&col==4)||(row==2&&col==5)){
                    jLabelBoard[row][col]= new JTextArea("PayDay");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0,255,0));
                }
                else {
                    jLabelBoard[row][col]= new JTextArea(" Life!");
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
            for (int col = 0; col < 9; col++) {
                if (jLabelBoard[row][col].getText().contains("Player")) { //if the player is in this tile
                    if(jLabelBoard[row][col].getText().equals("Player")){ // if the tile *only* says player
                        jLabelBoard[row][col].setText("");
                    }
                    else { //if tile says something + player
                        str = jLabelBoard[row][col].getText().substring(0, 6);
                        jLabelBoard[row][col].setText(str); //revert the tile back to what it said before
                    }
                    for (int i = 0; i < moves; i++)
                        if(col == 8 && row == 5){
                            JOptionPane.showInputDialog("Congrats you reached the end! Where would you like to retire?");
                        }
                        else if(jLabelBoard[row][col].getText().equals("GetJob")){
                            JOptionPane.showMessageDialog(null,"Break out the resume, it's time to get a job!");
                            col++;
                        }
                        else if(jLabelBoard[row][col].getText().equals("Marry!")){
                            JOptionPane.showMessageDialog(null,"Do I hear wedding bells? Time to get married!");
                            row--;
                        }
                        else if(jLabelBoard[row][col].getText().equals("House!")){
                            JOptionPane.showMessageDialog(null,"Better get a UHaul, it's time to buy a house!");
                            row--;
                        }
                        else if ((col%2 != 0 || col==0) && row!=5) //if in even col or col zero and not at the turn point
                            row++;
                        else if ((col%2 != 0 || col == 0) && row == 5) //if in even col or col zero and at the turn point
                            col ++;
                        else if (col % 2 == 0 && row != 0) //if in an even col and not at turn point
                            row--;
                        else if (col % 2 == 0 && row == 0) //if in an even col and at turn point
                            col++;
                    newStr = jLabelBoard[row][col].getText().concat("\n Player");
                    jLabelBoard[row][col].setText(newStr); //puts the player at that tile
                    break;
                }
            }
        }
    }



    public boolean getDraw () {return canDraw;}
    public void setDraw () {canDraw = false;}
}
