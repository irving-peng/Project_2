import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//This class acts as a simple info holder
//Everything but the item name can be modified with set(property)
// Everything can be retrieved by get(property)
public class Delivery implements Comparable<Delivery>{
    private String ItemName;
    private String LocationToDeliver;
    private int DaysToDeliver;
    private int FeeDelivery;
    private Date DeliverOnDate;
    private Date OrderDate;
    private java.util.HashMap<String, String> ExtraProperties;
    //one constructor for without a preset date,  not sure if that gets set by backed
    public Delivery(String itemName, int daysToDeliver, int feeDelivery, String locationToDeliver, HashMap<String, String> extraProperties, Date orderDate ) {
      ItemName = itemName;
      setDaysToDeliver(daysToDeliver);
      setFeeDelivery(feeDelivery);
      setLocationToDeliver(locationToDeliver);
      ExtraProperties = extraProperties;
      setOrderDate(orderDate);
    }
    //One with a preset date,
    public Delivery(String itemName, int daysToDeliver, int feeDelivery, String locationToDeliver, Date deliverOnDate, HashMap<String, String> extraProperties, Date orderDate) {
      ItemName = itemName;
      setDaysToDeliver(daysToDeliver);
      setFeeDelivery(feeDelivery);
      setLocationToDeliver(locationToDeliver);
      setDeliverOnDate(deliverOnDate);
      setOrderDate(orderDate);
    }
    //Name, LocationTodeliver, DeliveryFee,  DaysToDeliver, DeliverOnDate, OrderDate
    public Delivery(String[] rawConstructor, HashMap<String, String> Map) throws ParseException {
      ItemName = rawConstructor[0];
      LocationToDeliver = rawConstructor[1];
      FeeDelivery = Integer.parseInt(rawConstructor[2]);
      DaysToDeliver = Integer.parseInt(rawConstructor[3]);
      SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
      
      DeliverOnDate = dateInit.parse(rawConstructor[4]);
      ExtraProperties = (HashMap<String, String>) Map.clone();
      OrderDate = dateInit.parse(rawConstructor[5]);    
      }
    public String getItemName() {
      return ItemName;
    }
    //returns what the ExtraProperty used to be, null if it's a new entry
    public String SetExtraProperty(String key, String Property) {
        return ExtraProperties.put(key, Property);
    }
    //Returns removed key
    public String DelExtraProperty(String key) {
      return ExtraProperties.remove(key);
    }
    //Returns a set of Strings with keys
    public Set<String> ExtraPropertiesKeys() {
      return ExtraProperties.keySet();
      
    }
    public int ExtraPropertiesSize() {
      return ExtraProperties.size();
    }
    public String GetExtraProperty(String key) {
      return ExtraProperties.get(key);
      
    }

    public int getDaysToDeliver() {
      return DaysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver) {
      DaysToDeliver = daysToDeliver;
    }

    public int getFeeDelivery() {
      return FeeDelivery;
    }

    public void setFeeDelivery(int feeDelivery) {
      FeeDelivery = feeDelivery;
    }

    public String getLocationToDeliver() {
      return LocationToDeliver;
    }

    public void setLocationToDeliver(String locationToDeliver) {
      LocationToDeliver = locationToDeliver;
    }
    public Date getDeliverOnDate() {
      return DeliverOnDate;
    }
    public void setDeliverOnDate(Date deliveryDate) {
      DeliverOnDate = deliveryDate;
    }
    public Date getOrderDate() {
      return OrderDate;
    }
    public void setOrderDate(Date orderDate) {
      OrderDate = orderDate;
    }
    //Compares order dates
    @Override
    public int compareTo(Delivery OtherDelivery) {
      return OrderDate.compareTo(OtherDelivery.getOrderDate());
    }
}
