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
    
    /**
     * A controller for the forest panel
     * @param parentSize - Dimension of the parent
     */
    public ForestController(Dimension parentSize) {
        forestPlotGrid = new ArrayList<>();
        panel = new ForestPanel(parentSize,this);
    }
    

    /**
     * Method to create a forest plot and link it with the appropriate JLabel from JPanel
     * @param plotButton - JLabel representing a button for the forestplot
     * @param x - int, x position of the forest plot
     * @param y - int, y position of the forest plot
     */
    public void createPlot(JLabel plotButton, int x, int y) {
        ForestPlot newForestPlot = new ForestPlot(plotButton, x,y);
        if (x == 0 && y == 0) {
            newForestPlot.addLumberJackOnPlot(new Lumberjack());
            newForestPlot.addTreePlanterOnPlot(new TreePlanter());
        }
        forestPlotGrid.add(newForestPlot);
    }

    /**
     * Method to get get the panel from he controller
     * @return the ForestPanel linked with this controller
     */
    public ForestPanel getPanel() {
        return panel;
    }

        
}
