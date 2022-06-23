package lumber_jack.controller;

import java.awt.Dimension;
import lumber_jack.view.FactoryPanel;
import lumber_jack.view.RessourcePanel;

public class FactoryController {
    private FactoryPanel panel;

    public FactoryController(Dimension parentSize, RessourcePanel ressource) {
        panel = new FactoryPanel(parentSize,this,ressource);
    }

    public FactoryPanel getPanel() {
        return panel;
    }
}
