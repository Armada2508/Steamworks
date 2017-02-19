package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
public class Autonomous extends CommandGroup {
    public Autonomous() {
        addSequential(new AutonomousGearOC(true)); //Tell the subsystem to grip the gear
        addSequential(new AutonomousGearLifter(true)); //Tell the subsystem to lift the gear
        addSequential(new AutonomousDriveRobot(-0.2, -0.2));// left speed, right speed
        addSequential(new WaitCommand(10));
        addSequential(new AutonomousDriveRobot(0, 0));
        //Turn
        //Drive forward
    }
}