package lumber_jack.controller;

import java.awt.Dimension;
import lumber_jack.view.ForestPanel;

public class ForestController {
    private ForestPanel panel;
    
    public ForestController(Dimension parentSize) {
        panel = new ForestPanel(parentSize,this);
    }

    public ForestPanel getPanel() {
        return panel;
    }
}
