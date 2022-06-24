package lumber_jack.view;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import lumber_jack.controller.ForestController;
//import lumber_jack.controller.RessourceController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.BorderLayout;

//import java.awt.Component;


public class ForestPanel extends JPanel{

    private ForestController controller;
    private int gridWidth = 10;
    private int gridHeight = 8;
    private int cellSize = 0;
    Dimension cellDim = null;
    Dimension panelSize;

    /** 
     * Constructor of a forest panel inheriting from JPanel
     * @param parentSize - Dimension of the parent (the JFrame)
     * @param controller - the controller that generated this panel
     */
    public ForestPanel(Dimension parentSize, ForestController controller)
    {
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(cellSize,cellSize);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        this.setBackground(Color.lightGray);

        createButtonGrid();
        
    }

    /**
     * Method to create the grid of button
     */
    protected void createButtonGrid() {
            
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                JLabel plotButton = new JLabel("");
                controller.createPlot(plotButton, col, row);


                plotButton.setBackground(Color.gray);
                plotButton.setBorder(BorderFactory.createLineBorder(Color.black));
                plotButton.setLayout(new BorderLayout());
                plotButton.setHorizontalAlignment(SwingConstants.CENTER);
                plotButton.setPreferredSize(cellDim);
                add(plotButton);
            }
        }
    }

    

    
}
