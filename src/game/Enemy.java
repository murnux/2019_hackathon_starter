package game;

public class Enemy extends Person {
	String name = "Skeleton";
	int health = 2;
	int attack = 1;
	public boolean isDead() {
		if (health <= 0) {
			return true;
		} else {
			return true;
		}
	}
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public void attack(Player p) {
		// TODO Auto-generated method stub
		
	}
	
	
}
