import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
public class BackendDeveloperTests {

    public static void main(String[] args){


        (new BackendDeveloperTests()).runTests();
    
    }

    public void runTests(){
        System.out.println("Test Get Delivery By Name: " + testGetDeliveryByName());
        System.out.println("Test Get Delivery By Date: " + testGetDeliveryByDate());
        System.out.println("Test Both Constructors: " + testBothConstructors());

    }

    public boolean testGetDeliveryByName(){
        Backend backend;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
        Delivery d = null;
        d = backend.getDelivery("Delivery01");
        
        if(d.getItemName().equals("Delivery01") && d.getLocationToDeliver().equals("39360")){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean testGetDeliveryByDate(){
        Backend backend;
        Date date;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
            SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
            date = dateInit.parse("01/11/2021");
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
        Delivery d = null;
        d = backend.getDelivery(date);
        if(d.getItemName().equals("Delivery02") && d.getFeeDelivery()==5){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean testBothConstructors(){
        Backend backend1;
        Backend backend2;
        try{
            Path path = Paths.get("FinalData.csv");
            backend1 = new Backend(DataDeliveryReader.getDeliveryObjects(path));
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
        try{
            backend2 = new Backend("FinalData.csv");
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }

        if(backend1.size()==50 && backend2.size()==50){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean testRedundancies(){
        Backend backend;
        Date date;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
            SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
            date = dateInit.parse("01/11/2021");
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
        Delivery d = null;
        d = backend.getDelivery(date);
        if(d.getItemName().equals("Delivery02") && d.getFeeDelivery()==5){
            return true;
        }
        else{
            return false;
        }
    }
}   