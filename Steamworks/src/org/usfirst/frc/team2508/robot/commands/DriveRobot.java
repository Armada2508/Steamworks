package org.usfirst.frc.team2508.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2508.robot.Robot;

/**
 *
 */
public class DriveRobot extends Command {
	
	public int count = 1;
	
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
    	
    	switch (count){
    	case 0:
        	Robot.driveSystem.drive(Robot.oi.stick.getRawAxis(5), Robot.oi.stick.getRawAxis(1));
    		break;
    	case 1:
    		double RCalc, LCalc;
    		RCalc = Robot.oi.stick.getRawAxis(1)*2;
    		LCalc = Robot.oi.stick.getRawAxis(1)*2;
    		RCalc -= Robot.oi.stick.getRawAxis(0);
    		LCalc += Robot.oi.stick.getRawAxis(0);
    		Robot.driveSystem.drive(LCalc, RCalc);
    		break;
    	case 2:
    		double RCalc1, LCalc1;
    		RCalc1 = Robot.oi.stick.getRawAxis(1);
    		LCalc1 = Robot.oi.stick.getRawAxis(1);
    		RCalc1 -= Robot.oi.stick.getRawAxis(4);
    		LCalc1 += Robot.oi.stick.getRawAxis(4);
    		Robot.driveSystem.drive(LCalc1,RCalc1);
    		break;
    	case 3:
    		double RCalc2 = 0, LCalc2 = 0;
    		RCalc2 -= Robot.oi.stick.getRawAxis(3);
    		LCalc2 -= Robot.oi.stick.getRawAxis(3);
    		RCalc2 += Robot.oi.stick.getRawAxis(2);
    		LCalc2 += Robot.oi.stick.getRawAxis(2);
    		RCalc2 -= Robot.oi.stick.getRawAxis(0);
    		LCalc2 += Robot.oi.stick.getRawAxis(0);
    		Robot.driveSystem.drive(LCalc2, RCalc2);
    		break;
    	default:
        	Robot.driveSystem.drive(Robot.oi.stick.getRawAxis(5), Robot.oi.stick.getRawAxis(1));
        	break;
    	
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
