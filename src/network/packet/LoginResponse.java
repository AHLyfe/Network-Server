package network.packet;

public class LoginResponse {
	private String responseText;
	
	public void setResponseText(String responseText){
		this.responseText = responseText;
	}
	
	public String getResponseText(){
		return this.responseText;
	}
}