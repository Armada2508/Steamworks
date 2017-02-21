package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2508.robot.util.Location;
import org.usfirst.frc.team2508.robot.util.Type;
import org.usfirst.frc.team2508.robot.util.VisionService;

/**
 *
 */
public class AutonomousCameraDrive extends Command {

    VisionService visionService;
    boolean finished;

    public AutonomousCameraDrive() {
        requires(Robot.DriveSystem);
        visionService = new VisionService();
        finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }


    // Called repeatedly when this Command is scheduled to run

    protected void execute() {
        Location location = visionService.retrieveLocation();
        double distance = location.getDistance();
        double angle = location.getAngle();
        Type type = location.getType();
        if (distance > 125) {
            Robot.DriveSystem.drive(0.84, 0.84);
        } else if (distance > 0) {
            double speed = distance / 150;
            Robot.DriveSystem.drive(speed, speed);
        }

        if (distance < 20) {
            finished = true;
        }

        System.out.println("Distance: " + distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.DriveSystem.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.DriveSystem.drive(0, 0);
    }
}
