package game;

public class Player extends Person {
	String name = "Link";
	int health = 10;
	int attack = 1;
	
	public boolean isDead() {
		if (health <= 0) {
			return true;
		} else {
			return true;
		}
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

	public void attack(Person p) {
		
		
	}
	
	
}
