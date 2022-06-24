package lumber_jack.controller;

import lumber_jack.model.Lumberjack;
import lumber_jack.model.TreePlanter;

public class UpgradeController {

    private int levelMax = 40;
    private int[] lumberjackLevels;
    private int[] lumberjackPrices;
    private Lumberjack lumberjackController;
    private int[] treeplanterLevels;
    private int[] treeplanterPrices;
    private TreePlanter treeplanterController;

    public UpgradeController() 
    {
        lumberjackLevels = new int[2];
        lumberjackPrices = new int[2];
        lumberjackLevels[0] = 0;
        lumberjackLevels[1] = 0;
        lumberjackPrices[0] = 100;
        lumberjackPrices[1] = 100;
        lumberjackController = new Lumberjack();

        treeplanterLevels = new int[2];
        treeplanterPrices = new int[2];
        treeplanterLevels[0] = 0;
        treeplanterLevels[1] = 0;
        treeplanterPrices[0] = 100;
        treeplanterPrices[1] = 100;
        treeplanterController = new TreePlanter();
    }

    // Upgrade the speed of a employee or machine, the int corresponds to the target machine
    // 0 : lumberjack, 
    public void upgrade(int target, int skill) 
    {
        switch (target) {
            case 0:
                if (lumberjackLevels[skill] < levelMax)
                {
                    lumberjackLevels[skill]++;
                    lumberjackPrices[skill] *= 1.1f;
                    lumberjackController.levelUp(lumberjackLevels[skill],skill);
                }
                break;
        
            case 1:
                break;

            default:
                break;
        }
    }

    // Function that returns the level of a skill for an employee or machine
    // what :  0 : lumberjack,
    // skill :  0 : speed,
    // returns the level or -1 if error
    public int getLevel(int what, int skill)
    {
        if (what == 0)
        {
            return lumberjackLevels[skill];
        }
        
        return -1;
    }

    // Function that returns the price of a skill for an employee or machine
    // what :  0 : lumberjack,
    // skill :  0 : speed,
    // returns the price or -1 if error
    public int getPrice(int what, int skill)
    {
        if (what == 0)
        {
            return lumberjackPrices[skill];
        }
        
        return -1;
    }
}
