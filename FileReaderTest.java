import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileReaderTest {
  
  public static void main(String[] Args) {
    System.out.println("Test");
    System.out.println("Its been almost 20 seconds and I haven't crashed yet");
    System.out.println(testFileReader("/Users/noah/Desktop/eclipse-workspace/File_Reader_P2/TestSheetDeliveyworks.csv"));

    
  }
  public static boolean testDateParse() {
    SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
    try {
      System.out.println(dateInit.parse("15/10/2021"));
    } catch (ParseException e) {
      System.out.println("wrong format");
      e.printStackTrace();
      return false;
    }
    return true;
        
  }
  public static boolean testFileReader(String Path) {
    try {
      List<Delivery> testList = DataDeliveryReader.getDeliveryObjects(Paths.get(Path));
      /*System.out.println(testList.get(0).getItemName());
      System.out.println(testList.get(1).getFeeDelivery());
      System.out.println(testList.get(2).getDeliverOnDate());
      System.out.println(testList.get(3).SetExtraProperty("Key1", "example"));
      */
      System.out.println(testList.get(3).GetExtraProperty("Key1"));
      System.out.println("my code works?");
      
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("can't find file");
      return false;
    } catch (ParseException e) {
      System.out.println("something went wrong parsing");
      e.printStackTrace();
      return false;
    }
    
    return true;
  }
  public static boolean testListConstructor() {
    HashMap<String, String> testerHash = new HashMap<String, String>();
    testerHash.put("key1", "item1");
    testerHash.put("key2", "item2");
    String[] testlist = {"Name", "Destination", "200", "5", "01/01/2000","25/05/2021" };
    
    
    try {
      Delivery testD = new Delivery(testlist, testerHash);
      System.out.println(testD.getItemName());
      System.out.println(testD.getLocationToDeliver());
      System.out.println(testD.getFeeDelivery());
      System.out.println(testD.getDaysToDeliver());
      System.out.println(testD.getOrderDate());
      System.out.println(testD.getDeliverOnDate());
      System.out.println(testD.GetExtraProperty("Key1"));
    } catch (ParseException e) {
      System.out.println("wrong Format");
      e.printStackTrace();
      return false;
    }

    return true;
  }
}
