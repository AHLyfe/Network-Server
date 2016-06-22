package main;

import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class Main {
	private Server server;
	
	public Main(){
		
	}

	public static void main(String[] args) {
		new Main();
		Log.set(Log.LEVEL_DEBUG);

	}

}
