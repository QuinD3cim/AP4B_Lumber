package lumber_jack;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

import javax.swing.JFrame;

import lumber_jack.controller.FactoryController;
import lumber_jack.controller.ForestController;
import lumber_jack.controller.MenuController;
import lumber_jack.model.IndustryModel;
import lumber_jack.view.MenuView;
import lumber_jack.view.RessourcePanel;


public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        MenuView menu = new MenuView();
        menu.TitleScreen();
    }
}
