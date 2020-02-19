import javax.swing.*;
import java.awt.*;

/**
 * Created by inf.barilea1810 on 19/02/2020.
 */
public class Finestra extends JFrame {


    public Finestra()
    {
        setSize(300,300);
        setLocation(200, 200);
        setTitle("MyFirstFrame");
        initComponets();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponets() {
        JPanel centerPanel = new JPanel();
        BoxLayout centerPanelLayout = new BoxLayout(centerPanel,  BoxLayout.Y_AXIS);
        centerPanel.setLayout(centerPanelLayout);
        JButton button = new JButton("button");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton shortButton = new JButton("short");
        shortButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton IongButton = new JButton("long-long - long button");
        IongButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(button); centerPanel.add(shortButton);
        centerPanel.add(IongButton);
        this.add(centerPanel);
        JPanel sPanel = new JPanel();
        JButton okButton = new JButton();
        okButton.setText("OK");
        sPanel.add(okButton);
        JButton cancelButton = new JButton();
        cancelButton.setText("Cancel");
        sPanel.add(cancelButton);
        this.add(sPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }
}
