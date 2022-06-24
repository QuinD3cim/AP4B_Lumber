package lumber_jack.model;

public class Lumberjack extends Employee {
    protected float speed;
    protected float efficiency;

    public Lumberjack()
    {
        this.salary = 1.5f;
        this.speed = 1.0f;
        this.efficiency = 0.3f;
    }

    public void levelUp(int level, int skill){
        if (skill == 0)
        {
            this.upgradeSpeed((float)1/level*.5f);
            this.increaseSalary((float)1/level*.25f);
        }
        else if (skill == 1)
        {
            this.upgradeEfficiency((float)1/level*.5f);
            this.increaseSalary((float)1/level*.25f);
        }
    }

    private void upgradeSpeed(float addToSpeed) {
        speed += addToSpeed;
    }

    public void upgradeEfficiency(float addToEfficiency) {
        efficiency += addToEfficiency;
    }
}
