package network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.esotericsoftware.minlog.Log;

import main.Main;

public class Panel extends JPanel{
	public static Logger logger = Logger.getLogger("ServerLog");
	Properties properties;
	
	public Panel(){
		setPreferredSize(new Dimension(600,400));
		setLayout(new BorderLayout());
		
		add(getPlayerList(), "North");
		add(getLog(), "Center");
		
		properties = new Properties();
		
		logger.info("Starting server " + "\"" + properties.name + "\"" + " on port " + properties.port);
				
	}
	
	public JScrollPane getPlayerList(){
		PlayerList playerList = new PlayerList();
		JScrollPane scroll = new JScrollPane(playerList);
		scroll.setBorder(new TitledBorder(new EtchedBorder(), "Connected Players"));
		return scroll;
	}
	
	public JPanel getLog(){
		JPanel panel = new JPanel(new BorderLayout());
		JTextArea text = new JTextArea();
		logger.addHandler(new OutputHandler(text));
		JScrollPane pane = new JScrollPane(text);
		text.setEditable(false);
		
		JTextField input = new JTextField();
		
		panel.add(pane, "Center");
		panel.add(input, "South");
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Log Output"));
		
		return panel;
	}
}