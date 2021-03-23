import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
public class BackendDeveloperTests {

    public static void main(String[] args) throws IOException, ParseException{


        (new BackendDeveloperTests()).runTests();
    
        
    }

    public void runTests(){
        System.out.println("Test Get Delivery By Name: " + testGetDeliveryByName());
        System.out.println("Test Get Delivery By Date: " + testGetDeliveryByDate());

    }

    public boolean testGetDeliveryByName(){
        Backend backend;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
        }
        catch(Exception e){
            return false;
        }
        Delivery d = null;
        d = backend.getDelivery("Delivery01");
        
        if(d.getItemName()=="Delivery01" && d.getLocationToDeliver()=="39360"){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean testGetDeliveryByDate(){
        Backend backend;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
        }
        catch(Exception e){
            return false;
        }
        Delivery d = null;
        Date date = new Date();
        date.setMonth(11);
        date.setDate(1);
        date.setYear(2021);

        d = backend.getDelivery(date);
        if(d.getItemName()=="Delivery02" && d.getFeeDelivery()==5){
            return true;
        }
        else{
            return false;
        }
    }
}