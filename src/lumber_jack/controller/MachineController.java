package lumber_jack.controller;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.HashMap;

import javax.swing.JButton;

import lumber_jack.model.Machine;
import lumber_jack.view.MachinePanel;
import lumber_jack.view.RessourcePanel;

public class MachineController {
    
    private HashMap<Integer,Machine> machines;
    private RessourcePanel ressource;
    private int buyPrice = 200;

    public MachineController(Dimension parentSize, RessourcePanel ressource) {
        this.machines = new HashMap<>();
        this.ressource = ressource;
        new MachinePanel(parentSize,this,ressource);
    }

    
    /** 
     * @param parentSize
     */
    // Function to create a panel corresponding to the controller
    public void makePanel(Dimension parentSize) {
        new MachinePanel(parentSize,this,ressource);
    }

    
    /** 
     * @param col
     * @param row
     * @param gridWidth
     * @return boolean
     */
    public boolean hasMachine(int col, int row, int gridWidth){
        return (machines.get(row+col*gridWidth) != null);
    }

    
    /** 
     * @return int
     */
    public int getMachinePrice(){
        return this.buyPrice;
    }

    
    /** 
     * @param index
     * @return int
     */
    public int getUpgradePrice(int index){
        return machines.get(index).getPrice();
    }

    public class MachineListener implements ActionListener{
        
        private JButton buyMachine;
        private JButton upgradeMachine;
        private int buttonRow;
        private int buttonCol;
        private int gridWidth;

        public MachineListener(JButton buyMachine, JButton upgradeMachine, int buttonRow, int buttonCol, int gridWidth){
            this.buyMachine = buyMachine;
            this.upgradeMachine = upgradeMachine;
            this.buttonRow = buttonRow;
            this.buttonCol = buttonCol;
            this.gridWidth = gridWidth;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if (buyMachine.isVisible() && ressource.getRessourceQuantity("Money") >= buyPrice) {
                buyMachine.setVisible(false);
                upgradeMachine.setVisible(true);
                machines.put(buttonRow+buttonCol*gridWidth, new Machine(ressource));
                ressource.updateRessource("Money",-buyPrice);
                buyPrice *= 1.5f;
                upgradeMachine.setText("Upgrade : "+getUpgradePrice(buttonRow+buttonCol*gridWidth));
            } else if (upgradeMachine.isVisible() && ressource.getRessourceQuantity("Money") >= buyPrice){
                machines.get(buttonRow+buttonCol*gridWidth).levelUp();
                upgradeMachine.setText("Upgrade : "+getUpgradePrice(buttonRow+buttonCol*gridWidth));
            }
        }
    }
}
