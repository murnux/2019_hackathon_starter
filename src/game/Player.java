package game;

public class Player extends Entity {	
	public Player(String name) {
		this.name = name;
		this.health = 10;
		this.strength = 5;
	}
	
	
	public int getHealth() {
		return health;
	}
	
	public void hit() {
		this.health--;
	}
	 
	public String getName() {
		return name;
	}

	
	
}
