package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autonomousCommand extends Command {

    public autonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		//Robot.AutoOutputs.aOutputs(gearLift, gearPick, wPowerL, wPowerR);
    	//sets all to zero
    	Robot.AutoOutputs.aOutputs(false, false, 0, 0);
    	//holds gear
		Robot.AutoOutputs.aOutputs(false, true, 0, 0);
		Timer.delay(.8);
		//holds and picks up gear
		Robot.AutoOutputs.aOutputs(true, true, 0, 0);
		Timer.delay(.8);
		//holds pick up gear and drives at 50% straight  
		Robot.AutoOutputs.aOutputs(true, true, .5, .5);
		System.out.println("2 okay");
		Timer.delay(4000);
		
		Robot.AutoOutputs.aOutputs(true, true, 0, .3);
		System.out.println("3 okay");
		Timer.delay(2);
		Robot.AutoOutputs.aOutputs(true, true, .2, .2);
		Timer.delay(3);
		Robot.AutoOutputs.aOutputs(true, true, 0, 0);
		Timer.delay(1.5);
		Robot.AutoOutputs.aOutputs(true, false, 0, 0);
		Timer.delay(1);
		Robot.AutoOutputs.aOutputs(false, false, 0, 0);
		Timer.delay(.5);
		Robot.AutoOutputs.aOutputs(false, false, -.5, -.5);
		Timer.delay(1);
		Robot.AutoOutputs.aOutputs(false, false, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
