// --== CS400 File Header Information ==--
// Name: Carter Lindstrom
// Email: cjlindstrom@wisc.edu
// Team: BF
// Role: Frontend Developer
// TA: BRIANNA COCHRAN
// Lecturer: GARY DAHL
// Notes to Grader: <optional extra notes>

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class JunitTestFrontend {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  public void setUp() {
      System.setOut(new PrintStream(outputStreamCaptor));
  }


  @Test
  void testWelcomePrompt() {
       Frontend.main(null);
      Assert.assertEquals("Welcome to the Delivery Managing System!"
          + "In this app, you can see all of the deliveries in the system, "
          + "find your delivery, and see your delivery's information. \n"
          + "Enter 'exit' or (x) at anytime to quit the application.\n"
          + "Press enter to continue\n"
          + "Would you like to search for your delivery by name(n) or by order date(d)? "
          + "You can also print the delivery tree with print(p).", outputStreamCaptor.toString().trim());
  }
}
