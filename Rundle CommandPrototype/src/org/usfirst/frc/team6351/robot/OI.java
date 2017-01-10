package org.usfirst.frc.team6351.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team6351.robot.commands.ActivateBothCylinders;
import org.usfirst.frc.team6351.robot.commands.PrecisionGTADrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class OI {
	public Joystick driver1 = new Joystick(0);
	public Joystick joystick1 = new Joystick(1);
	
	public Button driverA = new JoystickButton(driver1, RobotMap.Controller1_A_Button);
	public Button driverB = new JoystickButton(driver1, RobotMap.Controller1_B_Button);
	public Button driverX = new JoystickButton(driver1, RobotMap.Controller1_X_Button);
	public Button driverY = new JoystickButton(driver1, RobotMap.Controller1_Y_Button);
	
	public Button driverLeftBumper = new JoystickButton(driver1, RobotMap.Controller1_Left_Bumper);
	
	public Button joystick11 = new JoystickButton(joystick1, RobotMap.Joy_Button_11);
	public Button joystick12 = new JoystickButton(joystick1, RobotMap.Joy_Button_12);
	
	public OI() {

		//driverA.whenPressed(new ExtendPiston());
		//driverB.whenPressed(new RetractPiston());
		
//		driverA.whenPressed(new ActivateBothCylinders(true, true));
//		driverB.whenPressed(new ActivateBothCylinders(false, false));
		
		joystick11.whenPressed(new ActivateBothCylinders(true, true));
		joystick12.whenPressed(new ActivateBothCylinders(false, false));
		
		driverLeftBumper.toggleWhenPressed(new PrecisionGTADrive());
		
	}
	//Method for getting an axis value on the driver joystick
		public double driverAxisValue (int axis) {
			
			//return driver1.getRawAxis(axis);
			return joystick1.getRawAxis(axis);
			
		}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

