package lumber_jack.controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import lumber_jack.view.ForestPanel;
import lumber_jack.model.ForestPlot;

public class ForestController {
    private ForestPanel panel;
    protected ArrayList<ForestPlot> forestPlotGrid;
    
    public ForestController(Dimension parentSize) {
        forestPlotGrid = new ArrayList<>();
        panel = new ForestPanel(parentSize,this);
    }
    
    public void createPlot(JLabel plotButton, int x, int y) {
        forestPlotGrid.add(new ForestPlot(plotButton, x,y));
    }

    public ForestPanel getPanel() {
        return panel;
    }

        
}
