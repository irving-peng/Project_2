import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class Backend extends RedBlackTree<Delivery>{

    private RedBlackTree<Delivery> rbtree;
    Calendar c = Calendar.getInstance();
	
    //create red black tree from provided list of deliveries 
	public Backend(List<Delivery> list) {
		rbtree = new RedBlackTree<Delivery>();
        
        for(Delivery del : list){
            c.setTime(del.getOrderDate());
            c.add(Calendar.DATE, del.getDaysToDeliver());
            del.setDeliverOnDate(c.getTime());
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
    public Delivery getDelivery(String itemName) throws NoSuchElementException{
        Iterator<Delivery> rbIter = rbtree.iterator();
        Delivery del = rbIter.next();
        System.out.println(del.getItemName());
        while(true){
            if(del.getItemName().equals(itemName)){
                return del;
            }
            try{
                del = rbIter.next();
                System.out.println(del.getItemName());
            }
            catch(NoSuchElementException e){
                throw new NoSuchElementException("Delivery Item Not Found");
            }

        }
        
    }


    //get the delivery object based on the order date
    //we will assume there can only be one order per order date
    public Delivery getDelivery(Date orderDate){
        Delivery del = new Delivery("item", 10, 10, "53151", null, orderDate);
        return rbtree.get(del);
    }

    public boolean containsItem(String itemName){
        try{
            getDelivery(itemName);
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    
    public boolean containsDate(Date deliveryDate){
        try{
            getDelivery(deliveryDate);
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }



}
