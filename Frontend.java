import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Frontend {
  public Frontend() {
    
  }
  
  public static void run(Backend be){
    //Scanner to get Input from User 
    Delivery selected = null;
    Scanner scnr = new Scanner(System.in); 
    boolean exit = false;
    String screen = "welcome";
    RedBlackTree deliveries = new RedBlackTree();
    
    while(exit == false) {
      while(screen.equalsIgnoreCase("welcome")) {
        System.out.println("Welcome to the Delivery Managing System!");
        System.out.println("In this app, you can see all of the deliveries in the system, "
            + "find your delivery, and see your delivery's information. \n"
            + "Enter 'exit' or (x) at anytime to quit the application.");
        System.out.println("Press enter to continue");
        scnr.nextLine();
        screen = "start";
      }
      while(screen.equalsIgnoreCase("start")) {
        System.out.println("Would you like to search for your delivery by name(n) or by order date(d)? "
            + "You can also print the delivery tree with print(p).");
        String searchBy = scnr.next();
        if(searchBy.equalsIgnoreCase("name") || searchBy.contentEquals("n")) {
          screen = "nameSearch";
        }
        else if(searchBy.equalsIgnoreCase("date")|| searchBy.contentEquals("d")) {
          screen = "dateSearch";
        }
        else if(searchBy.equalsIgnoreCase("print")|| searchBy.contentEquals("p")) {
          screen = "printScreen";
        }
        else if(searchBy.equalsIgnoreCase("exit")|| searchBy.contentEquals("x")) {
          System.out.println("Thank you for using the Delivery Managing System, have a good day!");
          exit = true;
          break;
        }
        else {
          System.out.print("Please enter a valid search method.\n");
        }
        
      }
      while(screen.equalsIgnoreCase("nameSearch")) {
        System.out.println("You selected to search by name! Enter the delivery name to select your delivery. "
            + "Enter (b) to go back.");
        String input = scnr.next();
        if(input.equalsIgnoreCase("b")) {
          screen = "start";
          break;
        } else if(be.containsItem(input)) {
            selected = be.getDelivery(input);
          }
        else if(input.equalsIgnoreCase("exit")|| input.contentEquals("x")) {
          System.out.println("Thank you for using the Delivery Managing System, have a good day!");
          exit = true;
          break;
        }else {
            System.out.println("Please enter a valid command or item name");
            continue;
        }
        while(true) {
          System.out.println("What information would you like about this delivery: \n"
              + "Delivery location (l)\n"
              + "Delivery fee (f)\n"
              + "Days to deliver (dd)\n"
              + "Delivery on date (d)\n"
              + "Order date (o)\n"
              + "Enter (b) to go back to search by name");
          String info = scnr.next();
          if(info.equalsIgnoreCase("l")) {
            System.out.println(selected.getLocationToDeliver());
          }
          else if(info.equalsIgnoreCase("f")) {
            System.out.println(selected.getFeeDelivery());
          }
          else if(info.equalsIgnoreCase("dd")) {
            System.out.println(selected.getDaysToDeliver());
          }
          else if(info.equalsIgnoreCase("d")) {
            System.out.println(selected.getDeliverOnDate());
          }
          else if(info.equalsIgnoreCase("o")) {
            System.out.println(selected.getOrderDate());
          }
          else if(info.equalsIgnoreCase("b")) {
            break;
          }
          else if(input.equalsIgnoreCase("exit")|| input.contentEquals("x")) {
            System.out.println("Thank you for using the Delivery Managing System, have a good day!");
            exit = true;
            break;
          }
          else {
            System.out.println("Please enter a valid command.");
            continue;
          }
          System.out.println("Would you like to get more information about this delivery? (y/n)");
          String more = scnr.next();
          if(more.equalsIgnoreCase("y")) {
            
          }
          else if(more.equalsIgnoreCase("exit")|| more.contentEquals("x")) {
            System.out.println("Thank you for using the Delivery Managing System, have a good day!");
            exit = true;
            break;
          }else {
            screen = "start";
            break;
          }
        }
        }
      while(screen.equalsIgnoreCase("dateSearch")) {
        System.out.println("You selected to search by date! Enter the order date to select your delivery. "
            + "Enter (b) to go back.\n"
            + "Enter the date in the format of 'dd/MM/yyyy', i.e '04/02/2021'");
        String input = scnr.next();
        //System.out.println(orderDate.toString());
        if(input.equalsIgnoreCase("b")) {
          screen = "start";
          break;
        } else if(input.equalsIgnoreCase("exit")|| input.contentEquals("x")) {
          System.out.println("Thank you for using the Delivery Managing System, have a good day!");
          exit = true;
          break;
        }else {
          Date orderDate = null;
          SimpleDateFormat dateInit = new SimpleDateFormat("dd/MM/yyyy");
          try {
            orderDate = dateInit.parse(input);
          } catch (Exception e) {
            System.out.println("Error parsing string to Date");
          }
          if(be.containsDate(orderDate)) {
            selected = be.getDelivery(orderDate);
          } else {
            System.out.println("Please enter a valid date or command.");
            continue;
          }
        }
        while(true) {
          System.out.println("What information would you like about this delivery: \n"
              + "Item name (i)"
              + "Delivery location (l)\n"
              + "Delivery fee (f)\n"
              + "Days to deliver (dd)\n"
              + "Delivery on date (d)\n"
              + "Enter (b) to go back to search by name");
          String info = scnr.next();
          if(info.equalsIgnoreCase("l")) {
            System.out.println(selected.getLocationToDeliver());
          }
          else if(info.equalsIgnoreCase("f")) {
            System.out.println(selected.getFeeDelivery());
          }
          else if(info.equalsIgnoreCase("dd")) {
            System.out.println(selected.getDaysToDeliver());
          }
          else if(info.equalsIgnoreCase("d")) {
            System.out.println(selected.getDeliverOnDate());
          }
          else if(info.equalsIgnoreCase("i")) {
            System.out.println(selected.getItemName());
          }
          else if(info.equalsIgnoreCase("b")) {
            break;
          }
          else if(info.equalsIgnoreCase("exit")|| info.contentEquals("x")) {
            System.out.println("Thank you for using the Delivery Managing System, have a good day!");
            exit = true;
            break;
          }
          else {
            System.out.println("Please enter a valid command.");
            continue;
          }
          System.out.println("Would you like to get more information about this delivery? (y/n)");
          String more = scnr.next();
          if(more.equalsIgnoreCase("y")) {
            
          }
          else if(more.equalsIgnoreCase("exit")|| more.contentEquals("x")) {
            System.out.println("Thank you for using the Delivery Managing System, have a good day!");
            exit = true;
            break;
          }else {
            screen = "start";
            break;
          }
        }
      }
        
      while(screen.equalsIgnoreCase("printScreen")) {
        System.out.println(be.toString());
        scnr.nextLine();
        screen = "start";
      }
    }
    }



  public static void main(String[] args) {
      Backend be = null;
        try {
          be = new Backend("deliveriesFinal.csv");
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Error instantiating backend");
        }
      run(be);
  }
}
