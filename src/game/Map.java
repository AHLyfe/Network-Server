package game;

import java.util.ArrayList;

public class Map {
	
	/**
	 * @param name of map to be loaded
	 */
	public Map(String name){
		MAP_NAME = name;
		//loadMap() --- To be implemented 
		MAP_SIZE = 2;
		
		mapWidth = MAP_SIZE*2;
		mapHeight = MAP_SIZE*2;
	}
	
	public final String MAP_NAME;
	public final int MAP_SIZE;
	
	public static int mapWidth;
	public static int mapHeight;
	
	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public void update(double dt){
		//Loop through all game objects and update positions n stuff
		for(GameObject obj : gameObjects){
			obj.update(dt);
		}
	}
	
	public int getMapSize(){
		return MAP_SIZE;
	}
	
	public void addPlayer(String username){
		gameObjects.add(new Player(username));
	}
}
