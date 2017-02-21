package org.usfirst.frc.team2508.robot.subsystems;

import org.usfirst.frc.team2508.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

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
		
		initTalonSet(upperLeftTalon, lowerLeftTalon);
		initTalonSet(upperRightTalon, lowerRightTalon);
		
		upperRightTalon.reverseOutput(true);
		upperLeftTalon.reverseSensor(true);
		upperLeftTalon.reverseOutput(false);
		upperRightTalon.reverseSensor(false);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		
	}
	public void initTalonSet(CANTalon mainTalon, CANTalon followerTalon){
		mainTalon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		mainTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		mainTalon.configPeakOutputVoltage(+12.0f, -12.0f);
		mainTalon.changeControlMode(TalonControlMode.Speed);
		mainTalon.setProfile(0);
		mainTalon.set(0);
		
		mainTalon.setP(0.5);
		mainTalon.setI(0.002); 
		mainTalon.setD(0);
		mainTalon.setF(0);
		mainTalon.setCloseLoopRampRate(0.5);
    	
		followerTalon.changeControlMode(TalonControlMode.Follower);
		followerTalon.set(mainTalon.getDeviceID());		
	}
	public void drive(double powerL, double powerR){
		upperLeftTalon.set(processDeadband(powerL));
		upperRightTalon.set(processDeadband(powerR));
	}
	
	private double processDeadband(double input){
		double output;
		
		if(Math.abs(input)< RobotMap.DeadbandThreshold){
			output = 0;
		}
		
		else {
			output = input * RobotMap.MaxDriveRPM;
		}
		return output;
	}
}
