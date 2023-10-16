public abstract class TrainingPlan{

   // attributes for my abstract class TrainingPlan;
   String trainingPlan;

   // constructor of my abstract class TrainingPlan
   public TrainingPlan(String trainingPlan){
      this.trainingPlan = trainingPlan;
   }

   //getter of my TrainingPlan;
   public String getPlan() {
      return trainingPlan;
   }

   // this method returns the cost of the training plan based on the athlete chosen training plan
   public abstract double getCost();


   // a method to display training plan
   public static void printTrainingPlan(){

      System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("=================================================NORTH SUSSEX JUDO TRAINING CENTER========================================================");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

      System.out.println("\n\n\n\t\t\t\t\t\tTYPE OF TRAINING PLANS AND FEES");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-30s%-80s%-30s%n", "Plan", "Description", "Fee");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-30s%-80s%-30s%n", "Beginner", "(2 sessions per week)", "$25.00/weekly");
      System.out.printf("%-30s%-80s%-30s%n", "Intermediate", "(3 sessions per week)", "$30.00/weekly");
      System.out.printf("%-30s%-80s%-30s%n", "Elite", "(5 sessions per week)", "$35.00/weekly");
      System.out.printf("%-30s%-80s%-30s%n", "Private tuition", "(Athletes can receive a maximum of five hours private coaching a week)", "$9.00/hour");
      System.out.printf("%-30s%-80s%-30s%n", "Competition entry", "(Competitions are held on the second Saturday of each month)", "$22.00/per competition");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("Note: Athletes can only receive a maximum of five hours private coaching a week.");
   }

   // a method to display weight categories
   public static void printWeightCategory(){
      System.out.println("\n\n\n\t\t\t\t\t\tCOMPETITION WEIGHT CATEGORY");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-110s%-10s%n", "Weight Category", "Upper Weight Limit (kg)");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.printf("%-110s%-10s%n", "Heavyweight", "Unlimited (Over 100kg)");
      System.out.printf("%-110s%-10s%n", "Light Heavyweight", "100kg");
      System.out.printf("%-110s%-10s%n", "Middleweight", "90kg");
      System.out.printf("%-110s%-10s%n", "Light Middleweight", "81kg");
      System.out.printf("%-110s%-10s%n", "Lightweight", "73kg");
      System.out.printf("%-110s%-10s%n", "Flyweight", "66kg");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------\n\n\n");
   }

}


// three subclasses that extend the TrainingPlan class and override the getCost() method with their specific values

// Beginner class
class Beginner extends TrainingPlan {

    // call the super constructor with "Beginner" as the argument
    public Beginner() {
        super("Beginner");
    }

    // override the getCost() method and return $25 as the getCost
    @Override
    public double getCost() {
        return 25.00;
    }
}

// Intermediate class
class Intermediate extends TrainingPlan {

    // call the super constructor with "Intermediate" as the argument
    public Intermediate() {
        super("Intermediate");
    }

    // override the getCost() method and return $30 as the getCost
    @Override
    public double getCost() {
        return 30.00;
    }
}

// Elite class
class Elite extends TrainingPlan {

    // call the super constructor with "Elite" as the argument
    public Elite() {
        super("Elite");
    }

    // override the getCost() method and return $35 as the getCost
    @Override
    public double getCost() {
        return 35.00;
    }
}