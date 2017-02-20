package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRobot extends Command {
	
	public int count = 2;
	
    public DriveRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }


    // Called repeatedly when this Command is scheduled to run
	
    protected void execute() {
    	
    		double RCalc1, LCalc1;
    		RCalc1 = (Robot.oi.stick.getRawAxis(1));
    		LCalc1 = (Robot.oi.stick.getRawAxis(1));
    		RCalc1 -= (Robot.oi.stick.getRawAxis(4)/2);
    		LCalc1 += (Robot.oi.stick.getRawAxis(4)/2);
    		Robot.driveSystem.drive(LCalc1,RCalc1);
    		//System.out.println("open2");
    	
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
