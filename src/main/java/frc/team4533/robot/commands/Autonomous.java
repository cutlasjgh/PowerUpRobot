package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team4533.robot.Robot;
/**
 * The autonomous command that the robot will run. 
 * @author 4533 Programming Team
 *
 */
public class Autonomous extends CommandGroup {

	private String gameData;
	private String position;

	/**
	 * The robot turning error is 6.3 degrees
	 * @param gameData
	 *            The setup for the switches and scale
	 * @param position
	 *            The position we put the robot at
	 */
	public Autonomous(String gameData, String position) {
		//this.addSequential(new AngleTurn(-90));
		//this.addSequential(new DriveDistance(100), 3);
//		this.gameData = gameData;
//		this.position = position;
//		// Move to and cross the Auto Line
		this.addSequential(new DriveDistance(120));
		// The lucky time that we are lined up perfectly
		if (gameData.substring(0, 1).equals(position)) {
			// Move to the switch
			this.addSequential(new DriveDistance(48));
			
			// Determine which way to turn
			if (gameData.substring(0, 1).equals("L")) {
				this.addSequential(new AngleTurn(90));
			} else {
				this.addSequential(new AngleTurn(-90));
			}
			// Releases the cube
			// this.addSequential(new MoveSwingArm(40));
			this.addSequential(new PushOut());
		}

		// The other times that we are not lined up
		else {
			// Determine which direction we need to move
			if (gameData.substring(0, 1).equals("L")) {
				this.addSequential(new AngleTurn(90));
			} else {
				this.addSequential(new AngleTurn(-90));
			}
			// If we put our robot in the middle of the field
			if (position.equals("M")) {
				this.addSequential(new DriveDistance(50));
			}

			// If we are on the opposite side of the field
			else {
				this.addSequential(new DriveDistance(100));
			}
			// Determine which way we need to turn to face the opposing side of
			// the field
			if (gameData.substring(0, 1).equals("L")) {
				this.addSequential(new AngleTurn(-90));
			} else {
				this.addSequential(new AngleTurn(90));
			}
			// Move to the switch
			this.addSequential(new DriveDistance(48));
			// Determine which way to face the switch
			if (gameData.substring(0, 1).equals("L")) {
				this.addSequential(new AngleTurn(90));
			} else {
				this.addSequential(new AngleTurn(-90));
			}
			// Releases the cube
			// this.addSequential(new MoveSwingArm(40));
			this.addSequential(new PushOut());
			}
	}
}
