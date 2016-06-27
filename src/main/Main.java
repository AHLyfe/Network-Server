package main;

import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.esotericsoftware.minlog.Log;

import network.MPServer;
import network.Properties;
import network.Window;

public class Main {
	public static MPServer mpServer;
	public static Logger logger;
	public static Properties properties;
	
	public static void main(String[] args){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger = Logger.getLogger("ServerLog");
		properties = new Properties();
				
		JFrame frame = new JFrame("Server");
		frame.add(new Window(logger));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		logger.info("test");
				
		try {
			mpServer = new MPServer();
			Log.set(Log.LEVEL_DEBUG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
