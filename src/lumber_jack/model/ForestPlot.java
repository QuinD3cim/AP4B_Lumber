package lumber_jack.model;

import java.util.ArrayList;
import java.util.Random;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
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
            addLumberJackOnPlot(new Lumberjack());
        }
    }
}
