import java.util.Scanner; // imports
import java.util.Queue;
import java.util.LinkedList;

class Main {

  static Queue<String> critical = new LinkedList<String>(); // three queues used to sort the patients by condition
  static Queue<String> serious = new LinkedList<String>();
  static Queue<String> fair = new LinkedList<String>();
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); // scan input
    char inputMM = 'a'; // initializing variables
    String checker = ""; 
    
    while (!(inputMM == '4'))//quits
    {
      System.out.println("\nMain Menu: \n1. Schedule a patient\n2. Treat the next patient\n3. Treat all patients\n4. Exit\nEnter a number[1-4]: "); // main menu print
      checker = scan.nextLine(); // user input
      inputMM = checker.charAt(0);// first char of input 
      if ((checker.length()>1)||!((inputMM >=49) && (inputMM <=52)))
      { //this section gets rid of crashes due to misinput, allows only 1 char and 1, 2, 3, or 4 as inputs
        System.out.println("Input Error, Please Try Again\n");
      }
      else
      {
        if (inputMM == '1') // inputMM is each main menu input, cases for each input
        {
          System.out.println("Enter Name:"); // getting patients and condition
          String name = scan.nextLine();
          System.out.println("Condition?\n1:Critical\n2:Serious\n3.Fair");
          checker = scan.nextLine();//input
          char inputSCH = checker.charAt(0); // first char of input
          
          while(((checker.length()>1))||!((inputSCH >=49) && (inputSCH<=51))) //this section gets rid of crashes due to misinput
          {
            
            if ((checker.length()>1)||!((inputSCH >=49) && (inputSCH<=51)))
            {
              System.out.println("Input Error, Please Try Again\n");
              System.out.println("Condition?\n1:Critical\n2:Serious\n3.Fair"); 
            }
              checker = scan.nextLine();
              inputSCH = checker.charAt(0);
          }
          if (inputSCH == '1') //adds to critical
          {
            critical.add(name);
            System.out.println(name + " added to Critical\n");
          }
          if (inputSCH == '2')//adds to serious
          {
            serious.add(name);
            System.out.println(name + " added to Serious\n");
          }
          if (inputSCH == '3')//adds to fair
          {
            fair.add(name);
            System.out.println(name + " added to Fair\n");
          }   
        }

        if (inputMM == '2') //treats next
        {
          System.out.println(treatNext());
        }

        if (inputMM == '3') //runs method till empty
        {
          while (!((critical.isEmpty()) && (serious.isEmpty()) &&(fair.isEmpty()))) {
            System.out.print(treatNext()); // uses method to treat all patients
          }
          System.out.println("All patients have been treated.\n\n");
        }
        
      }
      
    }
    System.out.println("Program Ended"); //runs when quit

    scan.close();
  }

  public static String treatNext() { // method to treat patients in order of worst condition first
    if (!critical.isEmpty())  { // checks critical first
      return critical.remove() + " / critical is being treated currently.\n"; 
    }
    else if (!serious.isEmpty()) { // checks serious next
      return serious.remove() + " / serious is being treated currently.\n";
    }  
    else if (!fair.isEmpty()) { // checks fair last
      return fair.remove() + " / fair is being treated currently.\n";
    }
    else // returns at the end
      return "All patients have been treated.\n\n";
  }

}

