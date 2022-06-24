package lumber_jack.view;

import lumber_jack.controller.UpgradeController;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class UpgradePanel extends JPanel{

    private transient UpgradeController controller;
    private RessourcePanel ressources;
    private JPanel lumberjackPanel;

    public UpgradePanel(Dimension parentSize, RessourcePanel ressource)
    {
        // Initializing the controller and the main window
        controller = new UpgradeController();
        ressources = ressource;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBounds(parentSize.width/5, 4*parentSize.height/5, parentSize.width, parentSize.height/5);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.GRAY);

        // Lumberjack upgrades
        lumberjackPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lumberjackPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Lumberjack Upgrades"));

        JLabel label = new JLabel();
        String text = "Speed : Level " + controller.getLevel(0, 0);
        label.setText(text);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        lumberjackPanel.add(label,c);

        JButton button = new JButton("Upgrade");
        button.addActionListener(e -> lumberSpeedUpgrade());
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        lumberjackPanel.add(button,c);

        label = new JLabel();
        text = "cost : "+controller.getPrice(0, 0);
        label.setText(text);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        lumberjackPanel.add(label,c);

        label = new JLabel();
        text = "Efficiency : Level " + controller.getLevel(0, 1);
        label.setText(text);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        lumberjackPanel.add(label,c);

        button = new JButton("Upgrade");
        button.addActionListener(e -> lumberEfficiencyUpgrade());
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        lumberjackPanel.add(button,c);

        label = new JLabel();
        text = "cost : "+controller.getPrice(0, 1);
        label.setText(text);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        lumberjackPanel.add(label,c);

        this.add(lumberjackPanel);
    }

    private void lumberSpeedUpgrade()
    {
        if(ressources.getRessourceQuantity("Money") > controller.getPrice(0, 0))
        {
            ressources.updateRessource("Money", -controller.getPrice(0, 0));
            controller.upgrade(0,0);
            this.update();
        }
    }

    private void lumberEfficiencyUpgrade()
    {
        if(ressources.getRessourceQuantity("Money") > controller.getPrice(0, 1))
        {
            ressources.updateRessource("Money", -controller.getPrice(0, 1));
            controller.upgrade(0,1);
            this.update();
        }
    }
    
    private void update()
    {
        for(Component jc : this.getComponents())
        {
            if (jc instanceof JPanel)
            {
                JPanel panel = (JPanel)jc;
                this.updatePanel(panel);
            }
        }
    }

    private void updatePanel(JPanel panel)
    {
        int n = 0;
        int i = 0;
        for(Component jc : panel.getComponents())
        {
            if(jc instanceof JLabel)
            {
                JLabel label = (JLabel)jc;
                String text = "";
                switch (n) {
                    case 0:
                        text = "Speed : Level " + controller.getLevel(0, 0);
                        i = 0;
                        break;

                    case 2:
                        text = "Efficiency : Level " + controller.getLevel(0, 1);
                        i = 1;
                        break;
                
                    default:
                        text = "cost : "+controller.getPrice(0, i);
                        break;
                }
                label.setText(text);
                n++;
            }
        }
    }
}
