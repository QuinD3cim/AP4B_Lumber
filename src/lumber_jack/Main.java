package lumber_jack;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

import javax.swing.JFrame;

import lumber_jack.view.RessourcePanel;

public class Main extends JFrame {
    public static void main(String[] args) 
    {

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame game = new JFrame("LumberJack");
        game.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        game.setSize(size);

        RessourcePanel ressources = new RessourcePanel(size);
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = size.width/5;
        constraints.ipady = size.height;
        game.add(ressources, constraints);

        game.setVisible(true);

    }
}
