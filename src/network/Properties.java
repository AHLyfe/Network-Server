package network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Properties {
	public File optionsFile;
	
	public int maxPlayers = 6;
	public String name = "A Server";
	public static int port = 2718;
	
	
	public Properties(){
		optionsFile = new File("server_properties.txt");
		
		if(!optionsFile.exists()) {
			if(!createOptions()) throw new RuntimeException("Error creating properties file!");
		}
			loadOptions();
	}
	
	private void loadOptions() {
		try { 
		if(!optionsFile.exists()) return;
		
			BufferedReader br = new BufferedReader(new FileReader(optionsFile));
			
			for(String s = ""; (s = br.readLine()) != null;) {
				String[] split = s.split(":");
				
				if(split[0].equals("serverName")) {
					name = split[1];
				}
				else if(split[0].equals("maxPlayers")) {
					maxPlayers = Integer.parseInt(split[1]);
				}
				else if(split[0].equals("port")){
					port = Integer.parseInt(split[1]);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Failed to load options!");
			e.printStackTrace();
		}
		
	}
	
	private boolean createOptions(){
		try {
			PrintWriter print = new PrintWriter(new FileWriter(optionsFile));
			print.println("serverName:" + name);
			print.println("maxPlayers:" + maxPlayers);
			print.println("port:" + port);
			print.close();
			return true;
		} catch (IOException e) {
			System.out.println("Failed to save options!");
			e.printStackTrace();
			return false;
		}
	}
}
