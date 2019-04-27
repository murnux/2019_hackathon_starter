package game;

import java.net.Socket;
import java.util.Random;

import com.shasta.threaded.ClientRunnable;

public class Game {

	public Entity[] start(String name) {
		Entity[] bothEntities = new Entity[3];
		
		Player p = new Player(name);
		Enemy e = new Enemy();
		
		Entity winner = fight(p, e);
		bothEntities[0] = p;
		bothEntities[1] = e;
		bothEntities[2] = winner;
		return bothEntities;
	}
	
	
	private Entity fight(Player p, Enemy e) {
		Random r = new Random(); // set up random object for random num generation
		Entity winner = null;
		boolean keepRunning = true;
		
		while (keepRunning) {
			int whoHits = r.nextInt((1 - 0) + 1) + 0; // returns 0 or 1
			if (whoHits == 1) { // player hits
				p.attack(e);
				if (e.isDead()) {
					keepRunning = false; // stop if enemy has died
					winner = e;
				}
			} else { // enemy hits
				e.attack(p);
				if (p.isDead()) {
					keepRunning = false; // stop if player has died
					winner = p;
				}
			}
		} 
		return winner;
	}

	
}
