package com.cooksys.java_client_assignment;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class Client implements Runnable{
	
	private int clientValue;
	
	public Client (int clientValue) {
		this.clientValue = clientValue;
	}
	
	
	public void createClient () {
		try (
			Socket client = new Socket("localhost", 8080);
			OutputStream bos = new BufferedOutputStream(new DataOutputStream(client.getOutputStream()));
		) {
			System.out.println("Client " + clientValue + " connected successfully.");	
			bos.write(clientValue);
			bos.flush();
		} catch (IOException e){
			System.out.println("Client " + clientValue + " failed to connect to localhost on port 8080");
			e.printStackTrace();
		}
	}
	
	public void run () {
		createClient();
	}
}
