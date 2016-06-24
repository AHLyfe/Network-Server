package network;

import java.io.IOException;
import java.util.logging.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import network.Packet.*;

public class MPServer {
	private Server server;
	
	public MPServer() throws IOException{
		server = new Server();
		registerPackets();
		server.addListener(new NetworkListener());
		server.bind(Properties.port,Properties.port);
		server.start();
		
	}
	
	private void registerPackets(){
		Kryo kryo = server.getKryo();
		kryo.register(Packet0LoginRequest.class);
		kryo.register(Packet1LoginAccepted.class);
		kryo.register(Packet2Message.class);
	}
}
