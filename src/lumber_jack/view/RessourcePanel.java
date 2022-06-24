package lumber_jack.view;

import lumber_jack.controller.RessourceController;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

public class RessourcePanel extends JPanel{

    private transient RessourceController controller;

    // Constructor for the Ressource panel
    public RessourcePanel(Dimension parentSize)
    {
        controller = new RessourceController(this);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(0, 0, parentSize.width/5, parentSize.height);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);
        this.addResource("Money",1f);
        this.updateRessource("Money", 1000);
        this.addResource("Wood",5.5f);
        this.updateRessource("Wood", 1000);
        this.addResource("Plank",7f);
    }

    // Makes a ressource and adds it to the Ressource panel
    // - String name : name of the ressource
    // - float price : sell price of the ressource
    public void addResource(String name, float price)
    {
        controller.makeRessource(name, price);
        JLabel label = new JLabel();
        String text = controller.getRessource(controller.getRessourceSize()-1).getType() + " : " + controller.getRessource(controller.getRessourceSize()-1).getStock().getCurrentValue();
        label.setText(text);
        this.add(label);
        this.refreshView();
    }


    // Update the quantity of the ressource "name"
    // - String name : name of the ressource
    // - int quantity : quantity to add to the stock (can be negative)
    public void updateRessource(String name, int quantity)
    {
        controller.changeRessource(name, quantity);
        this.refreshView();
        
    }

    // Returns the quantity of the ressource "name"
    // - String name : name of the ressource 
    public int getRessourceQuantity(String name)
    {
        return controller.getRessource(name).getStock().getCurrentValue();
    }


    // Updates the Panel to show the updated values

    private void refreshView(){
        int n = 0;
        for(Component jc : this.getComponents())
        {
            if(jc instanceof JLabel)
            {
                JLabel label = (JLabel)jc;
                String text = controller.getRessource(n).getType() + " : " + controller.getRessource(n).getStock().getCurrentValue();
                label.setText(text);

                n++;
            }
        }
    }
}
