
package org.usfirst.frc.team2508.robot;

import org.usfirst.frc.team2508.robot.commands.*;

import org.usfirst.frc.team2508.robot.subsystems.GearLifter;
import org.usfirst.frc.team2508.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2508.robot.subsystems.GearGripper;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2508.robot.commands.DriveRobot;
import org.usfirst.frc.team2508.robot.commands.GearLG;
import org.usfirst.frc.team2508.robot.commands.Winch;
import org.usfirst.frc.team2508.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2508.robot.subsystems.GearSystem;
import org.usfirst.frc.team2508.robot.subsystems.AutoOutputs;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveSystem DriveSystem = new DriveSystem();
	public static final GearSystem GearSystem = new GearSystem();
	public static final AutoOutputs AutoOutputs = new AutoOutputs();
	
	public static OI oi;

	public static final Compressor mainCompressor = new Compressor(0);

	Command autonomousCommand;
	SendableChooser chooser = new SendableChooser();
	private final String leftSide = "Left Side Auto";
	private final String center = "Center Auto";


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		
		SmartDashboard.putData("Auto mode", chooser);
    	mainCompressor.setClosedLoopControl(true);
    	//CameraServer.getInstance().startAutomaticCapture();
		}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
//		if(chooser.getSelected() == leftSide) {
//			autonomousCommand = new Autonomous();
//		}
//		switch ((int) chooser.getSelected()) {
//			case 1 :
//				autonomousCommand = new AutonomousLeftSide();
//				break;
//			case 2 :
//				autonomousCommand = new AutonomousCenter();
//				break;
//			default :
//				System.out.println("Invalid Autonomous State: " + chooser.getSelected());
//		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		
		//Robot.AutoOutputs.aOutputs(gearLift, gearPick, wPowerL, wPowerR);
		Robot.AutoOutputs.aOutputs(false, true, 0, 0);
		System.out.println("1 okay");
		Timer.delay(.8);
		Robot.AutoOutputs.aOutputs(true, true, 0, 0);
		System.out.println("1 okay");
		Timer.delay(.8);
		if(false){ //doMiddleGear
			Robot.AutoOutputs.aOutputs(true, true, .3, .3);
			System.out.println("2 okay");
			Timer.delay(1.9);
	//		Robot.AutoOutputs.aOutputs(true, true, 0, .3);
	//		System.out.println("3 okay");
	//		Timer.delay(2);
	//		Robot.AutoOutputs.aOutputs(true, true, .2, .2);
	//		Timer.delay(3);
		}else{
			Robot.AutoOutputs.aOutputs(true, true, .3, .3);
			System.out.println("2 okay");
			Timer.delay(2.2);
			Robot.AutoOutputs.aOutputs(true, true, -.3, .3);
			Timer.delay(0.45);
			Robot.AutoOutputs.aOutputs(true, true, .3, .3);
			Timer.delay(1.50);
		}
		Robot.AutoOutputs.aOutputs(true, true, 0, 0);
		Timer.delay(1.5);
		Robot.AutoOutputs.aOutputs(true, false, 0, 0);
		Timer.delay(1);
		Robot.AutoOutputs.aOutputs(false, false, 0, 0);
		Timer.delay(.5);
//		Robot.AutoOutputs.aOutputs(false, false, -.5, -.5);
//		Timer.delay(0.2);
//		Robot.AutoOutputs.aOutputs(false, false, 0, 0);
	}
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Command driveRobotCMD = new DriveRobot();
		driveRobotCMD.start();
		Command winchCMD = new Winch();
		winchCMD.start();
		Command GearLGCMD = new GearLG();
		GearLGCMD.start();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
