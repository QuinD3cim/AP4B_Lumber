package lumber_jack.model;

import lumber_jack.controller.RessourceController;

public abstract class Employee {
    protected float salary;

    protected void increaseSalary(float amount)
    {
        this.salary += amount;
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
