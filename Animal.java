public class Animal {
  private String name;
  private int strength;
  private int health;
  private boolean hasWings;

  // Constructor
  public Animal(String name, int strength, int health, boolean hasWings) {
    this.name = name;
    this.strength = strength;
    this.health = health;
    this.hasWings = hasWings;
  }

  public Animal() {

  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setHasWings(boolean hasWings) {
    this.hasWings = hasWings;
  }

  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getHealth() {
    return this.health;
  }

  public boolean getHasWings() {
    return this.hasWings;
  }

  public void battle(Animal target, String powerMove) {
    // Define the logic of how the animal attacks;
    int damage;
    if (powerMove.equals("Slash")) {
      damage = 3;
    } else if (powerMove.equals("tail whip")) {
      damage = 4;
    } else if (powerMove.equals("flame breath")) {
      damage = 5;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // multiple strength x damage
    int effectiveDamage = this.strength * damage;

    // reduce target's health by effectiveDamage
    int targetsHealth = target.getHealth();
    targetsHealth -= effectiveDamage;
    target.setHealth(targetsHealth);

    // print to the console what just happened
    System.out.printf("%s attacks %s for %d points \n", this.name, target.getName(), effectiveDamage);
  }

}