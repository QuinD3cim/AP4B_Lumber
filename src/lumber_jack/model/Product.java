package lumber_jack.model;

public class Product {
    protected String type;
    protected float sellingPrice;
    protected Stock stock;

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
    
}
