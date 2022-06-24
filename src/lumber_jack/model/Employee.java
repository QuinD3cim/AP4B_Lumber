package lumber_jack.model;

import lumber_jack.controller.RessourceController;

public abstract class Employee {
    protected float salary;

    protected void increaseSalary(float amount)
    {
        this.salary += amount;
    }
    
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
        RessourceController.getRessourcePanel().updateRessource("Money", 5);
        return true;
    }
}
