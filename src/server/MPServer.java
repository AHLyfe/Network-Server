package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class MPServer {
	private Server server;
	
	public MPServer(){
		Log.set(Log.LEVEL_DEBUG);
		server = new Server();
		
	}
	
	private void registerPackets(){
		Kryo kyro = server.getKryo();
		
	}
}
