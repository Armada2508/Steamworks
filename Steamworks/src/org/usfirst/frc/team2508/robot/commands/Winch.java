package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Winch extends Command {

	CANTalon winch = new CANTalon(5);
	CANTalon winchFollower = new CANTalon(2);

	public Winch() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		winchFollower.changeControlMode(TalonControlMode.Follower);
		winchFollower.set(5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.stick.getRawAxis(2) > 0 && Robot.oi.stick.getRawAxis(3) == 0) {
			winch.set(-1);
		}
		if (Robot.oi.stick.getRawAxis(3) > 0 && Robot.oi.stick.getRawAxis(2) == 0) {
			winch.set(1);
		}
		if (Robot.oi.stick.getRawAxis(3) == 0 && Robot.oi.stick.getRawAxis(2) == 0) {
			winch.set(0);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		winch.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
