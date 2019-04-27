package com.shasta.client;

import com.shasta.threaded.ClientRunnable;

import game.Entity;
import game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * Client object that contains methods to handle connects, disconnects, and messages for one client.
 *
 * @author Chandler Severson
 * @since 2019-12-10
 * <p>Made as a starter project for the 2019 Shasta Networks/SOU CS Club Hackathon.</p>
 */
public class Client extends ClientRunnable {
	
	OutputStream out = null;
    BufferedReader in = null;

    public Client(Socket clientSocket) {
        super(clientSocket);
        System.out.println(getClientSocket().getLocalAddress() + ": New Connection. Port: " + getClientSocket().getPort());
    }

    /**
     * Called when a client connects.
     */
    @Override
    public void handleConnect() {
        try {
        	// Yes this looks absolutely grotesque, but it displays as expected in telnet. :)
			super.sendMessage(" ---------------------------------------\n" + 
					"|	    Yet Another			|\n" + 
					"|	    Fighting Game		|\n" + 
					"|					|\n" + 
					"-----------------------------------------\n");
			super.sendMessage("\n Type in your character's name: ");
		} catch (IOException e) {
			System.err.println("Something in handleConnect occured. :/");
		}
    }

    /**
     * Called when a client disconnects
     */
    @Override
    public void handleDisconnect() {
        System.out.println("Game over!");
    }

    /**
     * Handle client input.
     * @param str The message to handle.
     */
    @Override
    protected void handleMessage(String str) {
    	if (str == null || str == "") {
    		try {
    			super.sendMessage("You did not type a name, please try again.\n");
    		} catch (IOException e) {
    			System.err.println("No name was typed.");
    		}
    	} else {
	    	Game g = new Game();
	    	Entity[] entities = g.start(str);
	    	
	    	 
	    		try {
	    			super.sendMessage("Results after the fight: \n");
	    			for (int i = 0; i <= entities.length - 2; i++) { // -2 so it doesn't print out the last element the winner (yet).
	    				super.sendMessage(entities[i].toString() + "\n");
	    			}
	    			super.sendMessage("\n " + entities[2].getName() + " is the winner!");
	    			
	    			if (entities[2] == entities[0]) {
	    				super.sendMessage(entities[0].gravestone());
	    			} else {
	    				super.sendMessage(entities[1].gravestone());
	    			}
	    		} catch (IOException e) {
	    			System.err.println("Something in handleMessage occured. :/");
	    		}
    	}
    }
}
