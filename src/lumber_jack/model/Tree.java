package lumber_jack.model;

import java.util.Random;

import lumber_jack.controller.RessourceController;

public class Tree {
    protected String treeType;
    protected float treeResistance;
    protected int logQuantity;
    protected int moneyGenerated;

    public void cut() {
        Random rand = new Random();
        logQuantity = (int) ((rand.nextGaussian()-0.5) * 20 + 50); // Gaussian centerd in 0.
        moneyGenerated = logQuantity/2;
        generateRessource();
    }

    public void generateRessource() {
        RessourceController.getRessourcePanel().updateRessource("Wood", logQuantity);
        RessourceController.getRessourcePanel().updateRessource("Money", moneyGenerated);
    }
}
