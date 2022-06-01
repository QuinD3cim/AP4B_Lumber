package lumber_jack.view;

import lumber_jack.controller.RessourceController;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

public class RessourcePanel extends JPanel{

    private RessourceController controller;

    public RessourcePanel(Dimension parentSize)
    {
        controller = new RessourceController();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(0, 0, parentSize.width/5, parentSize.height);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);
        this.addResource("Money",1f);
        this.addResource("Wood",5.5f);
    }

    // Makes a ressource and adds it to the Ressource panel
    private void addResource(String name, float price)
    {
        controller.makeRessource(name, price);
        JLabel label = new JLabel();
        String text = controller.getRessource(controller.getRessourceSize()-1).name + " : " + controller.getRessource(controller.getRessourceSize()-1).quantity;
        label.setText(text);
        this.add(label);
    }
}
