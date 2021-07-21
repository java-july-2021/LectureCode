package sample;

import java.util.ArrayList;

public class AnimalTester {
	
	public static void main(String[] args) {
		Animal dog = new Animal("dog", "buster", 100, 100, false);
		Animal cat = new Animal("cat", "meow", 900, 50, false);
		System.out.println("Spring tool Suite Rocks!");
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		myAnimals.add(dog);
		myAnimals.add(cat);
		for(Animal a : myAnimals) {
			System.out.println(a.getName());
		}
	}

	
	
}
