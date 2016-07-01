package network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

import main.Main;
import network.packet.LoginRequest;
import network.packet.LoginResponse;

public class ServerListener extends Listener{
	
	@Override
	public void connected(Connection con) {
		Main.logger.info(con.getRemoteAddressUDP() + " has connected");
	}
	
	@Override
	public void disconnected(Connection con) {
		Main.logger.info(con.getRemoteAddressUDP() + " has disconnected");
	}
	
	@Override
	public void received(Connection con, Object obj) {
		Main.logger.info("Recieved packet from " + con.getRemoteAddressUDP());
		
		if(obj instanceof LoginRequest){
			LoginRequest request = (LoginRequest) obj;
			
			LoginResponse response = new LoginResponse();
			if(request.getUsername().equalsIgnoreCase("Bunny")){
				// Login good
				response.setResponseText("OK");
			}
			else{
				//Login eh
				response.setResponseText("INVALID");
			}
			con.sendTCP(response);
		}
	}
	
}
