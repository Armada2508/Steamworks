package org.usfirst.frc.team2508.robot.subsystems;

import java.util.TimerTask;
import java.util.Timer;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	
	public CANTalon upperLeftTalon;
	public CANTalon lowerLeftTalon;
	public CANTalon upperRightTalon;
	public CANTalon lowerRightTalon;
	
	public DriveSystem(){
		upperLeftTalon = new CANTalon(0);
		lowerLeftTalon = new CANTalon(1);
		upperRightTalon = new CANTalon(3);
		lowerRightTalon = new CANTalon(4);
		initTalonSet(upperLeftTalon, lowerLeftTalon, 0, 0);
		initTalonSet(upperRightTalon, lowerRightTalon, 3, 1);
	}
	

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initTalonSet(CANTalon mainTalon, CANTalon followerTalon, int mainProfile, int CANSpeedID){
//		mainTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
//		mainTalon.reverseSensor(false);
//		mainTalon.configNominalOutputVoltage(+0.0f, -0.0f);
//		mainTalon.configPeakOutputVoltage(+12.0f, -12.0f);
//		mainTalon.setProfile(CANSpeedID);
//		//mainTalon.setF(0.1097);
//		mainTalon.setP(.8);
//		mainTalon.setI(.01); 
//		mainTalon.setD(0);
    	
		followerTalon.changeControlMode(TalonControlMode.Follower);
		followerTalon.set(mainProfile);		
	}
	public void drive(double powerL, double powerR){
		upperLeftTalon.set(powerL);
		upperRightTalon.set(-powerR);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}
