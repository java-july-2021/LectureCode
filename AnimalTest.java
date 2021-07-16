public class AnimalTest {
  public static void main(String[] args) {
    Animal bear = new Animal("Smokey", 6, 100, false);
    Animal lion = new Animal("Todd", 6, 100, false);

    bear.battle(lion, "flame breath");
    System.out.println(lion.getHealth());
    lion.battle(bear, "tail whip");
    System.out.println(bear.getHealth());
  }
}