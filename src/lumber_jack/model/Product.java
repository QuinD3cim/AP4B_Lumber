package lumber_jack.model;

public class Product {
    protected String type;
    protected float sellingPrice;
    protected Stock stock;

    /**
     * Create a product
     * @param type - name of the type of the product
     * @param sellingPrice - selling price of the product
     */
    public Product(String type, float sellingPrice)
        {
            this.type = type;
            this.sellingPrice = sellingPrice;
            this.stock = new Stock(type);
        }

    /**
      * @return the type of the product
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the product
     * @param type - the type we want the product to take
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the selling price of the product
     */
    public float getSellingprice() {
        return sellingPrice;
    }

    /**
     * Sets the selling price we want for the product
     * @param price - selling price we want to give to the product
     */
    public void setSellingprice(float price) {
        sellingPrice = price;
    }

    /**
     * @return the stock of the product
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Modify the stock of the product
     * @param quantity - the quantity we want to add or sub to the current stock
     */
    public void changeStock(int quantity)
    {
        if (quantity < 0)
        {
            this.getStock().subValue(quantity);
        }
        else
        {
            this.getStock().addValue(quantity);
        }
    }
}
