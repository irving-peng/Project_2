import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataDeliveryReader implements ReadDeliveryData {
  public static List<Delivery> getDeliveryObjects(Path filePath) throws IOException, ParseException{
    BufferedReader csvParse = Files.newBufferedReader(filePath);
    String[] deliveryGrid;
    List<Delivery> End = new ArrayList<Delivery>();
    String currentLine = csvParse.readLine();
    String[] keyGrid = currentLine.split(",");

    HashMap<String,String> currentHash = new HashMap<String,String>();
    while ((currentLine= csvParse.readLine())!=null) {
      deliveryGrid = currentLine.split(",");
      for (int i=6; i<deliveryGrid.length; i++) {
        //System.out.print(keyGrid[i] + " " + deliveryGrid[i]+ " . ");
        currentHash.put(keyGrid[i], deliveryGrid[i]);
      }
      String[] inputGrid= {deliveryGrid[0], deliveryGrid[1], deliveryGrid[2], deliveryGrid[3], deliveryGrid[4], deliveryGrid[5]};
     End.add(new Delivery(inputGrid, currentHash));
     currentHash.clear();
    }
    return End;
    
    
  }
    }

