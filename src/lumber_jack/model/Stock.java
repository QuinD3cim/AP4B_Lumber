package lumber_jack.model;

public class Stock {
    protected String title;
    protected int currentValue;

    /**
     * Create a stock with the name of the product
     * @param title - name of the stock of the product
     */
    public Stock(String title)
    {
        this.title = title;
        currentValue = 0;
    }

    /**
     * @return current value of the stock
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the value of the stock we want
     * @param value - value of the stock we want
     */
    public void setCurrentValue(int value) {
        currentValue = value;
    }

    /**
     * Add value to our current stock
     * @param n - value we want to add to our current stock
     */
    public void addValue(int n) {
        currentValue+= n;
    }

    /**
     * Sub value to our current stack
     * @param n - value we want to sub to our current stock
     */
    public void subValue(int n) {
        try {
            if (currentValue >= n) {
                addValue(n);
            } else {
                throw new Exception("Not enough stock of"+title);
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
