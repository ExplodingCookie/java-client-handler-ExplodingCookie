package com.cooksys.java_client_assignment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	createClients(10);
    }
    
    public static void createClients (int clientCount) {
    	Server s = new Server(clientCount);
    	Thread serverThread = new Thread(s);
    	serverThread.start();
    	
    	for(int i = 1; i <= clientCount; i++) {
    		Client c = new Client(i);
    		c.createClient();
    		s.handledClients++;
    	}
    }
}
