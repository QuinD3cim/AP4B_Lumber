package lumber_jack;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import lumber_jack.controller.ForestController;
import lumber_jack.controller.MenuController;
import lumber_jack.model.IndustryModel;
import lumber_jack.view.RessourcePanel;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame game = new JFrame("LumberJack");
        game.setLayout(new GridBagLayout());
        
        game.setSize(size);

        RessourcePanel ressources = new RessourcePanel(size);

        ForestController forestController = new ForestController(size);
        
        game.add(ressources, createSideMenuConstraints(size));
        game.add(forestController.getPanel(),createMainPanelConstraints(size));

        game.setVisible(true);

        new IndustryModel();
        new MenuController();
    }

    private GridBagConstraints createSideMenuConstraints(Dimension size) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = size.width/5;
        constraints.ipady = size.height;
        return constraints;
    }

    private GridBagConstraints createMainPanelConstraints(Dimension size) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.8;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = size.width*4/5;
        constraints.ipady = size.height*4/5;
        return constraints;
    }
}
