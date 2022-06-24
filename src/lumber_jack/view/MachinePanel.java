package lumber_jack.view;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import lumber_jack.controller.MachineController;

import java.awt.*;
import java.awt.event.*;

public class MachinePanel extends JPanel {

    private transient MachineController controller;
    private int gridWidth = 15;
    private int gridHeight = 10;
    Dimension cellDim = null;
    Dimension panelSize;
    RessourcePanel ressource;

    public MachinePanel(Dimension parentSize, MachineController controller,RessourcePanel ressource)
    {
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        cellDim = new Dimension((int)size.getHeight()/4,(int)size.getHeight()/4);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        this.ressource= ressource;
        this.setBackground(Color.lightGray);

        JFrame machineFrame = new JFrame("Machine");

        int hauteur= (int)size.getHeight()/2;
        int largeur = (int)size.getWidth()/2;

        machineFrame.setSize(largeur,hauteur);
        machineFrame.setVisible(true);


        machineFrame.setBackground(Color.lightGray);
        GridLayout machineLayout = new GridLayout(2,2);

        machineFrame.setLayout(machineLayout);

        createMachineGrid(machineFrame);

    }


    
    /** 
     * @param machinegrid
     */
    protected void createMachineGrid(JFrame machinegrid){
        
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                JPanel machinePanel = new JPanel();
                JLabel machinePlot = new JLabel();
                JButton buyMachine = new JButton();
                buyMachine.setSize(50,75);
                buyMachine.setText("Buy Machine : " + controller.getMachinePrice());

                JButton upgradeMachine = new JButton("Upgrade");
                upgradeMachine.setSize(50,75);

                buyMachine.addActionListener(controller.new MachineListener(buyMachine, upgradeMachine, row, col, gridWidth));
                upgradeMachine.addActionListener(controller.new MachineListener(buyMachine, upgradeMachine, row, col, gridWidth));


                machinePanel.add(machinePlot);
                machinePanel.add(buyMachine);
                machinePanel.add(upgradeMachine);

                machinePlot.setBackground(Color.LIGHT_GRAY);
                machinePlot.setBorder(BorderFactory.createLineBorder(Color.black));
                machinePlot.addMouseListener(new MachinePanel.GridMouseListener(col,row));
                machinePlot.setPreferredSize(cellDim);

                if(controller.hasMachine(col,row,gridWidth)){
                    upgradeMachine.setText("Upgrade : "+ controller.getUpgradePrice(row+col*gridWidth));
                    upgradeMachine.setVisible(true);
                    buyMachine.setVisible(false);
                } else {
                    upgradeMachine.setVisible(false);
                    buyMachine.setVisible(true);
                }

                machinegrid.add(machinePanel);

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
        public void mousePressed(MouseEvent e) {}
    }


}

