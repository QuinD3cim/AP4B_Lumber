package lumber_jack.controller;

import java.awt.Dimension;
import lumber_jack.view.MachinePanel;
import lumber_jack.view.RessourcePanel;

public class MachineController {
    private MachinePanel panel;

    public MachineController(Dimension parentSize, RessourcePanel ressource) {
        panel = new MachinePanel(parentSize,this,ressource);
    }

    public MachinePanel getPanel() {
        return panel;
    }
}
