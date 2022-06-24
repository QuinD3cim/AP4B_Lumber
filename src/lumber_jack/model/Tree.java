package lumber_jack.model;

import java.util.Random;

import lumber_jack.controller.RessourceController;

public class Tree {
    protected String treeType;
    protected float treeResistance;
    protected int logQuantity;
    protected int moneyGenerated;

    public Tree() {
        Random rand = new Random();
        logQuantity = (int) ((rand.nextGaussian()) * 20 + 50); // Gaussian centered in 0.5
        moneyGenerated = logQuantity/2;
    }

    public void cut() {   
        generateRessource();
    }

    public void generateRessource() {
        RessourceController.getRessourcePanel().updateRessource("Wood", logQuantity);
        RessourceController.getRessourcePanel().updateRessource("Money", moneyGenerated);
    }
}
