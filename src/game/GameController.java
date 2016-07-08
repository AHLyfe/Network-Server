package game;

import main.Main;
import network.packet.ClientUpdate;

public class GameController implements Runnable{
	Thread gameLoop = new Thread(this);
	public static Map map;
	
	public GameController(){
		map = new Map("default");
		
		gameLoop.start();
		Main.mpServer.serverThread.start();
	}

	
	public void run(){
		long time = System.nanoTime();
		while (true){
			long timeStep = System.nanoTime() - time;
			if (timeStep > 150000){ //0.00015 seconds
				time = System.nanoTime();
				double dt = (double)timeStep/1000000000;
				map.update(dt);
			}
		}
	}
	
	public void setMap(String mapName){
		System.out.println("Hello");
		Main.logger.info(mapName);
	}
	
	public ClientUpdate getState(){
		ClientUpdate state = new ClientUpdate();
		for(GameObject obj : Map.gameObjects){
			if (obj instanceof CircularObject){
				CircularObject cO = (CircularObject) obj; 
				state.addPos(cO.position);
				state.addRadius(cO.getRadius());
			}
		}
		
		return state;
	}
}
