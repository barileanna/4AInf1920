import javax.swing.*;
import java.awt.*;

/**
 * Created by inf.barilea1810 on 19/02/2020.
 */
public class Finestra extends JFrame {

    JPanel nPanel;
    JPanel sPanel;
    JPanel wPanel;
    JPanel cPanel;
    JPanel ePanel;


    public Finestra()
    {
        setSize(1200,600);
        setLocation(200, 200);
        setTitle("MyFirstFrame");
        initComponets();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponets() {
        nPanel = new JPanel();
        nPanel.setBackground(Color.YELLOW);
        this.add(nPanel, BorderLayout.NORTH);
        sPanel = new JPanel();
        sPanel.setBackground(Color.BLUE);
        this.add(sPanel, BorderLayout.SOUTH);
        wPanel = new JPanel();
        wPanel.setBackground(Color.WHITE);
        this.add(wPanel, BorderLayout.WEST);
        cPanel = new JPanel();
        cPanel.setBackground(Color.RED);
        this.add(cPanel, BorderLayout.CENTER);
        ePanel = new JPanel();
        ePanel.setBackground(Color.GREEN);
        this.add(ePanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        Finestra finestra = new Finestra();
    }
}
