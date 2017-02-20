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
public class AutonomousCameraAngleCorrection extends Command {

    VisionService visionService;
    boolean finished;

    public AutonomousCameraAngleCorrection() {
        requires(Robot.driveSystem);
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
        if (angle < 0.1) {
            finished = true;
        }
        correct(angle);

        System.out.println("Angle: " + angle);
    }

    private void correct(Double angle) {
        Double speed = angle;
        Robot.driveSystem.drive(speed, -1 * speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveSystem.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.driveSystem.drive(0, 0);
    }
}
