package org.usfirst.frc.team6351.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static final double Tank_Drive_Scaling_Teleop = 0.4;
	public static final double Drive_Scaling_Auto = 0.4;
	public static final double Tank_Drive_Precision_Scaling_Teleop = 0.2;
	
	public static final double GTA_Drive_Scaling_Teleop = 0.4;
	public static final double GTA_Drive_Precision_Scaling_Teleop = 0.2;
	
	public static final int Motor_Front_Left = 1;
	public static final int Motor_Back_Left = 2;
	public static final int Motor_Front_Right = 3;
	public static final int Motor_Back_Right = 4;
	
	public static final int Solenoid_1 = 4;
	public static final int Solenoid_2 = 3;

	public static final int Controller1_Left_Y_Axis = 1;
	public static final int Controller1_Right_Y_Axis = 5;
	
	public static final int Controller1_Left_X_Axis = 0;
	public static final int Controller1_Right_X_Axis = 4;
	
	public static final int Controller1_Right_Trigger = 3;
	public static final int Controller1_Left_Trigger = 2;
	
	public static final int Controller1_Right_Bumper = 6;
	public static final int Controller1_Left_Bumper = 5;

	public static final int Controller1_A_Button = 1;
	public static final int Controller1_B_Button = 2;
	public static final int Controller1_X_Button = 3;
	public static final int Controller1_Y_Button = 4;
	
	public static final double TELEOP_MAX_ROBOT_SPEED = 0.99;
	public static final double TELEOP_MIN_ROBOT_SPEED = -0.99;
	
	public static final int IMG_WIDTH = 640;
	public static final int IMG_HEIGHT = 480;
}
