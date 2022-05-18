package lumber_jack;

import java.awt.Dimension;

import javax.swing.JFrame;

import lumber_jack.controller.MenuController;
import lumber_jack.model.IndustryModel;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        new IndustryModel();
        new MenuController();
        setMinimumSize(new Dimension(800, 800));
        setVisible(true);
    }
}
