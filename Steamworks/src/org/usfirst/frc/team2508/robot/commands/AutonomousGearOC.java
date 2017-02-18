package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.subsystems.GearGripper;

//import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousGearOC extends Command {

	GearGripper gearGripper;
	boolean finished;
    public AutonomousGearOC(GearGripper gearGripper, boolean finished) {
        // Use requires() here to declare subsystem dependencies
    	this.gearGripper = gearGripper;
    	this.finished = finished;
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gearGripper.set(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //1 return !(Robot.oi.x.get()); 
    	 return finished; 
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	gearGripper.set(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
