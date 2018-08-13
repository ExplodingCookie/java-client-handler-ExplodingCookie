package com.cooksys.java_client_assignment;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
	
	Socket ourClient;
	
	public ClientHandler (Socket ourClient) {
		this.ourClient = ourClient;
	}

	public void run () {
		try (
			InputStream bis = new BufferedInputStream(new DataInputStream(ourClient.getInputStream()));	
		)
		{
			int readValue = 0;
			readValue = bis.read();
			Thread.sleep(3000);
			System.out.println("Hello Client: " + readValue);
		} catch (IOException e) {
			System.out.println("Client Failure");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
