package network;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import main.Main;
import network.packet.ClientUpdate;
import network.packet.LoginRequest;
import network.packet.LoginResponse;

public class MPServer implements Runnable{
	private Server server;
	public Thread serverThread = new Thread(this);
	
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
		kryo.register(ClientUpdate.class);
	}
	
	public void stopServer(){
		server.stop();
	}
	
	public void updateClients(){
		Connection[] clients = server.getConnections();
		ClientUpdate clientPacket = Main.gameController.getState();
		for (Connection client : clients){
			client.sendUDP(clientPacket);
		}
	}
	
	public void run(){
		long time = System.currentTimeMillis();
		while (true){
			long timeStep = System.currentTimeMillis() - time;
			if (timeStep > 30){
				updateClients();
			}
		}
	}
}
