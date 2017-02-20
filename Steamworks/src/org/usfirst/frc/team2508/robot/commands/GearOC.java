package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearOC extends Command {
	Solenoid GearOpen = new Solenoid(1);
	Solenoid GearClose = new Solenoid(2);
	boolean GearT;

    public GearOC(boolean OC) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	OC = GearT;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(GearT){
    		GearOpen.set(true);
    		GearClose.set(false);
            } else {
            	GearOpen.set(false);
        		GearClose.set(true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         //return !(Robot.oi.x.get());
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
