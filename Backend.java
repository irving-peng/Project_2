// --== CS400 File Header Information ==--
// Name: Srikar Vootkur
// Email: svootkur@wisc.edu
// Team: BF (Red)
// Role: Backend Developer
// TA: BRIANNA COCHRAN
// Lecturer: GARY DAHL
// Notes to Grader: <optional extra notes>

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Backend(String filepath) throws IOException, ParseException{
        Path path = Paths.get(filepath);
        List<Delivery> list = DataDeliveryReader.getDeliveryObjects(path);
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
        while(true){
            if(del.getItemName().equals(itemName)){
                return del;
            }
            try{
                del = rbIter.next();
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
        try{
            return rbtree.get(del);
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("Delivery Item Not Found");
        }
    }

    @Override
    public int size(){
        return rbtree.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
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

    public String dateToString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String result = df.format(date);
        return result;
    }
    @Override
    public String toString() {
        // use the inorder Iterator that we get by calling the iterator method above
        // to generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        Iterator<Delivery> treeNodeIterator = rbtree.iterator();
        StringBuffer sb = new StringBuffer();
        Delivery data = null;
        if (treeNodeIterator.hasNext())
            data = treeNodeIterator.next();
            sb.append(data.getItemName());
            sb.append(", ");
            sb.append(dateToString(data.getOrderDate()));
            sb.append("\n");
        while (treeNodeIterator.hasNext()) {
            data = treeNodeIterator.next();
            sb.append(data.getItemName());
            sb.append(", ");
            sb.append(dateToString(data.getOrderDate()));
            sb.append("\n");
        }
        return sb.toString();
    }



}
