package sample;

public class Animal {
	private String species;
	private String name;
	private int health;
	private int strength;
	private boolean hasWings;
	
	public Animal() {
		
	}

	public Animal(String species, String name, int health, int strength, boolean hasWings) {
		this.species = species;
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.hasWings = hasWings;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public boolean isHasWings() {
		return hasWings;
	}

	public void setHasWings(boolean hasWings) {
		this.hasWings = hasWings;
	}
	
	
}
