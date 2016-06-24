package network;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import javax.swing.JTextArea;

public class OutputHandler extends Handler{
	private JTextArea textArea;
	
	public OutputHandler(JTextArea area){
		this.textArea = area;
	}

	@Override
	public void publish(LogRecord record) {
		textArea.append(format(record));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public String format(LogRecord logRecord){
		StringBuilder builder = new StringBuilder();
		Level level = logRecord.getLevel();
		
		if(level == Level.FINEST){
			builder.append("[FINEST] ");
		}
		else 	if(level == Level.FINER){
			builder.append("[FINER] ");
		}
		else 	if(level == Level.FINE){
			builder.append("[FINE] ");
		}
		else 	if(level == Level.INFO){
			builder.append("[INFO] ");
		}
		else 	if(level == Level.WARNING){
			builder.append("[WARNING] ");
		}
		else 	if(level == Level.SEVERE){
			builder.append("[SEVBERE] ");
		}
		
		builder.append(logRecord.getMessage());
		builder.append('\n');
		
		Throwable t = logRecord.getThrown();
		
		if(t != null) {
			StringWriter writer = new StringWriter();
			t.printStackTrace(new PrintWriter(writer));
			builder.append(writer.toString());
		}
		
		return builder.toString();
	}

	@Override
	public void flush() {
		
	}

	@Override
	public void close() throws SecurityException {
		
	}

}
