package lumber_jack.model;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class ForestPlot {
    protected boolean isBought;
    protected float boughtPrice;
    
    protected ArrayList<Lumberjack> lumberjacksOnPlot;
    protected ArrayList<TreePlanter> treeplanterOnPlot;
    protected ArrayList<Tree> treesOnPlot;

    protected JLabel plotButton;
    protected int x;
    protected int y;

    protected JFrame plotFrame;
    
    public ForestPlot(JLabel button, int x, int y) {
        Random randGenerator = new Random();
        int numberOfTree = randGenerator.nextInt(5) + 1;

        this.x = x;
        this.y = y;

        treesOnPlot = new ArrayList<Tree>();
        lumberjacksOnPlot = new ArrayList<Lumberjack>();
        treeplanterOnPlot = new ArrayList<TreePlanter>();

        plotButton = button;
        plotButton.addMouseListener(new GridMouseListener(x,y));
        for(int i = 0; i < numberOfTree;i++) {
            treesOnPlot.add(new Tree());
        }
        refreshButton();
    }

    public void addLumberJackOnPlot(Lumberjack lumberjack) {
        lumberjacksOnPlot.add(lumberjack);
        refreshButton();
    }

    public void moveLumberJack(ForestPlot plot) {
        Lumberjack toMove = lumberjacksOnPlot.remove(lumberjacksOnPlot.size()-1);
        plot.lumberjacksOnPlot.add(toMove);
        plot.refreshButton();
        refreshButton();
    }

    public void addTreePlanterOnPlot(TreePlanter treePlanter) {
        treeplanterOnPlot.add(treePlanter);
        refreshButton();
    }

    public void moveTreePlanter(ForestPlot plot) {
        TreePlanter toMove = treeplanterOnPlot.remove(treeplanterOnPlot.size()-1);
        plot.treeplanterOnPlot.add(toMove);
        plot.refreshButton();
        refreshButton();
    }

    public void refreshButton() {
        plotButton.setText(
            "<html><body>" +
            "lj : "+lumberjacksOnPlot.size() +
            "<br>tp : "+treeplanterOnPlot.size() +
            "<br>cut : " + 0 + "%" +
            "</body></html>"
            );
    }

    public void buy() {

    }

    public void createPlotFrame() {
        plotFrame = new JFrame("Forest plot "+x+" "+y);
        plotFrame.setPreferredSize(new Dimension(400, 500));
        
        plotFrame.setLocationRelativeTo(null);
        plotFrame.setVisible(true);
        plotFrame.getContentPane().setLayout(new BoxLayout(plotFrame.getContentPane(), BoxLayout.Y_AXIS));
        
        addPopupContent(plotFrame.getContentPane());

        plotFrame.pack();



        plotFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                plotFrame = null;
            }

            @Override
            public void windowClosed(WindowEvent e) {
                
            }

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void addPopupContent(Container container) {
        container.add(new JLabel("Lumberjacks :"));

        for(int i = 0; i < lumberjacksOnPlot.size(); ++i) {
            JPanel lumberjackPanel = new JPanel();
            lumberjackPanel.add(new JLabel("lumberjack "+i));
            JButton upgradeLumberjack = new JButton("upgrade");
            upgradeLumberjack.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    lumberjacksOnPlot.get(0).showStats();
                }

            });
            lumberjackPanel.add(upgradeLumberjack);

            JButton upButton = new JButton("^");
            JButton downButton = new JButton("v");
            JButton rightButton = new JButton(">");
            JButton leftButton = new JButton("<");

            if(x == 0) leftButton.setEnabled(false);
            if(y == 0) upButton.setEnabled(false);
            if(x == 9) rightButton.setEnabled(false);
            if(y == 6) downButton.setEnabled(false);

            lumberjackPanel.add(leftButton);
            lumberjackPanel.add(upButton);
            lumberjackPanel.add(downButton);
            lumberjackPanel.add(rightButton);

            container.add(lumberjackPanel);
        }

        JButton addLumberJack = new JButton("Add lumberjack");

        addLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLumberJackOnPlot(new Lumberjack());
                refresPopup(container);
            } 
        });
        container.add(addLumberJack);

        container.add(new JLabel("Treeplanters :"));

        for(int i = 0; i < treeplanterOnPlot.size(); ++i) {
            JPanel treePlanterPanel = new JPanel();
            treePlanterPanel.add(new JLabel("tree planter "+i));
            JButton upgradeTreePlanter = new JButton("upgrade");
            upgradeTreePlanter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //treeplanterOnPlot[i].                    
                }    
            });

            treePlanterPanel.add(upgradeTreePlanter);

            JButton upButton = new JButton("^");
            JButton downButton = new JButton("v");
            JButton rightButton = new JButton(">");
            JButton leftButton = new JButton("<");

            if(x == 0) leftButton.setEnabled(false);
            if(y == 0) upButton.setEnabled(false);
            if(x == 9) rightButton.setEnabled(false);
            if(y == 6) downButton.setEnabled(false);

            treePlanterPanel.add(leftButton);
            treePlanterPanel.add(upButton);
            treePlanterPanel.add(downButton);
            treePlanterPanel.add(rightButton);

            container.add(treePlanterPanel);
        }

        JButton addTreePlanter = new JButton("Add tree planter");
        addTreePlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTreePlanterOnPlot(new TreePlanter());
                refresPopup(container);
            } 
        });
        container.add(addTreePlanter);
    }

    public void refresPopup(Container container) {
        container.removeAll();
        addPopupContent(container);
        container.revalidate();
    }

    class GridMouseListener extends MouseInputAdapter {
        private int xPos;
        private int yPos;

        public GridMouseListener(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse touched : "+xPos+ " "+yPos);
            if (plotFrame == null) {
                createPlotFrame();
            }
            
        }
    }

    
}
