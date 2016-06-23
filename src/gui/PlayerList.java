package gui;

import javax.swing.JList;

public class PlayerList extends JList{
	public PlayerList(){
		String[] players = {"Ally", "Martin", "test"};
		this.setListData(players);
	}

}
