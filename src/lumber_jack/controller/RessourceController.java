package lumber_jack.controller;

import java.util.ArrayList;

public class RessourceController {
    
    ArrayList<Product> ressourceList;

    public RessourceController() 
    {
        ressourceList = new ArrayList<>(1);
    }

    // Returns the position of a ressource in the list
    private int findProduct(String name)
    {
        for (int i = 0; i<this.getRessourceSize(); i++)
        {
            if(this.getRessource(i).name.equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    // Creates a ressource and adds it to the ressource list
    public void makeRessource(String name, float sellingPrice)
    {
        ressourceList.add(new Product(name,sellingPrice));
    }

    // Returns a ressource
    public Product getRessource(int n)
    {
        return ressourceList.get(n);
    }

    // Returns the size of the ressource list
    public int getRessourceSize()
    {
        return ressourceList.size();
    }

    public class Product{
        public String name;
        public float sellingPrice;
        public int quantity;

        public Product(String name, float sellingPrice)
        {
            this.name = name;
            this.sellingPrice = sellingPrice;
            this.quantity = 0;
        }
    }
}
