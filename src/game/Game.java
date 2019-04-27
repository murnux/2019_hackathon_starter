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
		System.out.println(winner);
		bothEntities[0] = p;
		bothEntities[1] = e;
		bothEntities[2] = winner;
		return bothEntities;
	}
	
	
	private Entity fight(Player p, Enemy e) {
		Random r = new Random();
		Entity winner = null;
		
		do {
			int whoHits = r.nextInt((1 - 0) + 1) + 0; // returns 0 or 1
			System.out.println(whoHits);
			if (whoHits == 1) { // player hits
				p.attack(e);
			} else { // enemy hits
				e.attack(p);
			}
		} while (p.isDead() == false || e.isDead() == false);
		
		if (p.isDead()) {
			winner = e;
		} else if (e.isDead()) {
			winner = p;
		}
		
		return winner;
	}

	
}
