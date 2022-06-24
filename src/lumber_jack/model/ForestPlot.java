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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import lumber_jack.controller.ForestTileThread;
import lumber_jack.controller.RessourceController;

public class ForestPlot {
    protected boolean isBought;
    protected float boughtPrice;
    protected String currentAction;
    protected int currentPercentage;

    protected int priceNextLumberjack;
    protected int priceNextTreePlanter;
    
    protected ArrayList<Lumberjack> lumberjacksOnPlot;
    protected ArrayList<TreePlanter> treeplanterOnPlot;
    protected ArrayList<Tree> treesOnPlot;

    protected JLabel plotButton;
    protected int x;
    protected int y;

    protected JFrame plotFrame;
    
    /**
     * Creation of a forest plot where we assign lumberjacks, tree planters and trees.
     * @param button - label which we can click to display the informations of the plot 
     * @param x - int x position in forest grid
     * @param y - int y position in forest grid
     */
    public ForestPlot(JLabel button, int x, int y) {
        Random randGenerator = new Random();
        int numberOfTree = randGenerator.nextInt(5) + 1;

        priceNextLumberjack = 100;
        priceNextTreePlanter = 100;

        this.x = x;
        this.y = y;
        currentAction = "cut";
        currentPercentage = 0;

        treesOnPlot = new ArrayList<Tree>();
        lumberjacksOnPlot = new ArrayList<Lumberjack>();
        treeplanterOnPlot = new ArrayList<TreePlanter>();

        plotButton = button;
        plotButton.addMouseListener(new GridMouseListener());
        for(int i = 0; i < numberOfTree;i++) {
            treesOnPlot.add(new Tree());
        }
        refreshButton();
        new ForestTileThread(x, y, this).start();
    }

    /**
     * synchronized function to get all lumberjacks on a plot
     * @return the list of all lumberjacks on plot
     */
    synchronized public ArrayList<Lumberjack> getLumberjacksOnPlot() {
        return lumberjacksOnPlot;
    }

    /**
     * synchronized function to get all tree planters on a plot
     * @return the list of all tree planters on plot
     */
    synchronized public ArrayList<TreePlanter> getTreeplanterOnPlot() {
        return treeplanterOnPlot;
    }

    /**
     * synchronized function to get all trees on a plot
     * @return the list of all trees on plot
     */
    synchronized public ArrayList<Tree> getTreesOnPlot() {
        return treesOnPlot;
    }

    /**
     * Setter for the current action (cut or plant)
     * @param action - a String defining the current action
     */
    synchronized public void setCurrentAction(String action) {
        currentAction = action;
    }

    /**
     * Setter for the current advacement percentage
     * @param currentPercentage - an int to set the percentage
     */
    synchronized public void setCurrentPercentage(int currentPercentage) {
        this.currentPercentage = currentPercentage;
    }

    /**
     * Add a new lumberjack on a plot
     * @param lumberjack - Lumberjack, the lumberjack to add
     */
    synchronized public void addLumberJackOnPlot(Lumberjack lumberjack) {
        lumberjacksOnPlot.add(lumberjack);
        refreshButton();
    }

    /**
     * Function to cut a tree
     */
    synchronized public void cutTree() {
        Tree cutTree = treesOnPlot.remove(0);
        cutTree.cut();

    }

    /**
     * Function to plant a tree
     */
    synchronized public void plantTree() {
        treesOnPlot.add(new Tree());
    }

    /**
     * Move a lumberjack into another plot
     * @param plot - the target ForestPlot
     */
    public void moveLumberJack(ForestPlot plot) {
        Lumberjack toMove = lumberjacksOnPlot.remove(lumberjacksOnPlot.size()-1);
        plot.lumberjacksOnPlot.add(toMove);
        plot.refreshButton();
        refreshButton();
    }

    /**
     * Add a tree planter on a forest plot
     * @param treePlanter - the TreePlanter to add
     */
    public void addTreePlanterOnPlot(TreePlanter treePlanter) {
        treeplanterOnPlot.add(treePlanter);
        refreshButton();
    }

    /**
     * Move a tree planter into another plot
     * @param plot - the target ForestPlot
     */
    public void moveTreePlanter(ForestPlot plot) {
        TreePlanter toMove = treeplanterOnPlot.remove(treeplanterOnPlot.size()-1);
        plot.treeplanterOnPlot.add(toMove);
        plot.refreshButton();
        refreshButton();
    }

    /**
     * Graphical function to refresh the button
     */
    synchronized public void refreshButton() {
        plotButton.setText(
            "<html><body>" +
            "lj : "+lumberjacksOnPlot.size() +
            "<br>tp : "+treeplanterOnPlot.size() +
            "<br>" + currentAction + " " + currentPercentage + " %" +
            "</body></html>"
            );
    }

    /**
     * Huge function to initialize the graphical plot and start popup
     */
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

    /**
     * Add a popup window with all the informations to upgrade lumberjacks and tree planters
     * @param container - a graphical Container containing all the informations 
     */
    public void addPopupContent(Container container) {
        container.add(new JLabel("Trees : "+treesOnPlot.size()));


        // Generate lumberjacks
        container.add(new JLabel("Lumberjacks :"));
        
        for(int i = 0; i < lumberjacksOnPlot.size(); ++i) {
            JPanel lumberjackPanel = new JPanel();
            lumberjackPanel.add(new JLabel("lumberjack "+i));
            JButton upgradeLumberjack = new JButton("upgrade");

            Lumberjack selectedLumberjack = lumberjacksOnPlot.get(i);

            upgradeLumberjack.addActionListener(new ActionListener(){

                Lumberjack linkedLumberjack = selectedLumberjack;
                @Override
                public void actionPerformed(ActionEvent e) {
                    linkedLumberjack.showStats();
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


        // Generate the controller of lumberjack (to add lumberjacks)
        JPanel addLumberJackPanel = new JPanel();
        JButton addLumberJack = new JButton("Add lumberjack");
        JLabel addLumberjackLabel = new JLabel(priceNextLumberjack+" €");

        addLumberJackPanel.add(addLumberJack);
        addLumberJackPanel.add(addLumberjackLabel);

        addLumberJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isActionAuthorized(priceNextLumberjack)) {
                    addLumberJackOnPlot(new Lumberjack());
                    priceNextLumberjack += priceNextLumberjack/4;
                    addLumberjackLabel.setText(priceNextLumberjack+" €");
                    refreshPopup(container);
                } else {
                    JOptionPane.showMessageDialog(container, "Vous n'avez pas assez d'argent !");
                }
            } 
        });

        container.add(addLumberJackPanel);


        // Generate treeplanters
        container.add(new JLabel("Treeplanters :"));

        for(int i = 0; i < treeplanterOnPlot.size(); ++i) {
            JPanel treePlanterPanel = new JPanel();
            treePlanterPanel.add(new JLabel("tree planter "+i));
            JButton upgradeTreePlanter = new JButton("upgrade");

            TreePlanter selectedTreePlanter = treeplanterOnPlot.get(i);

            upgradeTreePlanter.addActionListener(new ActionListener() {

                TreePlanter linkedTreePlanter = selectedTreePlanter;
                @Override
                public void actionPerformed(ActionEvent e) {
                    linkedTreePlanter.showStats();
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


        // Generate the controller of treeplanter (to add treeplanters)
        JPanel addTreePlanterPanel = new JPanel();
        JButton addTreePlanter = new JButton("Add tree planter");
        JLabel addTreePlanterLabel = new JLabel(priceNextTreePlanter+" €");

        addTreePlanterPanel.add(addTreePlanter);
        addTreePlanterPanel.add(addTreePlanterLabel);

        addTreePlanter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isActionAuthorized(priceNextTreePlanter)) {
                    addTreePlanterOnPlot(new TreePlanter());
                    priceNextTreePlanter += priceNextTreePlanter/4;
                    addTreePlanterLabel.setText(priceNextTreePlanter+" €");
                    refreshPopup(container);
                } else {
                    JOptionPane.showMessageDialog(container, "Vous n'avez pas assez d'argent !");
                }
                
            } 
        });
        container.add(addTreePlanterPanel);
    }

    /**
     * Refresh the popup window
     * @param container - a COntainer containing the content of the popup window
     */
    public void refreshPopup(Container container) {
        container.removeAll();
        addPopupContent(container);
        container.revalidate();
    }

    class GridMouseListener extends MouseInputAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (plotFrame == null) {
                createPlotFrame();
            }
            
        }
    }

    /**
     * Method to verify that the player can afford the buying
     * @param price - int with the price of the thing we want to buy
     * @return a boolean : true if the player can afford the thing and false else
     */
    protected boolean isActionAuthorized(int price) {
        int moneyAvailable = 0;
        Product moneyProduct = null;

        try {
            moneyProduct = RessourceController.getStaticResource("Money");
            moneyAvailable = moneyProduct.getStock().getCurrentValue();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }

        if(price > moneyAvailable) {
            return false;
        }
        RessourceController.getRessourcePanel().updateRessource("Money", -price);
        return true;
    }
    
}
