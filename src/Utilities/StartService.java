package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import BusinessManager.BusinessManager;

public class StartService {
	
	private ServerSocket server;
	private Socket client;

	public StartService(){
		init();
	}

	public void init(){
		try {
			server = new ServerSocket(8889);
			startService();
		} catch (IOException e) {
			writeToServer();
			e.printStackTrace();
			return;
		}

	}

	public void startService(){

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				BufferedReader reader = null;
				while(true){
					try {

						client = server.accept();

						System.out.println("Connected to " + client.toString());

						reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

						if(reader.readLine().equals("Open")){
							JOptionPane.showMessageDialog(BusinessManager.frame, "The Business Manager is already running. Only one instance of the Business Manager can run at a time.", "Message",JOptionPane.INFORMATION_MESSAGE);
						}


					} catch (IOException e) {
						e.printStackTrace();
					}


				}
			}
		});

		thread.start();
	}
	
	public void writeToServer(){

		PrintWriter writer;

		try {

			client = new Socket("localhost", 8889);
			writer = new PrintWriter(client.getOutputStream());
			StringBuffer output = new StringBuffer("");
			output.append("Open");
			writer.write(output.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Notifying the already running instance...\n\nExiting...");
		System.exit(0);

	}

}
