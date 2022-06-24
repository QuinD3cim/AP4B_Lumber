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


    public Machine(RessourcePanel ressource){
        this.ressource = ressource;
        this.speed = 1f;
        this.level = 1;
        new MachineThread(this).start();
    }

    public void produce(){
        ressource.updateRessource("Wood", -1);
        ressource.updateRessource("Money", 7);
        ressource.updateRessource("Plank",2);
    }

    
    /** 
     * @return int
     */
    public int getPrice(){
        return upgradePrice;
    }

    
    /** 
     * @return float
     */
    public float getSpeed(){
        return this.speed;
    }

    
    /** 
     * @param speedToAdd
     */
    public void upgradeSpeed(float speedToAdd){

        this.speed += speedToAdd;
    }

    public void levelUp(){
        level++;
        upgradeSpeed(speed*(1+1/level));
        upgradePrice*=1.1f;
    }
}
