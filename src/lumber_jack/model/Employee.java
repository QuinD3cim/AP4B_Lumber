package lumber_jack.model;

public abstract class Employee {
    protected float salary;

    protected void increaseSalary(float amount)
    {
        this.salary += amount;
    }
}
