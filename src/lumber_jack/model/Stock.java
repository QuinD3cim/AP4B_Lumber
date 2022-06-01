package lumber_jack.model;

public class Stock {
    protected String title;
    protected int currentValue;

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int value) {
        currentValue = value;
    }

    public void addValue(int n) {
        currentValue+= n;
    }

    public void subValue(int n) {
        try {
            if (currentValue >= n) {
                addValue(-n);
            } else {
                throw new Exception("Not enough stock of"+title);
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
