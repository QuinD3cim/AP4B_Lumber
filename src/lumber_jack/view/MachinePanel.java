package lumber_jack.view;

import javax.swing.*;
//import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import lumber_jack.controller.MachineController;
//import lumber_jack.controller.RessourceController;

import java.awt.*;
import java.awt.event.MouseEvent;
//import java.awt.Component;
import java.security.Policy;

public class MachinePanel extends JPanel {

    private transient MachineController controller;
    private int gridWidth = 15;
    private int gridHeight = 10;
    private int cellSize = 0;
    Dimension cellDim = null;
    Dimension panelSize;

    public MachinePanel(Dimension parentSize, MachineController controller)
    {
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        cellDim = new Dimension(cellSize,cellSize);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        //this.setBorder(BorderMachine.createLineBorder(Color.BLACK));
        this.setBackground(Color.lightGray);
        //System.out.println(gteWidth());

        JFrame machines = new JFrame("Machine");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur= (int)size.getHeight()/2;
        int largeur = (int)size.getWidth()/2;
        machines.setSize(largeur,hauteur);
        machines.setVisible(true);

        machines.setBackground(Color.lightGray);
        GridLayout machineLayout = new GridLayout(2,2);

        machines.setLayout(machineLayout);

        //grid = new ForestGrid(getPreferredSize());
        //this.add(grid,BorderLayout.CENTER);
        createMachineGrid(machines);

    }


    protected void createMachineGrid(JFrame machinegrid){
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                JLabel machinePlot = new JLabel(row+";"+col);

                machinePlot.setBackground(Color.LIGHT_GRAY);
                machinePlot.setBorder(BorderFactory.createLineBorder(Color.black));
                machinePlot.addMouseListener(new MachinePanel.GridMouseListener(col,row));
                machinePlot.setPreferredSize(cellDim);

                machinegrid.add(machinePlot);

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




        }
    }
}

