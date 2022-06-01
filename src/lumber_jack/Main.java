package lumber_jack;

import java.awt.Dimension;

import javax.swing.JFrame;

import lumber_jack.view.RessourcePanel;

public class Main extends JFrame {
    public static void main(String[] args) 
    {

        Dimension size = new Dimension(800, 800);

        JFrame game = new JFrame("LumberJack");
        game.setSize(size);

        RessourcePanel ressources = new RessourcePanel(size);
        game.add(ressources);

        game.setMinimumSize(size);
        game.setLayout(null);
        game.setVisible(true);

    }
}
