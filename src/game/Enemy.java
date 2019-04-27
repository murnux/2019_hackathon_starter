package game;

public class Enemy extends Entity {

	public Enemy() {
		this.name = "Skeleton";
		this.health = 10;
		this.strength = 5;
	}
	
	public int getHealth() {
		return health;
	}
	public String getName() {
		return name;
	}

	
	
}
