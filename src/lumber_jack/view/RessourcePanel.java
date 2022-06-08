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

    public RessourcePanel(Dimension parentSize)
    {
        controller = new RessourceController();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(0, 0, parentSize.width/5, parentSize.height);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);
        this.addResource("Money",1f);
        this.updateRessource("Money", 1000);
        this.addResource("Wood",5.5f);
    }

    // Makes a ressource and adds it to the Ressource panel
    public void addResource(String name, float price)
    {
        controller.makeRessource(name, price);
        JLabel label = new JLabel();
        String text = controller.getRessource(controller.getRessourceSize()-1).getType() + " : " + controller.getRessource(controller.getRessourceSize()-1).getStock().getCurrentValue();
        label.setText(text);
        this.add(label);
        this.refreshView();
    }

    private void updateRessource(String name, int quantity)
    {
        controller.changeRessource(name, quantity);
        this.refreshView();
        
    }

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
