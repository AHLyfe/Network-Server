package network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import network.Packet.*;

public class MPServer {
	private Server server;
	
	public MPServer() throws IOException{
		server = new Server();
		registerPackets();
		server.addListener(new NetworkListener());
		server.bind(2718,2718);
		server.start();
		
	}
	
	private void registerPackets(){
		Kryo kryo = server.getKryo();
		kryo.register(Packet0LoginRequest.class);
		kryo.register(Packet1LoginAccepted.class);
		kryo.register(Packet2Message.class);
	}
}
