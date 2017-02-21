package org.usfirst.frc.team2508.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSystem extends Subsystem {
	Solenoid GearLiftSolenoid = new Solenoid(0);
	DoubleSolenoid GearPickSolenoid = new DoubleSolenoid(1, 2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void GearLift (boolean GearLiftStatus) {
    	if (GearLiftStatus) {
    		GearLiftSolenoid.set(true);
    	} else {
    		GearLiftSolenoid.set(false);
    	}
    }
    public void GearPick(boolean GearPickStatus) {
    	if (GearPickStatus) {
    		GearPickSolenoid.set(DoubleSolenoid.Value.kReverse);
    	} else {
    		GearPickSolenoid.set(DoubleSolenoid.Value.kForward);
    	}
    }
}

