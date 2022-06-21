package lumber_jack.model;

public class TreePlanter extends Employee{
    protected float speed;
    protected float efficiency;
    protected int posX;
    protected int posY;

    public TreePlanter() {
        posX = 0;
        posY = 0;
        speed = 0.5f;
        efficiency =0.5f;
    }

    public void upgradeSpeed(float addToSpeed) {
        speed += addToSpeed;
    }

    public void upgradeEfficiency(float addToEfficiency) {
        efficiency += addToEfficiency;
    }

    public int getPositionX() {
        return posX;
    }

    public int getPositionY() {
        return posY;
    }

    public void setPositionX(int x) {
        posX = x;
    } 

    public void setPositionY(int y) {
        posY = y;
    }
}
