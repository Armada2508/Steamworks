package org.usfirst.frc.team2508.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2508.robot.commands.*;
//import org.usfirst.frc.team2508.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	public Joystick stick = new Joystick(0);
	// Talon for the Ball picker upper thing
	public CANTalon ballRunner = new CANTalon(2);
	public Button a = new JoystickButton(stick, 1);
	Button b = new JoystickButton(stick, 2);
	public Button x = new JoystickButton(stick, 3);
	Button y = new JoystickButton(stick, 4);
	Button lb = new JoystickButton(stick, 5);
	Button rb = new JoystickButton(stick, 6);
	public Button back = new JoystickButton(stick, 7);
	public Button start = new JoystickButton(stick, 8);
	Button l3 = new JoystickButton(stick, 9);
	Button r3 = new JoystickButton(stick, 10);
	double lX = stick.getRawAxis(0);
	public double lY = stick.getRawAxis(1);
	double lTrigger = stick.getRawAxis(2);
	double rTrigger = stick.getRawAxis(3);
	double rX = stick.getRawAxis(4);
	public double rY = stick.getRawAxis(5);
	int d_pad = stick.getPOV();


	public OI() {
		x.toggleWhenPressed(new GearOC());
		a.toggleWhenPressed(new BallPickerUpper());
	}
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}