package lumber_jack.model;

import java.util.Random;

import lumber_jack.controller.RessourceController;

public class Tree {
    protected String treeType;
    protected float treeResistance;
    protected int logQuantity;
    protected int moneyGenerated;

    /**
     * Constructor of the tree
     * The money and and log generated are predetermined at start. Generation follow a gaussian probability center in 60.
     */
    public Tree() {
        Random rand = new Random();
        logQuantity = (int) ((rand.nextGaussian()) * 20 + 50); // Gaussian centered in 0.5
        moneyGenerated = logQuantity/2;
    }

    /**
     * Method to cut a tree
     */
    public void cut() {
        generateRessource();
    }

    /**
     * Method to generate a resource
     */
    public void generateRessource() {
        RessourceController.getRessourcePanel().updateRessource("Wood", logQuantity);
        RessourceController.getRessourcePanel().updateRessource("Money", moneyGenerated);
    }
}
