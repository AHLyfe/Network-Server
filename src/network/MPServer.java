package network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import network.packet.LoginRequest;
import network.packet.LoginResponse;

public class MPServer {
	private Server server;
	
	public MPServer() throws IOException{
		server = new Server();
		registerPackets();
		server.addListener(new ServerListener());
		server.bind(Properties.port,Properties.port);
		server.start();
	}
	
	private void registerPackets(){
		Kryo kryo = server.getKryo();
		kryo.register(LoginRequest.class);
		kryo.register(LoginResponse.class);
	}
	
	public void stopServer(){
		server.stop();
	}
}
