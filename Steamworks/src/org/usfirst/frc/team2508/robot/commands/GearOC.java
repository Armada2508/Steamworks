package org.usfirst.frc.team2508.robot.commands;

//import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearOC extends Command {
	DoubleSolenoid ocDouble = new DoubleSolenoid(1, 2);
	public boolean GearT = false;

    public GearOC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	GearT = !GearT;
    	//1 ocDouble.set(DoubleSolenoid.Value.kReverse);
    	System.out.println("open1");

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (GearT = false){
    		ocDouble.set(DoubleSolenoid.Value.kReverse);
    		System.out.println("open");
    	}
    	if (GearT = true){
    		ocDouble.set(DoubleSolenoid.Value.kForward);
    		System.out.println("close");
    	}    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //1 return !(Robot.oi.x.get()); 
    	 return false; 
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	//ocDouble.set(DoubleSolenoid.Value.kForward);
    	System.out.println("close");

    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
