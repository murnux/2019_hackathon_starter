package com.shasta.client;

import com.shasta.threaded.ClientRunnable;

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
    	Socket sock = this.getClientSocket();
        try {
			super.sendMessage("Welcome to the game!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Called when a client disconnects
     */
    @Override
    public void handleDisconnect() {
        //TODO IMPLEMENT
    }

    /**
     * Handle client input.
     * @param str The message to handle.
     */
    @Override
    protected void handleMessage(String str) {
    	Game g = new Game();
    	g.parseMessage(str);
    }
}
