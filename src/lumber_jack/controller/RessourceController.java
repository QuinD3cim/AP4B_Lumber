package lumber_jack.controller;

import lumber_jack.model.Product;
import lumber_jack.view.RessourcePanel;

import java.util.ArrayList;

public class RessourceController {
    
    static ArrayList<Product> ressourceList;
    static RessourcePanel resourcePanel;


    /**
     * Constructor to initialize the resource controller 
     * @param resourcePanel - RessourcePanel, the resource panel which it i linked with
     */

    public RessourceController(RessourcePanel resourcePanel) 
    {
        RessourceController.resourcePanel = resourcePanel;
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


    /**
     * Method to change a resource in a static way
     * @param name - String representing the name of the target resources
     * @param quantity - int representing the quantity to replace
     */

    static public void changeRessourceStatic(String name, int quantity)
    {
        try {
            getStaticResource(name).changeStock(quantity);
        } catch (Exception e) {
            e.printStackTrace();
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

    public static Product getStaticResource(String s) throws Exception {
        for(Product product : ressourceList) {
            if(s.equals(product.getType())){ 
                return product;
            }
        }
        throw new Exception("This resource do not exist");
    }

    // Returns the size of the ressource list
    public int getRessourceSize()
    {
        return ressourceList.size();
    }

    public static RessourcePanel getRessourcePanel() {
        return resourcePanel;
    }

}
