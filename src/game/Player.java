package game;

public class Player extends Object{
	private int teamID;
	private int playerID;
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

	@Override
	void update(double dt) {
		// TODO Auto-generated method stub
		
	}
}


