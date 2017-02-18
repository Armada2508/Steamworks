package org.usfirst.frc.team2508.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGripper extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	DoubleSolenoid solenoid;
	
	public GearGripper() {
		solenoid = new DoubleSolenoid(1, 2);
	}
	
	public void initDefaultCommand() {}
	
	public void set(boolean state) {
    	solenoid.set(state ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}
}
