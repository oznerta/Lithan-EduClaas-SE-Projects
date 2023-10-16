import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // create an arrayList to store athletes
        ArrayList<Athlete> athleteList = new ArrayList<>();

        //initialize the enrolled athletes and pass and store the arraylist as an arguments
        Athlete.enrolledAthletes(athleteList);

        // created or instantiate an object of my Athlete.java class so i can access the
        // method registerAthlete (scroll down and look for athelete.registerAthlete)
        // also used the default constructor which is empty (i have two constructor, one
        // is empty and the other one will be used to for arraylists on registerAthlete
        // method on my Athele.java class)
        Athlete athlete = new Athlete();

        boolean repeat = true;
        while (repeat) {
            clearscreen.cls(); // this is just a method to clear the screen and display the ASCII art of JUDO NORTH SUSSEX
            TrainingPlan.printTrainingPlan(); // call my method from TrainingPlan.java class to display the training plan variations and it's fees
            TrainingPlan.printWeightCategory(); // call my method from TrainingPlan.java class to display weight categories and it's upper limit
            // print a menu with options
            System.out.println(
                    "==========================================================================================================================================");
            System.out.println("\t\t\t\t\t                   Menu   ");
            System.out.println(
                    "==========================================================================================================================================");
            System.out.println("\t\t\t\t\t           1. Register a new athlete            ");
            System.out.println("\t\t\t\t\t           2. View all athletes                 ");
            System.out.println("\t\t\t\t\t           3. Calculate monthly cost                 ");
            System.out.println("\t\t\t\t\t           4. Exit                              ");
            System.out.println(
                    "==========================================================================================================================================");
            System.out.println(
                    "Note: Athlete are only eligible to enter competitions if they have an Intermediate or Elite training plan.");
            System.out.print("\nPlease choose an option: ");
            String choice = input.nextLine();
            choice = choice.toLowerCase();
            // check the user choice
            if (choice.equals("1") || choice.equals("register a new athlete") || choice.equals("register athlete")
                    || choice.equals("regester a new athlete") || choice.equals("regester athlete")
                    || choice.equals("registar a new athlete") || choice.equals("registar athlete")
                    || choice.equals("rigister a new athlete") || choice.equals("rigister athlete")) {
                athlete.registerAthlete(athleteList); // register a new athlete
            } else if (choice.equals("2") || choice.equals("view all athletes") || choice.equals("view athletepps")
                    || choice.equals("veiw all athletes") || choice.equals("view all athleets")
                    || choice.equals("veiw all athleets") || choice.equals("view all atletes")
                    || choice.equals("veiw all atletes")) {
                System.out.println("\nPress enter to continue...");
                input.nextLine();
                athlete.listAthletesByCategory(athleteList);// view all athletes by category
            } else if (choice.equals("3") || choice.equals("calculate monthly cost") || choice.equals("calculate cost")
                    || choice.equals("calculate") || choice.equals("cost") || choice.equals("cost  calculate")) {
                athlete.searchAndPrintAthlete(athleteList); // will look for the athlete name, calculate monthly fees
                                                            // and print them.
            } else if (choice.equals("4") || choice.equals("exit") || choice.equals("exitt") || choice.equals("quite")
                    || choice.equals("quit") || choice.equals("exiit") || choice.equals("exittt")
                    || choice.equals("quitt")) {
                System.out.println("\nPress enter to continue...");
                input.nextLine();
                clearscreen.cls();
                input.close();
                repeat = false;
            } else {
                System.out.println("Invalid option");
                System.out.println("\nPress enter to go back...");
                input.nextLine();

            }
        }
    }
}