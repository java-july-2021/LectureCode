import java.util.ArrayList;

public class ZooKepper {
  public static void main(String[] args) {
    Gorilla magilla = new Gorilla();
    Mammal matthew = new Mammal("Human", 100);
    Barrel barrel1 = new Barrel();
    matthew.attack(magilla);

    magilla.attack(barrel1);

    ArrayList<Mammal> mammals = new ArrayList<Mammal>();
    mammals.add(matthew);
    mammals.add(magilla);

    for (Mammal m : mammals) {
      System.out.println(m.getSpecies());
    }
  }
}