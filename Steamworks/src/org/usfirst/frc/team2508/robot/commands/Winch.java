package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Winch extends Command {

	CANTalon winch = new CANTalon(5);
	private double sped=0;
    public Winch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this(1);
    }
    public Winch(double speed){
    	sped = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	winch.set(sped);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (!(Robot.oi.y.get())&&!(Robot.oi.lb.get()));
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
