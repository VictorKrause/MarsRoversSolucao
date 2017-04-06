package ctlr;

import entities.*;

public class Util {
	public static void processCommand(Rover rov, String cmd){
		for (int i = 0; i < cmd.length(); i++)
			rov.moveRover(cmd.charAt(i));
	}
}
