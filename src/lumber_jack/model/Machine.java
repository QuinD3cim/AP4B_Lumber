package lumber_jack.model;

public class Machine {
    protected int speed;
    protected int level;
    protected int upgradePrice = 500;
    protected Product inProduct;
    protected Product outProduct;

    public int getPrice(){
        return upgradePrice;
    }
    
    public void upgradeSpeed(float speedToAdd){

        this.speed += speedToAdd;
    }

    public void levelUp(){
        level++;
        upgradeSpeed((float)1/level*.5f);
        upgradePrice*=1.1f;
    }
}
