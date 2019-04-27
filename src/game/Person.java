package game;

import com.shasta.threaded.ClientRunnable;

abstract class Person {
	private String name;
	private int health;
	private int attack;
	
	abstract public boolean isDead();
	abstract public int getHealth();
	abstract public String getName();
	
	public void attack(Person p) {
		p.hit();
	}
	private void hit() {
		health -= 1;
		
	}
	
}
