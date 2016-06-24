package main;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.esotericsoftware.minlog.Log;
import com.sun.media.jfxmedia.logging.Logger;

import gui.Panel;
import network.MPServer;

public class Main {
	static MPServer mpServer;
	
	public static void main(String[] args){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Server");
		frame.add(new Panel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
		try {
			mpServer = new MPServer();
			Log.set(Log.LEVEL_DEBUG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
