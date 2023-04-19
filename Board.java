import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Board extends JPanel {
    static JTextArea[][] jLabelBoard = new JTextArea[6][9];

    public Board(int start) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 9; col++) {
                this.setLayout(new GridLayout(6, 9));
                if (row == 0 && col == 0) {
                    jLabelBoard[row][col] = new JTextArea("Start");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 255, 255));
                } else if ((start == JOptionPane.YES_OPTION) && (row == 1 && col == 0)) {
                    jLabelBoard[row][col] = new JTextArea(" Life! \nPlayer \nOther!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255, 165, 0));
                } else if ((start == JOptionPane.NO_OPTION) && (row == 5 && col == 1)) {
                    jLabelBoard[row][col] = new JTextArea("PayDay\nPlayer\n Other!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 255, 0));
                } else if (row == 5 && col == 8) {
                    jLabelBoard[row][col] = new JTextArea("End");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 255, 255));
                } else if ((row == 0 || row == 1 || row == 2 || row == 3 || row == 4) && (col == 1 || col == 5)) {
                    jLabelBoard[row][col] = new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 100, 0));
                    jLabelBoard[row][col].setForeground(new Color(0, 120, 0));
                } else if ((row == 1 || row == 2 || row == 3 || row == 4 || row == 5) && (col == 7 || col == 3)) {
                    jLabelBoard[row][col] = new JTextArea("landscape.exe");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 100, 0));
                    jLabelBoard[row][col].setForeground(new Color(0, 120, 0));
                } else if (row == 5 && col == 0) {
                    jLabelBoard[row][col] = new JTextArea("GetJob");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255, 0, 0));
                    jLabelBoard[row][col].setForeground(Color.black);
                } else if (row == 2 && col == 2) {
                    jLabelBoard[row][col] = new JTextArea("Marry!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255, 0, 0));
                    jLabelBoard[row][col].setForeground(Color.black);
                } else if (row == 3 && col == 4) {
                    jLabelBoard[row][col] = new JTextArea("House!");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(255, 0, 0));
                    jLabelBoard[row][col].setForeground(Color.black);
                } else if ((row == 0 && col == 2) || (row == 5 && col == 1) || (row == 2 && col == 6) || (row == 4 && col == 4) || (row == 1 && col == 8)) {
                    jLabelBoard[row][col] = new JTextArea("PayDay");
                    jLabelBoard[row][col].setOpaque(true);
                    jLabelBoard[row][col].setBackground(new Color(0, 255, 0));
                } else {
                    jLabelBoard[row][col] = new JTextArea(" Life!");
                    jLabelBoard[row][col].setBackground(new Color(255, 165, 0));
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
                        str = jLabelBoard[row][col].getText().substring(0, 6);
                        jLabelBoard[row][col].setText(str); //revert the tile back to what it said before
                    for(int r = 0; r<6; r++){
                        for(int c=0; c<9; c++){
                            if(jLabelBoard[r][c].getText().contains("Other!")) {
                                str = jLabelBoard[r][c].getText().substring(0, 6);
                                jLabelBoard[r][c].setText(str); //revert the tile back to what it said before
                            }
                        }
                    }
                    for (int i = 0; i < moves; i++)
                        if(col == 8 && row == 5){
                            JOptionPane.showMessageDialog(null, "Congrats you reached the end! Welcome to retirement");
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
                            row++;
                        }
                        else if ((col == 0 || col==1 || col==4 || col==5 )&& row ==5){
                            col++;
                        }
                        else if ((col == 2 || col==3 || col==6 || col==7 )&& row ==0){
                            col++;
                        }
                        else if (col ==2 || col == 6){
                            row--;
                        }
                        else{
                            row++;
                        }
                    newStr = jLabelBoard[row][col].getText().concat("\n Player");
                    jLabelBoard[row][col].setText(newStr); //puts the player at that tile
                    newStr = jLabelBoard[row-1][col].getText().concat("\n Other!");
                    jLabelBoard[row-1][col].setText(newStr);
                    break;
                }
            }
        }
    }
}
