package com.cooksys.java_client_assignment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	
	int handledClients = 0;
	
	int clientLimit = 10;
	
	public Server (int clientLimit) {
		this.clientLimit = clientLimit;
	}
	
	public void startServer () {
		System.out.println("Starting Server...");
		
		
		while(handledClients < clientLimit) {
			try (
				ServerSocket ss = new ServerSocket(8080);
			){
				Socket server = ss.accept();
				ClientHandler ch = new ClientHandler(server);
				Thread t = new Thread(ch);
				t.start();
			} catch (IOException e) {
				System.out.println("Server was unable to connect to the client: 8080");
				e.printStackTrace();
				break;
			}
		}
	}
	
	public void run () {
		startServer();
	}
}
