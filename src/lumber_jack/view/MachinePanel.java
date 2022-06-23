package lumber_jack.view;

import javax.swing.*;
//import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.DimensionUIResource;

import lumber_jack.controller.MachineController;
import lumber_jack.model.Machine;
import lumber_jack.controller.RessourceController;

import java.awt.*;
import java.awt.event.*;
//import java.awt.Component;
import java.security.Policy;
import java.util.ArrayList;

public class MachinePanel extends JPanel {

    private transient MachineController controller;
    private ArrayList<Machine> machines;
    private int gridWidth = 15;
    private int gridHeight = 10;
    private int cellSize = 0;

    private int row;

    private int col;
    Dimension cellDim = null;
    Dimension panelSize;
    RessourcePanel ressource;

    public MachinePanel(Dimension parentSize, MachineController controller,RessourcePanel ressource)
    {
        this.machines = new ArrayList<>();
        this.controller = controller;
        panelSize = new Dimension((int) parentSize.getWidth()*4/5,(int) parentSize.getHeight()*4/5);
        setSize(panelSize);
        cellSize = (int) Math.min(panelSize.getWidth(),panelSize.getHeight()) / Math.max(gridWidth,gridHeight);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        cellDim = new Dimension((int)size.getHeight()/4,(int)size.getHeight()/4);
        GridLayout grid = new GridLayout(gridHeight, gridWidth);
        this.setLayout(grid);
        this.ressource= ressource;
        //this.setBorder(BorderMachine.createLineBorder(Color.BLACK));
        this.setBackground(Color.lightGray);
        //System.out.println(gteWidth());


        //JPanel machines = new JPanel();
        //machines.setLayout(new GridLayout(2, 2));
        JFrame machineFrame = new JFrame("Machine");

        //JButton one = new JButton("Buy machine 1");
        //JButton two = new JButton("Buy machine 2");
        //JButton three = new JButton("Buy machine 3");
        //JButton four = new JButton("Buy machine 4");

        //machines.add(one);
        //machines.add(two);
        //machines.add(three);
        //machines.add(four);


        int hauteur= (int)size.getHeight()/2;
        int largeur = (int)size.getWidth()/2;

        //machineFrame.add(machines);

        machineFrame.setSize(largeur,hauteur);
        machineFrame.setVisible(true);


        machineFrame.setBackground(Color.lightGray);
        GridLayout machineLayout = new GridLayout(2,2);

        machineFrame.setLayout(machineLayout);

        //this.add(grid,BorderLayout.CENTER);
        createMachineGrid(machineFrame);

    }


    protected void createMachineGrid(JFrame machinegrid){
        for (row = 0; row < 2; row++) {
            for (col = 0; col < 2; col++) {
                JPanel machinePanel = new JPanel();
                JLabel machinePlot = new JLabel();
                JButton buyMachine = new JButton();
                buyMachine.setSize(50,75);
                buyMachine.setText("Buy Machine " +row +" "+col);

                JButton upgradeMachine = new JButton("Upgrade");
                upgradeMachine.setSize(50,75);
                upgradeMachine.setVisible(false);

                buyMachine.addActionListener(e-> {
                    if ( buyMachine.isVisible() && ressource.getRessourceQuantity("Money") > 500) {
                        buyMachine.setVisible(false);
                        upgradeMachine.setVisible(true);
                        if(col==0 && machines.size()<(col+row)){
                            machines.add(new Machine());
                        }else if(col==1 && machines.size()<(col+row+1)){
                            machines.add(new Machine());
                        }else{
                            if(col == 0){
                                machines.add(row+col,new Machine());
                            }else{
                                machines.add(row+col+1,new Machine());
                            }
                        }

                        ressource.updateRessource("Money",-500);
                    }

                });


                machinePanel.add(machinePlot);
                machinePanel.add(buyMachine);
                machinePanel.add(upgradeMachine);

                machinePlot.setBackground(Color.LIGHT_GRAY);
                machinePlot.setBorder(BorderFactory.createLineBorder(Color.black));
                machinePlot.addMouseListener(new MachinePanel.GridMouseListener(col,row));
                machinePlot.setPreferredSize(cellDim);

                buyMachine.setVisible(true);

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
        public void mousePressed(MouseEvent e) {




        }
    }


}

