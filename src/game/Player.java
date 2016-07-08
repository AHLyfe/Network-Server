package game;

import java.util.Random;

public class Player extends CircularObject{
	private int teamID;
	private int playerID;
	private String username;
	
	public Player(String username){
		this.username = username;
		
		placePlayer();
	}	
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setTeam(int teamID){
		this.teamID = teamID;
	}
	
	public int getTeam(){
		return teamID;
	}

	@Override
	void update(double dt) {
		// TODO Auto-generated method stub
		
	}
	
	public void placePlayer(){
		Random rnd = new Random();
		boolean flag = false;
		
		while (flag == false){
			position.x = rnd.nextDouble()*4;
			position.y = rnd.nextDouble()*4;
			if (!collides()){
				flag = true;
			}
		}
	}
}


