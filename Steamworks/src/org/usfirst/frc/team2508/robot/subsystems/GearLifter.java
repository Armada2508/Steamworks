package org.usfirst.frc.team2508.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearLifter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	DoubleSolenoid solenoid;
	
	public GearLifter() {
		solenoid = new DoubleSolenoid(0, 3);
	}
	
	public void initDefaultCommand() {}
	
	public void set(boolean state) {
    	solenoid.set(state ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
	}
}
