import java.util.ArrayList;
import java.util.Scanner;


// a custom class that represents an athlete
public class Athlete{

    // attributes for my class Athlete
    private String athleteName;
    private TrainingPlan trainingPlan;
    private double currentWeight;
    private String weightCategory;   
    private int noOfCompetitions;
    private int noOfHours;

    //getters and setters for my Athlete class attributes (these methods will be called if i wanna set or retrieve value for the attributes above)
    public String getAthleteName() {        
        return athleteName;     // this will return the value of athleteName attributes
    }

    public void setAthleteName(String athleteName) {     // the string inside this 
        this.athleteName = athleteName;                  // will be set the athleteName attributes above (this.athleteName - is the attributes) - athletenameName is from the (String athleteName)
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(String trainingPlan) {
        // use a switch statement to create an instance of the appropriate subclass
        trainingPlan = trainingPlan.toLowerCase();
        switch (trainingPlan) {
            case "beginner":
                this.trainingPlan = new Beginner();
                break;
            case "intermediate":
                this.trainingPlan = new Intermediate();
                break;
            case "elite":
                this.trainingPlan = new Elite();
                break;
            default:
                System.out.println("Invalid training plan");
                break;
        }
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public int getNoOfCompetitions() {
        return noOfCompetitions;
    }

    public void setNoOfCompetitions(int noOfCompetitions) {
        this.noOfCompetitions = noOfCompetitions;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }

    // a constructor to register new athletes using arraylists
    public Athlete(String athleteName, TrainingPlan trainingPlan, double currentWeight, String weightCategory,
            int noOfCompetitions, int noOfHours) {
        this.athleteName = athleteName;
        this.trainingPlan = trainingPlan;
        this.currentWeight = currentWeight;
        this.weightCategory = weightCategory;
        this.noOfCompetitions = noOfCompetitions;
        this.noOfHours = noOfHours;
    }

    // im also using this so i can access the setters and use it
    // a default constructor to call registerAthlete as it cannot be called on main.java without it being 'static' (idk but for some reason i can't set my registerAthlete method as static if i wanna call the setter and getter)
    public Athlete(){
        
    }

    // a method to verify if a name within the array list already exist
    public static boolean isNameExists(String name, ArrayList<Athlete> athleteList) {
        for (Athlete athlete : athleteList) {
            if (athlete.getAthleteName().equalsIgnoreCase(name)) {
                return true; // Name already exists
            }
        }
        return false; // Name does not exist
    }
    

    // a method to register new athletes
    public void registerAthlete(ArrayList<Athlete> athleteList){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Athlete Name: ");
            String enteredName = input.nextLine().trim(); // Trim to remove leading/trailing spaces

            if (enteredName.isEmpty()) {
                System.out.println("Error: Athlete name cannot be empty.");
            }else if(enteredName.matches(".*\\d.*")) {
                System.out.println("Error: Athlete name cannot contain numbers.");
            } else if(isNameExists(enteredName, athleteList)) {
                System.out.println("Error: Athlete name already exists in the database.");
            }else if(enteredName.length() < 3){
                System.out.println("Error: Athlete name should be atleast 3 characters long");
            }else if(enteredName.matches("[\\W_]+")){
                System.out.println("Error: Athlete name cannot contain special characters");
            }
            else {
                setAthleteName(enteredName);
                break;
            }
        }

        // this loop will keep repeating asking for training plan if inputs are invalid [Beginner, Intermediate, Elite]
        while (true) {
            System.out.print("Training Plan: ");
            String plan = input.nextLine();
            plan = plan.toLowerCase(); // this will make user input not case sensitive so they can enter input be it capitalize or not [BEGINNER/beginner/Beginner/beGinner.../../..]
            if (plan.equals("beginner") || plan.equals("intermediate") || plan.equals("elite")) {
                setTrainingPlan(plan);
                break;
            } else {
                System.out.println("Invalid training plan. You can only choose between Beginner, Intermediate, or Elite.");
            }
        }
    
        while (true) {
            System.out.print("Current Weight In Kilograms (kg): ");
            try {
                double currentWeight = Double.parseDouble(input.nextLine());
                setCurrentWeight(currentWeight);
                break; // Exit the loop if the input is a valid double
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for weight.");
            }
        }
        
    
        if(getTrainingPlan().getPlan().equals("Beginner")){
            System.out.println("Competition Eligible: Not Qualified");
            System.out.println("Competition Weight Category: [disabled]");
            setWeightCategory("Not Enrolled");
            System.out.println("Number Of Competitions Entered This Month: [disabled]");
            setNoOfCompetitions(0);
        }else{
            System.out.println("Competition Eligible: Qualified");

            // another loop that will keep repeating if input is not valid [yes/no]
            while (true) {
                System.out.print("Enter a competition? [YES/NO]: ");
                String choice = input.nextLine();
                if(choice.equalsIgnoreCase("YES")){
                    while(true){
                        System.out.print("Competition Weight Category: ");
                        String category = input.nextLine();
                        category = category.toLowerCase();
                        if(category.equals("heavyweight") || category.equals("light heavyweight") || category.equals("middleweight") || category.equals("light middleweight") || category.equals("lightweight") || category.equals("flyweight")){
                            if(category.equals("heavyweight") && getCurrentWeight() > 100){
                                setWeightCategory("Heavyweight");
                                break;
                            }else if(category.equals("light heavyweight") && getCurrentWeight() <= 100 && getCurrentWeight() > 90){
                                setWeightCategory("Light Heavyweight");
                                break;
                            }else if(category.equals("middleweight") && getCurrentWeight() <= 100 && getCurrentWeight() > 81){
                                setWeightCategory("Middleweight");
                                break;
                            }else if(category.equals("light middleweight") && getCurrentWeight() <= 81 && getCurrentWeight() > 73){
                                setWeightCategory("Light Middleweight");
                                break;
                            }else if(category.equals("lightweight") && getCurrentWeight() <= 73 && getCurrentWeight() > 66){
                                setWeightCategory("Lightweight");
                                break;
                            }else if(category.equals("flyweight") && getCurrentWeight() <= 66){
                                setWeightCategory("Flyweight");
                                break;
                            }else{
                                System.out.println("Your weight don't match with the weight category you want to participate.");
                            }
                        }else{
                            System.out.println("Invalid weight category. You can only choose between Heavyweight, Light Heavyweight, Middleweight, Light Middleweight, Lightweight, and Flyweight");
                        }
                    } 

                    while (true) {
                        System.out.print("Number Of Competitions Entered This Month: ");
                        try {
                            int numberOfCompetitions = Integer.parseInt(input.nextLine());
                            if(numberOfCompetitions > 2){
                                System.out.println("You can only enter 2 times a month");
                            }
                            else{
                                setNoOfCompetitions(numberOfCompetitions);
                                break; // Exit the loop if the input is a valid integer
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }

                    break; // this will break the loop if yes
                }else if(choice.equalsIgnoreCase("NO")){
                    setNoOfCompetitions(0);
                    break; // this will break the loop if no
                }else {
                    System.out.println("Invalid Input. Please enter either YES or NO."); // this one has no break and will keep on repeating if the input are not yes/no
                }
            }
        }

        /// a while loop that will keep repeating if athlete want to add a private coaching
        while(true){
            System.out.print("Add a private coach? [YES/NO]: ");
            String choice = input.nextLine();
            if(choice.equalsIgnoreCase("YES")){
                while (true) {
                    System.out.print("Enter number of hours of private coaching a week [1-5hrs]: ");
                    try {
                        String userInput = input.next();
                        int number = Integer.parseInt(userInput);
                        if (number >= 1 && number <= 5) {
                            // Valid input, set the number of hours and break the loop
                            setNoOfHours(number);
                            break;
                        } else {
                            System.out.println("Invalid input. Please choose between 1-5.");
                        }
                    } catch (NumberFormatException e) {
                        // Catch non-numeric input
                        System.out.println("Invalid input. Please enter a number between 1-5.");
                    }
                }
                break;
            }else if(choice.equalsIgnoreCase("NO")){
                setNoOfHours(0);
                break;
            }else{
                System.out.println("Invalid Input. Please enter either YES or NO.");
            }

        }
         // create an athlete object and retrieve all those data to this object (I'm using the constructor i made above)
         Athlete newAthlete = new Athlete(athleteName, trainingPlan, currentWeight, weightCategory, noOfCompetitions, noOfHours);

        // now will add athlete object on my arraylist
        athleteList.add(newAthlete);
        System.out.println("The athlete has been registered successfully.");
        System.out.println("\nPress enter to continue...");
        input.nextLine();
        
    }


   // method to store the already enrolled athletes this was made to be separated to avoid duplication with the loop if i put it inside the viewAllAthletes method
    public static void enrolledAthletes(ArrayList<Athlete> athleteList){
        Athlete alex = new Athlete();
        alex.setAthleteName("Alex");
        alex.setTrainingPlan("Intermediate");
        alex.setCurrentWeight(98.5);
        alex.setWeightCategory("Light Heavyweight");
        alex.setNoOfCompetitions(2);
        alex.setNoOfHours(5);
        athleteList.add(alex);

        Athlete bob = new Athlete();
        bob.setAthleteName("Bob");
        bob.setTrainingPlan("Elite");
        bob.setCurrentWeight(110.6);
        bob.setWeightCategory("Heavyweight");
        bob.setNoOfCompetitions(3);
        bob.setNoOfHours(0);
        athleteList.add(bob);

        Athlete charlie = new Athlete();
        charlie.setAthleteName("Charlie");
        charlie.setTrainingPlan("Elite");
        charlie.setCurrentWeight(96.4);
        charlie.setWeightCategory("Half Heavyweight");
        charlie.setNoOfCompetitions(1);
        charlie.setNoOfHours(0);
        athleteList.add(charlie);

        Athlete danny = new Athlete();
        danny.setAthleteName("Danny");
        danny.setTrainingPlan("Beginner");
        danny.setCurrentWeight(60.0);
        danny.setWeightCategory("Not Enrolled"); // Not Enrolled
        danny.setNoOfCompetitions(0);
        danny.setNoOfHours(0);
        athleteList.add(danny);

        Athlete edward = new Athlete();
        edward.setAthleteName("Eve");
        edward.setTrainingPlan("Elite");
        edward.setCurrentWeight(105.7);
        edward.setWeightCategory("Heavyweight");
        edward.setNoOfCompetitions(1);
        edward.setNoOfHours(0);
        athleteList.add(edward);

        Athlete frank = new Athlete();
        frank.setAthleteName("Frank");
        frank.setTrainingPlan("Elite");
        frank.setCurrentWeight(86.2);
        frank.setWeightCategory("Middleweight");
        frank.setNoOfCompetitions(1);
        frank.setNoOfHours(0);
        athleteList.add(frank);
    }
        
        
        
    // this method will be called on main.java and will list out all athletes
    public static void viewAllAthletes(ArrayList<Athlete> athleteList) {
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-30s%-30s%-20s%-20s%-20s%-20s", "Athlete name", "Training Plan", "Current Weight", "Weight Category", "Competitions", "Hours"));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    
        for (Athlete athlete : athleteList) {
            String formattedLine = String.format("%-30s%-30s%-20.2f%-20s%-20d%-20d",
            athlete.getAthleteName(),
            athlete.getTrainingPlan().getPlan(),
            athlete.getCurrentWeight(),
            athlete.getWeightCategory(),
            athlete.getNoOfCompetitions(),
            athlete.getNoOfHours());
            System.out.println(formattedLine);
        }
    
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
    }


    // method to print the calculation of the chosen athlete
    public void printAthleteCalculation(ArrayList<Athlete> athleteList) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\n------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-30s%-80s%-30s%n", "Attribute", "Value", "Cost/Fee"));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%-30s%-80s%-30s%n", "Athlete name", getAthleteName(), "");
        System.out.printf("%-30s%-80s%-30s%n", "Training Plan", getTrainingPlan().getPlan(), String.format("$%.2f per week", getTrainingPlan().getCost()));

        if (getNoOfCompetitions() > 0) {
            System.out.printf("%-30s%-80s%-30s%n", "Competition Category", getWeightCategory(), "$22.00 per competition");
            System.out.printf("%-30s%-80s%-30s%n", "Competitions this month", getNoOfCompetitions(), "");
        } else {
            System.out.printf("%-30s%-80s%-30s%n", "Competition Eligibility", "Not Qualified", "");
        }

        if (getNoOfHours() > 0) {
            System.out.printf("%-30s%-80s%-30s%n", "Hours of Coaching", getNoOfHours(), String.format("$%.2f per week", getNoOfHours() * 9.0));
        } else {
            System.out.printf("%-30s%-80s%-30s%n", "Private Coaching", "Not Enrolled", "");
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-110s%-20s%n", "Total monthly cost", String.format("$%.2f", calculateAllCost()));
        System.out.println("\nPress enter to continue...");
        input.nextLine();
        
        
        
        
    }

    // method to calculate athlete total cost
    public double calculateAllCost() {
        double trainingPlanCost = getTrainingPlan().getCost() * 4; // Monthly cost
        double privateCoachingCost = getNoOfHours() * 9 * 4; // Monthly cost for private coaching
        double competitionFee = getNoOfCompetitions() * 22; // Total competition entry fee
        
        return trainingPlanCost + privateCoachingCost + competitionFee;
    }

    // Method to search for an athlete by name and print their calculations
    public void searchAndPrintAthlete(ArrayList<Athlete> athleteList) {
        Scanner input = new Scanner(System.in);
        boolean exitRequested = false;
        while (!exitRequested) {
            viewAllAthletes(athleteList); 
            System.out.println("Note: type 'exit' to quit\n\n");
            System.out.print("Enter the athlete's name to calculate: ");
            String searchName = input.nextLine().trim();
    
            if (searchName.equalsIgnoreCase("exit")) {
                exitRequested = true; // Exit the loop
            } else {
                boolean found = false;
    
                for (Athlete athlete : athleteList) {
                    if (athlete.getAthleteName().equalsIgnoreCase(searchName)) {
                        athlete.printAthleteCalculation(athleteList);
                        found = true;
                        break; // Stop searching once found
                    }
                }
    
                if (!found) {
                    System.out.println("Athlete not found.");
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                }
            }
        }
    }

    // Method to list athletes by category
    public  void listAthletesByCategory(ArrayList<Athlete> athleteList) {
        clearscreen.cls();
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n==========================================================================================================================================");
        System.out.println("\t\t\t\t\t                   ATHLETE LIST   ");
        System.out.println("==========================================================================================================================================\n\n");
        System.out.println("Beginner Plan   ");
        listAthletesInCategory(athleteList, "beginner");

        System.out.println("\nIntermediate Plan");
        listAthletesInCategory(athleteList, "intermediate");

        System.out.println("\nElite Plan");
        listAthletesInCategory(athleteList, "elite");

        System.out.println("\nPress enter to continue...");
        input.nextLine();
    }

    // Helper method to list athletes in a specific category
    private  void listAthletesInCategory(ArrayList<Athlete> athleteList, String category) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-110s%-10s", "Athlete name", "Current Weight"));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        for (Athlete athlete : athleteList) {
            if (athlete.getTrainingPlan().getPlan().equalsIgnoreCase(category)) {
                String formattedLine = String.format("%-110s%-10.2f",
                        athlete.getAthleteName(),
                        athlete.getCurrentWeight());
                System.out.println(formattedLine);
            }
        }
    }
}































// These are my revisions




// OLD menu for printathletecalculation


// System.out.println("\n\n\n\n==========================================================================================================================================");
        // System.out.println("\t\t\t\t\t                   Menu   ");
        // System.out.println("==========================================================================================================================================");
        // System.out.println("\t\t\t\t\t           1. Register a new athlete            ");
        // System.out.println("\t\t\t\t\t           2. View all athletes                 ");
        // System.out.println("\t\t\t\t\t           3. Home menu                 ");
        // System.out.println("==========================================================================================================================================");
        
        // while(true){
        //    System.out.print("Please choose an option: ");
        //    String choice = input.nextLine();
        //    choice = choice.toUpperCase();
        //    if(choice.equals("1") || choice.equals("register a new athlete") || choice.equals("register athlete") || choice.equals("regester a new athlete") || choice.equals("regester athlete") || choice.equals("registar a new athlete") || choice.equals("registar athlete") || choice.equals("rigister a new athlete") || choice.equals("rigister athlete")) {
        //         registerAthlete(athleteList);
        //         break;
        //    }else if (choice.equals("2") || choice.equals("view all athletes") || choice.equals("view all athlets") || choice.equals("veiw all athletes") || choice.equals("view all athleets") || choice.equals("veiw all athleets") || choice.equals("view all atletes") || choice.equals("veiw all atletes")) {              
        //         System.out.println("Press enter to continue...");
        //         input.nextLine();
        //         viewAllAthletes(athleteList);
        //         break;     
        //    }else if(choice.equals("3") || choice.equals("home menu") || choice.equals("home") || choice.equals("menu") || choice.equals("back")){
        //         System.out.println("Press enter to continue...");
        //         input.nextLine();
        //         break;
        //    }
        // }







//OLD MENU FOR regiusterAthlete

// System.out.println("==========================================================================================================================================");
        // System.out.println("\t\t\t\t\t                   Menu   ");
        // System.out.println("==========================================================================================================================================");
        // System.out.println("\t\t\t\t\t           1. Register a new athlete            ");
        // System.out.println("\t\t\t\t\t           2. View all athletes                 ");
        // System.out.println("\t\t\t\t\t           3. Calculate monthly cost                 ");
        // System.out.println("\t\t\t\t\t           4. Home menu                 ");
        // System.out.println("==========================================================================================================================================");
        
        // while(true){
        //    System.out.print("Please choose an option: ");
        //    String choice = input.nextLine();
        //    choice = choice.toUpperCase();
        //    if(choice.equals("1") || choice.equals("register a new athlete") || choice.equals("register athlete") || choice.equals("regester a new athlete") || choice.equals("regester athlete") || choice.equals("registar a new athlete") || choice.equals("registar athlete") || choice.equals("rigister a new athlete") || choice.equals("rigister athlete")) {
        //         registerAthlete(athleteList);
        //         break;                 // register athletes
        //    }else if (choice.equals("2") || choice.equals("view all athletes") || choice.equals("view all athlets") || choice.equals("veiw all athletes") || choice.equals("view all athleets") || choice.equals("veiw all athleets") || choice.equals("view all atletes") || choice.equals("veiw all atletes")) {              
        //         System.out.println("Press enter to continue...");
        //         input.nextLine();
        //         Athlete.viewAllAthletes(athleteList);         // view all athletes    
        //         break;             
        //    }else if(choice.equals("3") || choice.equals("calculate monthly cost") || choice.equals("calculate cost") || choice.equals("calculate") || choice.equals("cost") || choice.equals("cost  calculate")){
        //         System.out.println("Press enter to continue...");
        //         input.nextLine();
        //         printAthleteData(athleteList);
        //         break;
        //    }else if(choice.equals("4") || choice.equals("home menu") || choice.equals("home") || choice.equals("menu") || choice.equals("back")){
        //         System.out.println("Press enter to continue...");
        //         input.nextLine();
        //         break;
        //    }
        // }



//old method to update weight category
 // // a method to update weight category. this method will validate if the weight category the user inputed is within the choices and if it is it will also check if it matches the athlete current weight.
    // public void updateWeightCategory() {

    //     Scanner scan = new Scanner(System.in);
    //     while(true){
    //         System.out.print("Competition Weight Category: ");
    //         String category = scan.nextLine();
    //         category = category.toLowerCase();
    //         if(category.equals("heavyweight") || category.equals("light heavyweight") || category.equals("middleweight") || category.equals("light middleweight") || category.equals("lightweight") || category.equals("flyweight")){
    //             setWeightCategory(category);
    //             if(getWeightCategory().equals("heavyweight") && getCurrentWeight() > 100){
    //                 setWeightCategory(category);
    //                 break;
    //             }else if(getWeightCategory().equals("light heavyweight") && getCurrentWeight() <= 100 && getCurrentWeight() > 90){
    //                 setWeightCategory(category);
    //                 break;
    //             }else if(getWeightCategory().equals("middleweight") && getCurrentWeight() <= 90 && getCurrentWeight() > 81){
    //                 setWeightCategory(category);
    //                 break;
    //             }else if(getWeightCategory().equals("light middleweight") && getCurrentWeight() <= 81 && getCurrentWeight() > 73){
    //                 setWeightCategory(category);
    //                 break;
    //             }else if(getWeightCategory().equals("lightweight") && getCurrentWeight() <= 73 && getCurrentWeight() > 66){
    //                 setWeightCategory(category);
    //                 break;
    //             }else if(getWeightCategory().equals("flyweight") && getCurrentWeight() <= 66){
    //                 setWeightCategory(category);
    //                 break;
    //             }else{
    //                 System.out.println("Your weight don't match with the weight category you want to participate.");
    //             }
    //         }else{
    //             System.out.println("Invalid weight category. You can only choose between Heavyweight, Light Heavyweight, Middleweight, Light Middleweight, Lightweight, and Flyweight");
    //         }
    //     }
    //     scan.close();
    // }



    //OLD METHODS
    // // method to calculate all costs
    // public double calculateTrainingFees(){
    //     double trainingPlanCost = 0.0;     // WEEKLY FEE ===> BEGINNER = $25.00 (2 sessions/week ) | INTERMEDIATE = $30.00 (3 seesions/week) | ELITE = $35.00 (5 sessions/week)
    //     double competitionFee = 22.0;      // per competition
    //     double privateCoachingFee = 20.0;  // per hour

    // // use a switch statement to assign different values to the training plan cost based on the training plan
    // switch (trainingPlan) {
    //     case "Beginner":
    //       trainingPlanCost = 25.0; // WEEKLY FEE ===> BEGINNER = $25.00 (2 sessions/week )
    //       break;
    //     case "Intermediate":
    //       trainingPlanCost = 30.0; // WEEKLY FEE ===> INTERMEDIATE = $30.00 (3 sessions/week )
    //       break;
    //     case "Advanced":
    //       trainingPlanCost = 35.0; // WEEKLY FEE ===> ELITE = $35.00 (5 sessions/week )
    //       break;
    //     default:
    //       System.out.println("Invalid training plan.");
    //       break;
    //   }

    //   // calculate total cost for the month;
    //   double totalCost = trainingPlanCost + (competitionFee * getNoOfCompetitions()) + (privateCoachingFee * getNoOfHours());
    //   return totalCost;
    // }

    // public static void registerAthlete(){
    //     Scanner scanner = new Scanner(System.in);
    //     ArrayList<Athlete> athleteList = new ArrayList<>();

    //     System.out.print("Enter Athlete Name: ");
    //     String athleteName = scanner.nextLine();
    //     System.out.println("Select Training Plan:");
    //     System.out.println("1. Beginner");
    //     System.out.println("2. Intermediate");
    //     System.out.println("3. Advanced");
    //     System.out.print("Enter Training Plan (1/2/3): ");
    //     int trainingPlanChoice = scanner.nextInt();
    //     TrainingPlan trainingPlan = TrainingPlan.values()[trainingPlanChoice - 1];
    //     System.out.print("Enter Current Weight (kg): ");
    //     double weight = scanner.nextDouble();
    //     scanner.nextLine(); // Consume the newline
    //     System.out.print("Enter Weight Category: ");
    //     String weightCategory = scanner.nextLine();
    //     System.out.print("Enter Number of Competitions Entered this Month: ");
    //     int noOfCompetitions = scanner.nextInt();
    //     System.out.print("Enter Number of Hours of Private Coaching: ");
    //     int noOfHours = scanner.nextInt();
    //     scanner.nextLine(); // Consume the newline

    //     Athlete newAthlete = new Athlete(athleteName, trainingPlan, weight, weightCategory, noOfCompetitions, noOfHours);
    //     athleteList.add(newAthlete);
    //     System.out.println("Athlete Registered Successfully!");
    // }

    // public static void viewAllAthletes(){
    //     ArrayList<Athlete> athletes = new ArrayList<Athlete>();
    //     athletes.add(new Athlete("Alice", "Basic", "Extra Lightweight", 55.0, 2, 0));
    //     athletes.add(new Athlete("Bob", "Intermediate", "Half Middleweight", 70.0, 3, 1));
    //     athletes.add(new Athlete("Charlie", "Advanced", "Half Heavyweight", 85.0, 4, 2));
    //     athletes.add(new Athlete("David", "Basic", "Lightweight", 60.0, 1, 0));
    //     athletes.add(new Athlete("Eve", "Intermediate", "Half Lightweight", 65.0, 2, 1));
    //     athletes.add(new Athlete("Frank", "Advanced", "Heavyweight", 90.0, 3, 2));
    // }