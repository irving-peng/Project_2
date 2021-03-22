import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Backend extends RedBlackTree<Delivery>{

    RedBlackTree<Delivery> rbtree;
	
    //create red black tree from provided list of deliveries 
	public Backend(ArrayList<Delivery> list) {
		rbtree = new RedBlackTree<Delivery>();
        for(Delivery del : list){
            rbtree.insert(del);
        }
	}

    //add a delivery to the catalog
    public void addDelivery(Delivery del){
        rbtree.insert(del);
    }
    
    public void addDeliveries(List<Delivery> dels){
        for(Delivery del : dels){
            rbtree.insert(del);
        }
    }

    //get the delivery object based on the item name
    public Delivery getDelivery(String itemName){
        Delivery del = new Delivery();
        return del;
    }

    //get the delivery object based on the order date
    //we will assume there can only be one order per order date
    public Delivery getDelivery(Date orderDate){
        Delivery del = new Delivery();
        return del;
    }

    public Delivery getDelivery(String itemName, Date orderDate){
        Delivery del = new Delivery();
        return del;
    }

    public boolean containsItem(String itemname){
        return false;
    }

    
    public boolean containsDate(Date deliveryDate){
        return false;
    }

}