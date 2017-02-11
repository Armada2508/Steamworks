package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallPickerUpper extends Command {
	Boolean BallPickerUpperBoo = false;

	public BallPickerUpper() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);]
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//BallPickerUpperBoo = !BallPickerUpperBoo;	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		while (Robot.oi.b.get() == true) {
			BallPickerUpperBoo = !BallPickerUpperBoo;
			System.out.println(Math.random()*10);
		} 
		
		if (BallPickerUpperBoo == true) {
			Robot.oi.ballRunner.set(-1);
			//BallPickerUpperBoo = false;
		} else if(BallPickerUpperBoo == false) {
			Robot.oi.ballRunner.set(0);
			//BallPickerUpperBoo = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
		//return !(Robot.oi.a.get());
	}

	// Called once after isFinished returns true
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
