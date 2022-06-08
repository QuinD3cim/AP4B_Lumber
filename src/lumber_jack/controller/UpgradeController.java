package lumber_jack.controller;

import lumber_jack.model.Lumberjack;

public class UpgradeController {

    private int levelMax = 40;
    private int[] lumberjackLevels;
    private int[] lumberjackPrices;
    private Lumberjack lumberjackController;

    public UpgradeController() 
    {
        lumberjackLevels = new int[2];
        lumberjackPrices = new int[2];
        lumberjackLevels[0] = 0;
        lumberjackLevels[1] = 0;
        lumberjackPrices[0] = 100;
        lumberjackPrices[1] = 100;
        lumberjackController = new Lumberjack();
    }

    // Upgrade the speed of a employee or machine, the int corresponds to the target machine
    // 0 : lumberjack, 
    public void upgradeSpeed(int target) 
    {
        switch (target) {
            case 0:
                if (lumberjackLevels[0] < levelMax)
                {
                    lumberjackLevels[0]++;
                    lumberjackPrices[0] *= 1.1f;
                    lumberjackController.levelUpSpeed(lumberjackLevels[0]);
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
