import javax.swing.*;

public class Tile {
    private TileColor tileColor; // the color of the tile
    private ImageIcon tileIcon;

    /**
     * default constructor, sets the tile's color to orange
     */
    public Tile(){
        this.tileColor = TileColor.ORANGE;
        this.tileIcon = new ImageIcon("src/icons/orange.png");
    }

    public void setTileIcon(ImageIcon tileIcon) {
        this.tileIcon = tileIcon;
    }

    public ImageIcon getTileIcon(Tile t){
        return t.tileIcon;
    }

    public TileColor getTileColor(Tile t){
        return t.tileColor;
    }

    public void setTileColor(TileColor tileColor) {
        this.tileColor = tileColor;
    }

    public void setTileIcon(Tile t){
        if(t.tileColor==TileColor.RED){
            t.setTileIcon(new ImageIcon("src/icons/red.jpg"));
        }
        else if(t.tileColor==TileColor.BLUE){
            t.setTileIcon(new ImageIcon("src/icons/blue.jpg"));
        }
        else if(t.tileColor == TileColor.GREEN){
            t.setTileIcon(new ImageIcon("src/icons/green.jpg"));
        }
        else{
            t.setTileIcon(new ImageIcon("src/icons/orange.png"));
        }

    }
}
