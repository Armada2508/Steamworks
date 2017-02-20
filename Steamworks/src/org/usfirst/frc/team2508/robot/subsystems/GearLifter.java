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
	Solenoid solenoid;
	
	public GearLifter() {
		solenoid = new Solenoid(0);
	}
	
	public void initDefaultCommand() {}
	
	public void set(boolean state) {
    	solenoid.set(state);
	}
}
