package lumber_jack.controller;

import java.awt.Dimension;
import lumber_jack.view.MachinePanel;
public class MachineController {
    private MachinePanel panel;

    public MachineController(Dimension parentSize) {
        panel = new MachinePanel(parentSize,this);
    }

    public MachinePanel getPanel() {
        return panel;
    }
}
