package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearLG extends Command {

    public GearLG() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.GearSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.x.get()) {
    		Robot.GearSystem.GearPick(true);
    	}
    	if (Robot.oi.b.get()) {
    		Robot.GearSystem.GearPick(false);
    	}
    	if (Robot.oi.y.get()) {
    		Robot.GearSystem.GearLift(true);
    	}
    	if (Robot.oi.a.get()) {
    		Robot.GearSystem.GearLift(false);
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
