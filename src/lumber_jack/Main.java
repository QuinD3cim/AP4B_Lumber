package lumber_jack;

import java.awt.Dimension;

import javax.swing.JFrame;

import lumber_jack.controller.MenuController;
import lumber_jack.model.IndustryModel;
import lumber_jack.view.MenuView;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        MenuView menu = new MenuView();
        menu.TitleScreen();
    }
}
