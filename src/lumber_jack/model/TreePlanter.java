package lumber_jack.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TreePlanter extends Employee{
    protected float speed;
    protected float efficiency;
    protected int posX;
    protected int posY;
    protected JFrame statsframe;
    protected DecimalFormat roundingMode;
    protected int priceNextEfficiency;
    protected int priceNextSpeed;


    /**
     * Constructor that will initialize the TreePlanter
     */

    public TreePlanter() {
        roundingMode = new DecimalFormat("#.#");
        posX = 0;
        posY = 0;
        speed = 0.5f;
        efficiency =1f;
        priceNextEfficiency = 10;
        priceNextSpeed = 10;
    }


    /**
     * getter of the efficiency
     * @return a float, the efficiency
     */

    public float getEfficiency() {
        return efficiency;
    }


    /**
     * getter of the speed
     * @return a float, the speed
     */
    public float getSpeed() {
        return speed;
    }


    /**
     * Method to level up a tree planter
     * @param level - int with the level of the player
     * @param skill - int with the skill of the player
     */
    public void levelUp(int level, int skill){
        if (skill == 0)
        {
            this.upgradeSpeed((float)1/level*.5f);
            this.increaseSalary((float)1/level*.25f);
        }
        else if (skill == 1)
        {
            this.upgradeEfficiency((float)1/level*.5f);
            this.increaseSalary((float)1/level*.25f);
        }
    }


    /**
     * Method to upgrade the speed a tree planter
     * @param addToSpeed - float representing the speed to add to current speed
     */
    public void upgradeSpeed(float addToSpeed) {
        speed += addToSpeed;
    }

    /**
     * Method to upgrade efficiency a tree planter
     * @param addToEfficiency - float representing the efficiency to add to current speed
     */
    public void upgradeEfficiency(float addToEfficiency) {
        efficiency += addToEfficiency;
    }


    /**
     * getter for the x coordinate
     * @return an int, the x position
     */

    public int getPositionX() {
        return posX;
    }


    /**
     * getter for the y coordinate
     * @return an int, the y position
     */

    public int getPositionY() {
        return posY;
    }

  
    /**
     * setter for the x coordinate
     * @param x - int, the new x position
     */

    public void setPositionX(int x) {
        posX = x;
    } 


    /**
     * setter for the y coordinate
     * @param y - int, the new y position
     */

    public void setPositionY(int y) {
        posY = y;
    }


    /**
     * Method to show the statistics of tree planter 
     */

    public void showStats() {
        statsframe = new JFrame("TreePlanter");
        statsframe.setPreferredSize(new Dimension(400, 300));
        statsframe.getContentPane().setLayout(new BoxLayout(statsframe.getContentPane(), BoxLayout.Y_AXIS));
        statsframe.setLocationRelativeTo(null);

        //Modification of speed
        JPanel speedPanel = new JPanel();

        JButton speedPlusButton = new JButton(priceNextSpeed+" €");
        JLabel speedLabel = new JLabel(roundingMode.format(speed));
        JLabel speedTitleLabel = new JLabel("Speed : ");

        speedPanel.add(speedTitleLabel);
        speedPanel.add(speedLabel);
        speedPanel.add(speedPlusButton);

        statsframe.getContentPane().add(speedPanel);
        

        //Modification of efficiency
        JPanel efficiencyPanel = new JPanel();
        
        JButton efficiencyPlusButton = new JButton(priceNextEfficiency+" €");
        JLabel efficiencyLabel = new JLabel(roundingMode.format(efficiency));
        JLabel efficiencyTitleLabel = new JLabel("Efficiency : ");

        efficiencyPanel.add(efficiencyTitleLabel);
        efficiencyPanel.add(efficiencyLabel);
        efficiencyPanel.add(efficiencyPlusButton);

        statsframe.getContentPane().add(efficiencyPanel);

        statsframe.pack();
        statsframe.setVisible(true);

        speedPlusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isActionAuthorized(priceNextSpeed)) {
                    speed+= 0.1;
                    speedLabel.setText(roundingMode.format(speed));
                    priceNextSpeed += priceNextSpeed/4;
                    speedPlusButton.setText(priceNextSpeed +" €");
                } else {
                    JOptionPane.showMessageDialog(statsframe, "Vous n'avez pas assez d'argent !");
                }
            }
            
        });

        efficiencyPlusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isActionAuthorized(priceNextSpeed)) {
                    efficiency+= 0.1;
                    efficiencyLabel.setText(roundingMode.format(efficiency));
                    priceNextEfficiency += priceNextEfficiency/4;
                    efficiencyPlusButton.setText(priceNextEfficiency +" €");
                } else {
                    JOptionPane.showMessageDialog(statsframe, "Vous n'avez pas assez d'argent !");
                }
            }
            
        });
        
    }
}
