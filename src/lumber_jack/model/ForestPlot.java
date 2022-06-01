package lumber_jack.model;

import java.util.ArrayList;
import java.util.Random;

public class ForestPlot {
    protected boolean isBought;
    protected float boughtPrice;
    
    protected ArrayList<Lumberjack> lumberjacksOnPlot;
    protected ArrayList<TreePlanter> treeplanterOnPlot;
    protected ArrayList<Tree> treesOnPlot;
    
    protected int x;
    protected int y;
    
    ForestPlot() {
        Random randGenerator = new Random();
        int numberOfTree = randGenerator.nextInt(5) + 1;
        treesOnPlot = new ArrayList<Tree>();
        for(int i = 0; i < numberOfTree;i++) {
            treesOnPlot.add(new Tree());
        }
    }

    public void buy() {

    }
}
