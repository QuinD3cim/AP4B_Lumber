package lumber_jack.model;

public class MarkettingManager extends Employee {
    protected int attractivity;
    protected int attractivityLimit;
    protected float qualification;

    public void empty() {

    }

    public void fire() {

    }

    public void upgradeAttractivity() {
        try {
            if(attractivity + 1 > attractivityLimit) {
                throw new Exception("Attractivity is at his mximum value!");
            } else {
                attractivity++;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
