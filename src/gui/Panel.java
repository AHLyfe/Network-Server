package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Panel extends JPanel{
	public Panel(){
		setPreferredSize(new Dimension(600,400));
		setLayout(new BorderLayout());
		
		add(getPlayerList(), "North");
	}
	
	public JScrollPane getPlayerList(){
		PlayerList playerList = new PlayerList();
		JScrollPane scroll = new JScrollPane(playerList);
		scroll.setBorder(new TitledBorder(new EtchedBorder(), "Player List"));
		return scroll;
	}
}
