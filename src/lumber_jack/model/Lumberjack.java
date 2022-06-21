package lumber_jack.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lumberjack extends Employee {
    protected float speed;
    protected float efficiency;
    protected int posX;
    protected int posY;
    protected JFrame statsframe;
    protected DecimalFormat roundingMode;

    public Lumberjack() {
        roundingMode = new DecimalFormat("#.#");
        posX = 0;
        posY = 0;
        speed = 0.5f;
        efficiency = 0.5f;
    }

    public void upgradeSpeed(float addToSpeed) {
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
        statsframe = new JFrame();
        statsframe.setPreferredSize(new Dimension(400, 300));
        statsframe.getContentPane().setLayout(new BoxLayout(statsframe.getContentPane(), BoxLayout.Y_AXIS));
        statsframe.setLocationRelativeTo(null);

        //Modification of speed
        JPanel speedPanel = new JPanel();

        JButton speedMinusButton = new JButton("-");
        JButton speedPlusButton = new JButton("+");
        JLabel speedLabel = new JLabel(roundingMode.format(speed));
        JLabel speedTitleLabel = new JLabel("Speed : ");

        speedPanel.add(speedTitleLabel);
        speedPanel.add(speedMinusButton);
        speedPanel.add(speedLabel);
        speedPanel.add(speedPlusButton);

        statsframe.getContentPane().add(speedPanel);
        

        //Modification of efficiency
        JPanel efficiencyPanel = new JPanel();
        
        JButton efficiencyMinusButton = new JButton("-");
        JButton efficiencyPlusButton = new JButton("+");
        JLabel efficiencyLabel = new JLabel(roundingMode.format(efficiency));
        JLabel efficiencyTitleLabel = new JLabel("Efficiency : ");

        efficiencyPanel.add(efficiencyTitleLabel);
        efficiencyPanel.add(efficiencyMinusButton);
        efficiencyPanel.add(efficiencyLabel);
        efficiencyPanel.add(efficiencyPlusButton);

        statsframe.getContentPane().add(efficiencyPanel);

        statsframe.pack();
        statsframe.setVisible(true);

        speedMinusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speed-= 0.1;
                speedLabel.setText(roundingMode.format(speed));                
            }
            
        });

        speedPlusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speed+= 0.1;
                speedLabel.setText(roundingMode.format(speed));
            }
            
        });

        efficiencyMinusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                efficiency-= 0.1;
                efficiencyLabel.setText(roundingMode.format(efficiency));
            }
            
        });

        efficiencyPlusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                efficiency+= 0.1;
                efficiencyLabel.setText(roundingMode.format(efficiency));
            }
            
        });
        
    }
}
