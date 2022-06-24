package lumber_jack.controller;

import java.util.ArrayList;

import lumber_jack.model.ForestPlot;
import lumber_jack.model.Lumberjack;
import lumber_jack.model.Tree;
import lumber_jack.model.TreePlanter;

public class ForestTileThread extends Thread {

    protected int x;
    protected int y;
    protected float defaultTime = 5 * 60 * 1000; //15 minutes
    protected ForestPlot plot;

    public ForestTileThread(int x,int y, ForestPlot plot) {
        this.x = x;
        this.y = y;
        this.plot = plot;
    }

    @Override
    public void run() {
        while(true) {
            int timeToCut = calculateTimeToCut(plot.getLumberjacksOnPlot(), plot.getTreesOnPlot());
            if(timeToCut != -1) {
                plot.setCurrentAction("cut :");
                int percentForTreeCut = 100/plot.getTreesOnPlot().size();

                for(int i = 0; i < 100; ++i) {
                    try {
                        Thread.sleep(calculateTimeToCut(plot.getLumberjacksOnPlot(), plot.getTreesOnPlot()));
                    } catch(Exception e) {}

                    if(i % percentForTreeCut == 0 && i != 0) {
                        plot.cutTree();
                    }
                    plot.setCurrentPercentage(i);
                    plot.refreshButton();

                }
            }
            int timeToPlant = calculateTimeToPlant(plot.getTreeplanterOnPlot(),plot.getTreesOnPlot());
            if(timeToPlant != -1) {
                plot.setCurrentAction("plant :");
                int percentForTreePlant = 100/5;

                for(int i = 0; i < 100; ++i) {
                    try {
                        Thread.sleep(calculateTimeToPlant(plot.getTreeplanterOnPlot(),plot.getTreesOnPlot()));
                    } catch(Exception e) {}

                    if(i % percentForTreePlant == 0 && i != 0) {
                        plot.plantTree();
                    }
                    plot.setCurrentPercentage(i);
                    plot.refreshButton();

                }
            }
            

        }    
    }

    public int calculateTimeToCut(
        ArrayList<Lumberjack> lumberjacks,
        ArrayList<Tree> tree
    ) {
        if (lumberjacks.isEmpty() || tree.isEmpty()) return -1;
        float totalEfficiency = 1;
        float totalSpeed = 0;
        for (Lumberjack l : lumberjacks) {
            totalEfficiency *= (l.getEfficiency());
            totalSpeed += (l.getSpeed());
        }

        return Math.max(1, (int) ((defaultTime*((1/totalEfficiency))-totalSpeed*10)*tree.size())/100);
    }

    public int calculateTimeToPlant(
        ArrayList<TreePlanter> treeplanters,
        ArrayList<Tree> tree
    ) {
        if (treeplanters.isEmpty()) return -1;
        float totalEfficiency = 1;
        float totalSpeed = 0;
        for (TreePlanter t : treeplanters) {
            totalEfficiency *= (t.getEfficiency());
            totalSpeed += (t.getSpeed());
        }

        return Math.max(1, (int) ((defaultTime*((1/totalEfficiency))-totalSpeed*10)*tree.size())/100);
    }    
}
