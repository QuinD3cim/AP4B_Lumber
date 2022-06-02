package lumber_jack.model;

public class Product {
    protected String type;
    protected float sellingPrice;
    protected Stock stock;

    public Product(String type, float sellingPrice)
        {
            this.type = type;
            this.sellingPrice = sellingPrice;
            this.stock = new Stock(type);
        }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSellingprice() {
        return sellingPrice;
    }

    public void setSellingprice(float price) {
        sellingPrice = price;
    }

    public Stock getStock() {
        return stock;
    }
    
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
