package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class Autonomous extends CommandGroup {
    public Autonomous() {
        addSequential(new AutonomousGearOC(true)); //Tell the subsystem to grip the gear
        addParallel(new AutonomousGearLifter(true)); //Tell the subsystem to lift the gear
        addParallel(new AutonomousDriveRobot(10, 0.2));// Time, speed
        //Turn
        //Drive forward
        
    }
}