public class Gorilla extends Mammal {
  public Gorilla() {
    super("Gorilla", 500);
  }

  public void eatBanana() {
    System.out.printf("I am a %s eating a banana", this.species);
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health = (damageAmount / 2);
  }
}