
package org.usfirst.frc.team2508.robot;

import org.usfirst.frc.team2508.robot.commands.*;

import org.usfirst.frc.team2508.robot.subsystems.GearLifter;
import org.usfirst.frc.team2508.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2508.robot.subsystems.GearGripper;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//TODO: Remove all the example stuff
	public static final DriveSystem driveSystem = new DriveSystem();
	public static final GearGripper gearGripper = new GearGripper();
	public static final GearLifter gearLifter = new GearLifter();
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
		chooser.addDefault(leftSide, 1);
		chooser.addDefault(center, 2);
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
		switch ((int) chooser.getSelected()) {
			case 1 :
				autonomousCommand = new AutonomousLeftSide();
				break;
			case 2 :
				autonomousCommand = new AutonomousCenter();
				break;
			default :
				System.out.println("Invalid Autonomous State: " + chooser.getSelected());
		}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	public void aControl(boolean grip, boolean lift, double wheelLeft, double wheelRight) {
		// new gear grabber
		//Command gearPick = new GearOC();
		// new gear lifter
		Command gearLift = new org.usfirst.frc.team2508.robot.commands.GearLifter();
		// picks up gear
		if (grip) {
			// picks up gear
			//gearPick.start();
		} else {
			// releases gear
			//gearPick.cancel();
		}
		if (lift) {
			// lifts gear
			gearLift.start();
		} else {
			// drops gear lift
			gearLift.cancel();
		}

		Robot.driveSystem.drive(wheelLeft,wheelRight);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
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
