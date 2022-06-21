package lumber_jack.view;

import javax.swing.*;
//import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import lumber_jack.controller.FactoryController;
import lumber_jack.controller.MachineController;
//import lumber_jack.controller.RessourceController;

import java.awt.*;
import java.awt.event.MouseEvent;
//import java.awt.Component;
import java.security.Policy;

public class FactoryPanel extends JPanel {

    private transient FactoryController controller;
    private int gridWidth = 15;
    private int gridHeight = 10;
    private int cellSize = 0;
    Dimension cellDim = null;
    Dimension panelSize;

    public FactoryPanel(Dimension parentSize, FactoryController controller)
    {
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(cellSize,cellSize);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.lightGray);
        //System.out.println(gteWidth());


        //grid = new ForestGrid(getPreferredSize());
        //this.add(grid,BorderLayout.CENTER);
        createButtonGrid();

    }
    protected void createButtonGrid() {

        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                JLabel plotButton = new JLabel(row+";"+col);

                plotButton.setBackground(Color.gray);
                plotButton.setBorder(BorderFactory.createLineBorder(Color.black));
                plotButton.addMouseListener(new FactoryPanel.GridMouseListener(col,row));
                plotButton.setPreferredSize(cellDim);
                add(plotButton);
            }
        }
    }

    protected void createMachineGrid(){
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                JLabel machinePlot = new JLabel(row+";"+col);

                machinePlot.setBackground(Color.blue);
                machinePlot.setBorder(BorderFactory.createLineBorder(Color.red));
                machinePlot.addMouseListener(new FactoryPanel.GridMouseListener(col,row));
                machinePlot.setPreferredSize(cellDim);
                add(machinePlot);
            }
        }
    }



    private class GridMouseListener extends MouseInputAdapter {
        private int xPos;
        private int yPos;

        public GridMouseListener(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        @Override
        public void mousePressed(MouseEvent e) {

            MachineController machineController = new MachineController(getParent().getSize());




        }
    }
}

