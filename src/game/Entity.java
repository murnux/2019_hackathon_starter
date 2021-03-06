package game;

import java.util.Random;


public abstract class Entity {
	protected String name;
	protected int health;
	protected int strength;
	
	abstract public int getHealth();
	abstract public String getName();
	
	public boolean isDead() {
		if (health <= 0) {
			return true;
		} else {
			return false;
		}
	}
	private void decHealth(int amt) {
		health -= amt;
	}
	
	protected void hit(int amt) {
		health -= amt;
	}
	
	protected void attack(Entity en) {
		Random r = new Random();
		int damage = r.nextInt((strength - 0) + strength) + 0; // deals damage between 0 and an entities strength
		en.decHealth(damage);
	}
	
	public String toString() {
		return name + " has " + health + " health" + " and has " + strength + " strength.";
	}
	
	public String gravestone() {
		String stone = "        _.---,._,'\n" + 
				"       /' _.--.<\n" + 
				"         /'     `'\n" + 
				"       /' _.---._____\n" + 
				"       \\.'   ___, .-'`\n" + 
				"           /'    \\\\             .\n" + 
				"         /'       `-.          -|-\n" + 
				"        |                       |\n" + 
				"        |                   .-'~~~`-.\n" + 
				"        |                 .'         `.\n" + 
				"        |                 |  R  I  P  |\n" + 
				"  jgs   |                 |           |\n" + 
				"        |                 |           |\n" + 
				"         \\              \\\\|           |//\n" + 
				"   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
		stone += "\n\n\n " + "Sadly, " + name + " has died.\n"; 
		return stone;
	}
	
}
