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

public class Lumberjack extends Employee {
    protected float speed;
    protected float efficiency;
    protected int posX;
    protected int posY;
    protected JFrame statsframe;
    protected DecimalFormat roundingMode;
    protected int priceNextEfficiency;
    protected int priceNextSpeed;

    public Lumberjack() {
        roundingMode = new DecimalFormat("#.#");
        posX = 0;
        posY = 0;
        speed = 0.5f;
        efficiency = 1f;
        priceNextEfficiency = 10;
        priceNextSpeed = 10;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getSpeed() {
        return speed;
    }

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

    private void upgradeSpeed(float addToSpeed) {
        speed += addToSpeed;
    }

    public void upgradeEfficiency(float addToEfficiency) {
        efficiency += addToEfficiency;
    }

    public int getPositionX() {
        return posX;
    }
    
    public int getPositionY() {
        return posY;
    }
    
    public void setPositionX(int x) {
        posX = x;
    } 
    
    public void setPositionY(int y) {
        posY = y;
    }

    public void showStats() {
        statsframe = new JFrame("Lumberjack");
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
                if(isActionAuthorized(priceNextSpeed)) {
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
                if(isActionAuthorized(priceNextEfficiency)) {
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
