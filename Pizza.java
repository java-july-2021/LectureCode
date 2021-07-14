import java.util.Arrays;

public class Pizza {
  // Access Modifiers
  private String name;
  private String[] toppings;
  private double price;
  private int slices;
  private boolean delicious;
  static int numberOfPizzas;

  // Constructor
  public Pizza(String name, String[] toppings, double price, int slices, boolean delicious) {
    // THIS KEYWORD
    this.name = name;
    this.toppings = toppings;
    this.price = price;
    this.slices = slices;
    this.delicious = delicious;
    numberOfPizzas++;
  }

  // Method Overloading
  public Pizza(String name, String[] toppings, int slices, boolean delicious) {
    this.name = name;
    this.toppings = toppings;
    this.price = 40.99;
    this.slices = slices;
    this.delicious = delicious;
    numberOfPizzas++;
  }

  // Getters And Setters
  public String getName() {
    return this.name;
  }

  public String[] getToppings() {
    return this.toppings;
  }

  public double getPrice() {
    return this.price;
  }

  public boolean getDelciious() {
    return this.delicious;
  }

  public int getSlices() {
    return this.slices;
  }

  public void setName(String name) {
    if (name.equals("")) {
      System.out.println("Name is required! Try again");
      return;
    }
    this.name = name;
  }

  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setDelicious(boolean delicious) {
    this.delicious = delicious;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  // Things you can do
  // Advertise
  // Eat a slice
  // Display the pizza attributes..

  public void displayPizza() {
    System.out.printf("This is a %s with %s toppings that costs %.2f and is delicious? %b \n", this.name,
        Arrays.toString(this.toppings), this.price, this.delicious);
  }

  // Method Overloading
  public int eatSlice(int number) {
    System.out.println("You have eaten a slice of " + this.name);
    this.slices = this.slices - number;
    return this.slices;
  }

  public double eatSlice(double portionOfSlice) {
    return this.slices -= portionOfSlice;

  }

  public void eatSlice() {
    this.eatSlice(1);
  }

  public static void advertise() {
    System.out.println("Come to our pizza shop, were not mafia owned.. wink wink nudge nudge");
  }

  public void pizzaFight(Pizza otherPizza) {
    int otherPizzaSlices = otherPizza.getSlices();
    otherPizzaSlices -= 1;
    otherPizza.setSlices(otherPizzaSlices);
    System.out.println(this.name + " just took a bite out of " + otherPizza.getName());
    System.out.println(otherPizza.getName() + " now has " + otherPizza.getSlices() + " slices");
  }
}