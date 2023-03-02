import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

public class Board extends JPanel {
    private final LinkedList<LinkedList<Tile>> b = new LinkedList<LinkedList<Tile>>();
    private TileStatus status;
    private Random rand;
    int upper = 5; //max number the spinner can generate
    int moves;
    private final JButton spinButton = new JButton("Spin");
    JTextField[][] jLabelBoard = new JTextField[6][6];

    /*
    private JButton careers;
    private JButton salaries;
    private JButton houses;
    private JButton stocks;
     */
    private ImageIcon P1Icon = new ImageIcon("src/icons/black-car.jpg");
    private ImageIcon P2Icon = new ImageIcon("src/icons/white-car.png"); //not currently used, will change in 2nd release


    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(spinButton)){
                moves = rand.nextInt(upper);
                movement(moves,P1Icon);
            }
        }
    };

    /**
     * default constructor, sets board to size 6
     */
    public Board() {
        JPanel mainPanel = new JPanel();
        //this.add(spinButton); //move to
        this.setLayout(new GridLayout(6,6));

        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 6; col ++) {
                this.setLayout(new GridLayout(6, 6));
                //if(jLabelBoard[row][col].status == TileStatus.EMPTY);
                jLabelBoard[row][col] = new JTextField("Test");
                jLabelBoard[row][col].setEditable(false);
                jLabelBoard[row][col].setOpaque(true);
                jLabelBoard[row][col].setBorder(new LineBorder(Color.black, 1));
                jLabelBoard[row][col].setBackground(new Color (255,165,0));
                jLabelBoard[row][col].setPreferredSize(new Dimension(75, 75));
                this.add(jLabelBoard[row][col]);
            }
        }
        spinButton.addActionListener(listener);
    }

    public void movement(int moves, ImageIcon icon){
        for(int i=0;i<6;i++){
            for(int j=0; j<6;j++){
                Tile t = getTile(i,j);
                if(t.getTileIcon(t) == icon){
                    for(int x=0; x<moves;x++){
                        if((i%2 !=0 || i==0)&& j!=5)
                            j++;
                        else if((i%2 !=0 || i==0)&& j==5)
                            i++;
	                    else if(i%2==0 && j!=0)
                            j--;
                        else if (i%2==0 && j==0)
                            i++;
                        Tile newTile = getTile(i,j);
                        newTile.setTileIcon(P1Icon);
                        t.setTileIcon(t);
                    }
                }
            }
        }
    }


    /**
     * makes sure the row and col are within the board size, and gets the tile needed
     * @param row the row the tile is in
     * @param col the column the tile is in
     * @return the tile requested
     */
    public Tile getTile(int row, int col) {
        if (row > 6) {
            throw new IllegalArgumentException("row number greater than size");
        }
        if (row < 0) {
            throw new IllegalArgumentException("row number less than size");
        }
        if (col > 6) {
            throw new IllegalArgumentException("col number greater than size");
        }
        if (col < 0) {
            throw new IllegalArgumentException("col number less than size");
        }
        return b.get(row).get(col);
    }

    /**
     * makes sure the row and col are in the board size and sets the data into that tile
     * @param row the row the tile is in
     * @param col the column the tile is in
     * @param t the data being given to the tile
     */
    public void setTile(int row, int col, Tile t) {
        if (row > 6) {
            throw new IllegalArgumentException("row number greater than size");
        }
        if (row < 0) {
            throw new IllegalArgumentException("row number less than size");
        }
        if (col > 6) {
            throw new IllegalArgumentException("col number greater than size");
        }
        if (col < 0) {
            throw new IllegalArgumentException("col number less than size");
        }
        b.get(row).set(col, t);
    }

}
