package game;

import java.net.Socket;
import java.util.Random;

import com.shasta.threaded.ClientRunnable;

public class Game {

	public void parseMessage(String msg) {
		start();
	}
	
	private void start() {
		Player player = new Player();
		Enemy enemy = new Enemy();
		
		fight(player, enemy);
	}
	
	private void fight(Player p, Enemy e) {
		Random r = new Random();
		do {
			int whoHits = r.nextInt((1 - 0) + 1) + 0;
			if (whoHits == 1) {
				ClientRunnable.sendMessage("Blah");
			}
		} while (p.isDead() == false && p.isDead() == false);
	}

	
}
