import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    String name = "Jesus";
    String name2 = "Jesus";

    String name3 = new String("Jesus");
    String name4 = new String("Jesus");
    System.out.println(name3.equals(name4));

    // Arrays
    // var array = [1,2,3,4,5,6,7,8,9,10]
    String[] people = { "Matthew", "Mikayel", "Travis", "Jesus", "Dylan" };
    people[0] = "Bryce";

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }

    System.out.println(numbers);
    System.out.println(Arrays.toString(numbers));

    // For Each Loop
    for (int iterator : numbers) {
      System.out.println(iterator);
    }

    Object[] myFunkyArray = { 42, "Matthew", true, 'd' };

    // ArrayList
    ArrayList<String> myStringList = new ArrayList<String>();
    myStringList.add("Matt");
    myStringList.add("having");
    myStringList.add("Coughing");
    myStringList.add("Fit");
    System.out.println(myStringList.get(2)); // System.out.println(myStringList[2])

    for (int i = 0; i < myStringList.size(); i++) {
      System.out.println(myStringList.get(i));
    }

    // Hash Maps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Matthew", "Photography");
    ourHobbies.put("Travis", "Painting");
    ourHobbies.put("Bryce", "Basketball");
    ourHobbies.put("Jesus", "Eating");
    ourHobbies.put("Camaren", "Welding");
    ourHobbies.put("Mikayel", "Music");
    ourHobbies.put("Tamara", "Reading");
    ourHobbies.put("James", "Gaming");
    ourHobbies.put("Dylan", "Golf");
    ourHobbies.put("Chan", "Foodie");
    ourHobbies.put("Kevin", "Being an Awesome Guy");
    ourHobbies.put("Zack", "Sports");
    System.out.println(ourHobbies);

    for (HashMap.Entry<String, String> entry : ourHobbies.entrySet()) {
      System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
    }

    System.out.println(maxArrayValue(numbers));
  }

  public static int maxArrayValue(int[] nums) {
    int highNum = nums[0];
    for (int i = 0; i <= nums.length; i++) {
      try {
        if (highNum < nums[i]) {
          highNum = nums[i];
        }
      } catch (IndexOutOfBoundsException cookies) {
        System.out.println(cookies);
      }
    }
    return highNum;
  }
}