package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallPickerUpper extends Command {

	boolean hacks = true;
	long lTime = 0;
	public BallPickerUpper() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (Robot.oi.a.get()&& lTime+200 < System.currentTimeMillis()){
			lTime = System.currentTimeMillis();
			if (hacks){
				Robot.oi.ballRunner.set(-1);
			 hacks = false;	
			}
			else{
				Robot.oi.ballRunner.set(0);
				hacks = true;
			}
			
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
