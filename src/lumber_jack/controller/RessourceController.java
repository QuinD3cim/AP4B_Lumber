package lumber_jack.controller;

import lumber_jack.model.Product;

import java.util.ArrayList;

public class RessourceController {
    
    ArrayList<Product> ressourceList;

    public RessourceController() 
    {
        ressourceList = new ArrayList<>(1);
    }

    // Returns the position of a ressource in the list
    // - String name : name of the ressource
    private int findProduct(String name)
    {
        for (int i = 0; i<this.getRessourceSize(); i++)
        {
            if(this.getRessource(i).getType().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    // Change the quantity of the ressource
    // - String name : name of the ressource
    // - int quantity : quantity to add to the stock (can be negative)
    public void changeRessource(String name, int quantity)
    {
        int n = 0;
        if ((n=findProduct(name)) != -1)
        {
            this.getRessource(n).changeStock(quantity);
        }
    }

    // Creates a ressource and adds it to the ressource list
    // - String name : name of the ressource
    // - float sellingPrice : selling price of the ressource
    public void makeRessource(String name, float sellingPrice)
    {
        ressourceList.add(new Product(name,sellingPrice));
    }

    // Returns the asked ressource 
    // - int n : index of the ressource
    public Product getRessource(int n)
    {
        return ressourceList.get(n);
    }

    // Returns the asked ressoutce
    // - String name : name of the ressource
    public Product getRessource(String name)
    {
        return ressourceList.get(this.findProduct(name));
    }

    // Returns the size of the ressource list
    public int getRessourceSize()
    {
        return ressourceList.size();
    }

}
