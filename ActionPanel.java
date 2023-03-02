import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private ButtonPanel buttons = new ButtonPanel();
    private PlayerPanel playerInfo = new PlayerPanel();

    public ActionPanel() {
        super();
        this.add(playerInfo);
        this.add(buttons);
        this.setLayout(new GridLayout(2,1));
    }
}
