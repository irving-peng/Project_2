// --== CS400 File Header Information ==--
// Name: Srikar Vootkur
// Email: svootkur@wisc.edu
// Team: BF (Red)
// Role: Backend Developer
// TA: BRIANNA COCHRAN
// Lecturer: GARY DAHL
// Notes to Grader: <optional extra notes>

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
        System.out.println("Test Redundancies Handler: " + testAddDelivery());
        System.out.println("Test Backend's toString(): " + testToString());

    }

    //Checks the getDelivery(String itemName) method in the backend to ensure the front end can obtain any delivery object by its Item Name
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

    //Checks the getDelivery(Date orderDate) method in the backend to ensure the front end can obtain any delivery object by its Order Date
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

    //Tests both constructors of the backend class with different inputs and ensures they store the inputs correctly
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

    //checks the addDelivery(Delivery del) method of the backend class to ensure deliveries can be added to the red black tree and stored correctly
    public boolean testAddDelivery(){
        Backend backend;
        Date date;
        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));
            SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
            date = dateInit.parse("01/01/2021");
        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
        Delivery del = new Delivery("Delivery100", 10, 10, "53151", null, date);
        try{
            backend.addDelivery(del);
        }
        catch(IllegalArgumentException e){
            return false;
        }

        if(backend.getDelivery("Delivery100")==del){
            return true;
        }
        else{
            return false;
        }
    }

    //tests that the toString() method of the backend class displays the correct data: the delivery item name and its corresponding order date
    //This is vital for the frontend to display the information to the end user
    public boolean testToString(){
        Backend backend;

        try{
            Path path = Paths.get("FinalData.csv");
            backend = new Backend(DataDeliveryReader.getDeliveryObjects(path));

        }
        catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }

        if(backend.toString().contains("Delivery38, 03/01/2021" + "\n")){
            return true;
        }
        else{
            return false;
        }
        

    }
}   
