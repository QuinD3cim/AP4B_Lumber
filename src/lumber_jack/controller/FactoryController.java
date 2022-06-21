package lumber_jack.controller;

import java.awt.Dimension;
import lumber_jack.view.FactoryPanel;
public class FactoryController {
    private FactoryPanel panel;

    public FactoryController(Dimension parentSize) {
        panel = new FactoryPanel(parentSize,this);
    }

    public FactoryPanel getPanel() {
        return panel;
    }
}
