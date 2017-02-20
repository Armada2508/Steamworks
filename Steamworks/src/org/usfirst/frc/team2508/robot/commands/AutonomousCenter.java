package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonomousCenter extends CommandGroup {
    public AutonomousCenter() {
        addSequential(new AutonomousGearOC(true)); //Tell the subsystem to grip the gear
        addSequential(new AutonomousGearLifter(true)); //Tell the subsystem to lift the gear

        addSequential(new AutonomousDriveRobot(-0.2, -0.2));// left speed, right speed
        addSequential(new WaitCommand(10));
        addSequential(new AutonomousDriveRobot(0, 0));

        addSequential(new AutonomousDriveRobot(-0.2, 0.2)); // Turn
        addSequential(new WaitCommand(3));
        addSequential(new AutonomousDriveRobot(0, 0));

        addSequential(new AutonomousCameraAngleCorrection()); //Use the camera to correct for the robot angle

        addSequential(new AutonomousCameraDrive());

        addSequential(new AutonomousGearOC(false)); //Tell the subsystem to drop the gear

        addSequential(new AutonomousDriveRobot(0.2, 0.2));
        addSequential(new WaitCommand(2));
        addSequential(new AutonomousDriveRobot(0, 0));

    }
}