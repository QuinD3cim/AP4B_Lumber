package lumber_jack.controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import lumber_jack.view.ForestPanel;
import lumber_jack.model.ForestPlot;
import lumber_jack.model.Lumberjack;
import lumber_jack.model.TreePlanter;

public class ForestController {
    private ForestPanel panel;
    protected ArrayList<ForestPlot> forestPlotGrid;
    
    public ForestController(Dimension parentSize) {
        forestPlotGrid = new ArrayList<>();
        panel = new ForestPanel(parentSize,this);
    }
    
    public void createPlot(JLabel plotButton, int x, int y) {
        ForestPlot newForestPlot = new ForestPlot(plotButton, x,y);
        if (x == 0 && y == 0) {
            newForestPlot.addLumberJackOnPlot(new Lumberjack());
            newForestPlot.addTreePlanterOnPlot(new TreePlanter());
        }
        forestPlotGrid.add(newForestPlot);
    }

    public ForestPanel getPanel() {
        return panel;
    }

        
}
