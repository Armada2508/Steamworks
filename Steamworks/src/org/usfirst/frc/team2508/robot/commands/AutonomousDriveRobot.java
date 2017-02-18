package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveRobot extends Command {
	
	double driveTime;
	
	Timer timer = new Timer();
	double initialTime;
	double speed;
    public AutonomousDriveRobot(double time, double speed) {
    	this.speed = speed;
    	this.driveTime = time;
    	this.initialTime = timer.get();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.drive(speed,speed);
    }


    // Called repeatedly when this Command is scheduled to run
	
    protected void execute() {
    	
    	//System.out.println("open2");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (initialTime + driveTime < timer.get());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
