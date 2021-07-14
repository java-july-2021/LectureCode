import java.util.Arrays;

public class PizzaTester {
  public static void main(String[] args) {
    String[] toppings = { "Sauce", "Cheese" };
    Pizza cheesePizza = new Pizza("Matt's Super Cheese Pizza", new String[] { "Sauce", "Cheese" }, 9.99, 8, true);
    cheesePizza.setName("Cheese Pizza");
    System.out.println(cheesePizza.getName());
    System.out.println(Arrays.toString(cheesePizza.getToppings()));
    cheesePizza.displayPizza();
    cheesePizza.eatSlice(4);
    System.out.println(cheesePizza.getSlices());
    Pizza hawaiian = new Pizza("Hawaiian Pizza", new String[] { "Ham", "Pineapple", "Pepperoni" }, 11.99, 8, true);
    System.out.println(Pizza.numberOfPizzas);
    Pizza.advertise();
    cheesePizza.pizzaFight(hawaiian);
    Pizza baconAndOlive = new Pizza("Bacon and Black Olive", new String[] { "bacon", "Black Olive", "Sauce" }, 10,
        true);
    baconAndOlive.eatSlice();
  }
}