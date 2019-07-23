package com.tavisca.workshops.pratham.rover;

import com.tavisca.workshops.pratham.rover.model.Command;
import com.tavisca.workshops.pratham.rover.model.Direction;
import com.tavisca.workshops.pratham.rover.model.Position;
import com.tavisca.workshops.pratham.rover.model.RoboState;

import java.security.InvalidParameterException;

public class MarsRoboRover {

	public static int x = 0;
	public static int y = 0;
	private static String dir = "";
	public static void main(String[] args) {

		String currentPosition = "3 3 E";
		String commandString = "MMRMMRMRRM";

		String[] positions = currentPosition.split(" ");

		 x = Integer.valueOf(positions[0]);
		 y = Integer.valueOf(positions[1]);
		Position position = new Position(x, y);

		dir = positions[2];
		Direction direction = parseDirection(dir.charAt(0));

		RoboState currentState = new RoboState(position, direction);

		Command[] commands = extractCommands(commandString);

		RoboRover roboRober = new RoboRover(currentState);
		RoboState newState = roboRober.rove(commands);

		System.out.println("currentPosition..." + currentPosition);
		System.out.println("commands..." + commandString);

		System.out.println("NewPosition...");
		System.out.print("Old Implementation: ");
		for(char command : commandString.toCharArray()) {
			rove(command);
		}
		System.out.println(x + " " + y + " " + dir);

		System.out.println("New Implementation: " + newState.getPosition().getX() + " " + newState.getPosition().getY()
				+ " " + toDirectionChar(newState.getDirection()));


	}

	private static char toDirectionChar(Direction direction) {
		switch (direction){
			case NORTH:
				return 'N';
			case EAST:
				return 'E';
			case SOUTH:
				return 'S';
			case WEST:
				return 'W';
			default:
				return 'U';

		}
	}

	private static Direction parseDirection(char direction) {
		switch (direction){
			case 'N':
				return Direction.NORTH;
			case 'E':
				return Direction.EAST;
			case 'S':
				return Direction.SOUTH;
			case 'W':
				return Direction.WEST;
			default:
				throw new InvalidParameterException();
		}
	}

	private static Command[] extractCommands(String commandString){
		Command[] commands = new Command[commandString.length()];
		int commandsIndex = 0;

		for (char command : commandString.toCharArray()) {
			switch(command){
				case 'L':
					commands[commandsIndex++] = Command.TURN_LEFT;
					break;
				case 'R':
					commands[commandsIndex++] = Command.TURN_RIGHT;
					break;
				case 'M':
					commands[commandsIndex++] = Command.MOVE_FORWARD;
					break;
				default:
					throw new InvalidParameterException();
			}
		}
		return commands;
	}

	private static void rove(char command) {
		if (dir.equalsIgnoreCase("N")) {
			switch (command) {
			case 'L':
				dir = "W";
				break;
			case 'R':
				dir = "E";
				break;
			case 'M':
				y++;
				break;
			}
		} else if (dir.equalsIgnoreCase("E")) {
			switch (command) {
			case 'L':
				dir = "N";
				break;
			case 'R':
				dir = "S";
				break;
			case 'M':
				x++;
				break;
			}
		} else if (dir.equalsIgnoreCase("S")) {
			switch (command) {
			case 'L':
				dir = "E";
				break;
			case 'R':
				dir = "W";
				break;
			case 'M':
				y--;
				break;
			}
		} else if (dir.equalsIgnoreCase("W")) {
			switch (command) {
			case 'L':
				dir = "S";
				break;
			case 'R':
				dir = "N";
				break;
			case 'M':
				x--;
				break;
			}
		}
	}

}
