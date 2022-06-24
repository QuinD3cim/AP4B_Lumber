package lumber_jack.model;

import lumber_jack.controller.MachineThread;
import lumber_jack.view.RessourcePanel;

public class Machine {
    protected float speed;
    protected int level;
    protected int upgradePrice = 500;
    protected Product inProduct;
    protected Product outProduct;
    private RessourcePanel ressource;


    /**
     * Constructor of the machine
     * @param ressource - RessourcePanel linkedith the machine
     */
    public Machine(RessourcePanel ressource){
        this.ressource = ressource;
        this.speed = 1f;
        this.level = 1;
        new MachineThread(this).start();
    }

    /**
     * Method to produce planks
     */
    public void produce(){
        ressource.updateRessource("Wood", -1);
        ressource.updateRessource("Money", 7);
        ressource.updateRessource("Plank",2);
    }

    
    /** 
     * Getter of the upgradePrice
     * @return int - upgradePrice
     */
    public int getPrice(){
        return upgradePrice;
    }

    
    /** 
     * Gette of the speed
     * @return float - speed
     */
    public float getSpeed(){
        return this.speed;
    }

    
    /** 
     * Speed modifier
     * @param speedToAdd - float speed to add to speed
     */
    public void upgradeSpeed(float speedToAdd){

        this.speed += speedToAdd;
    }

    /**
     * give a level
     */
    public void levelUp(){
        level++;
        upgradeSpeed(speed*(1+1/level));
        upgradePrice*=1.1f;
    }
}
