package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoOutputs extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void aOutputs(boolean gearLift, boolean gearPick, double wPowerL, double wPowerR){
    	Robot.DriveSystem.drive(-wPowerL, -wPowerR);
    	Robot.GearSystem.GearLift(gearLift);
    	Robot.GearSystem.GearPick(gearPick);
    	
    }
}

