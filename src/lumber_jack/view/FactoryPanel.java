package lumber_jack.view;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import lumber_jack.controller.FactoryController;
import lumber_jack.controller.MachineController;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class FactoryPanel extends JPanel {

    private transient FactoryController controller;
    private int gridWidth = 15;
    private int gridHeight = 10;
    private int cellSize = 0;
    Dimension cellDim = null;
    Dimension panelSize;
    //RessourceController to give to the machines
    private RessourcePanel ressource;
    //MachinePanel list
    private HashMap<Integer,MachineController> machineLines;
    //Terrain price
    private int terrainPrice = 500;

    public FactoryPanel(Dimension parentSize, FactoryController controller, RessourcePanel ressource)
    {
        this.controller = controller;
        this.ressource = ressource;
        this.machineLines = new HashMap<>();

        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(cellSize,cellSize);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        
        this.setBackground(Color.lightGray);

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
                this.add(plotButton);
            }
        }
    }


    private void buyLand(int xPos, int yPos, int gridWidth){
        machineLines.put(xPos + yPos*gridWidth, new MachineController(getSize(), ressource));
        ressource.updateRessource("Money", -terrainPrice);
        terrainPrice *= 1.5f;
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

            if(machineLines.get(xPos+yPos*gridWidth)!=null){
                machineLines.get(xPos+yPos*gridWidth).makePanel(getSize());
            } else if (ressource.getRessourceQuantity("Money")>terrainPrice){
                buyLand(xPos, yPos, gridWidth);
            }

        }
    }
}

