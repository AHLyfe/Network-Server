package game;

public class Player extends Object{
	private int teamID;
	private String username;
	
	
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
	
	
}


