package lumber_jack.model;

public class Lumberjack extends Employee {
    protected float speed;
    protected float efficiency;

    public void upgradeSpeed(float addToSpeed) {
        speed += addToSpeed;
    }

    public void upgradeEfficiency(float addToEfficiency) {
        efficiency += addToEfficiency;
    }
}
