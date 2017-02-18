package org.usfirst.frc.team2508.robot.commands;

import org.usfirst.frc.team2508.robot.Robot;
import org.usfirst.frc.team2508.robot.subsystems.GearGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class Autonomous extends CommandGroup {
    public Autonomous() {
    	GearGripper gearGripper = new GearGripper();
    	
    	boolean finishedLifting = false;
    	boolean finishedGripping = false;
        addSequential(new AutonomousGearOC(gearGripper, finishedGripping));
        addParallel(new AutonomousGearLifter(finishedLifting));
        addParallel(new AutonomousDriveRobot(10, 0.2));
        //Turn
        //Drive forward
        finishedGripping = true;
        finishedLifting = true;
        
    }
}