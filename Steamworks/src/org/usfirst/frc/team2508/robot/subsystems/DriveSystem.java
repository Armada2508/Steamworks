package org.usfirst.frc.team2508.robot.subsystems;

//import org.usfirst.frc.team2508.robot.Robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	
	public CANTalon upperLeftTalon = new CANTalon(0);
	public CANTalon lowerLeftTalon = new CANTalon(1);
	public CANTalon upperRightTalon = new CANTalon(3);
	public CANTalon lowerRightTalon = new CANTalon(4);
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void leftSideControll(double power){
		upperLeftTalon.set(power);
		
    	upperLeftTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	upperLeftTalon.reverseSensor(false);
    	upperLeftTalon.configNominalOutputVoltage(+0.0f, -0.0f);
    	upperLeftTalon.configPeakOutputVoltage(+12.0f, -12.0f);
    	upperLeftTalon.setProfile(0);
    	upperLeftTalon.setF(0.1097);
    	upperLeftTalon.setP(5);
    	upperLeftTalon.setI(1); 
    	upperLeftTalon.setD(0.2);
    	lowerLeftTalon.changeControlMode(TalonControlMode.Follower);
    	lowerLeftTalon.set(0);
	}
	public void rightSideControll(double power){
		upperRightTalon.set(-power);
		
    	upperRightTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	upperRightTalon.reverseSensor(false);
    	upperRightTalon.configNominalOutputVoltage(+0.0f, -0.0f);
    	upperRightTalon.configPeakOutputVoltage(+12.0f, -12.0f);
    	upperRightTalon.setProfile(0);
    	upperRightTalon.setF(0.1097);
    	upperRightTalon.setP(5);
    	upperRightTalon.setI(1); 
    	upperRightTalon.setD(0.2);
    	lowerRightTalon.changeControlMode(TalonControlMode.Follower);
    	lowerRightTalon.set(3);
	}
	public void drive(double powerL, double powerR){
			leftSideControll(powerL);
			rightSideControll(powerR);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
