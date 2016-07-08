package network;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import main.Main;

public class ConsoleListener implements KeyListener{
	
	private JTextField input;
	
	public ConsoleListener(JTextField input){
		this.input = input;
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if	(e.getKeyCode()==KeyEvent.VK_ENTER){
			checkCommand(input.getText());
			input.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkCommand(String text){
		String cmd = text.split(" ", 2)[0];
		
		switch (cmd.toLowerCase()){
			case "map":
				Main.gameController.setMap(text.split(" ",2)[1]);
				break;
			case "start":
				break;
			default:
				Main.logger.warning("Invalid command");
		}
	}
}
