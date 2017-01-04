package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class PrecisionGTADrive extends Command {

    public PrecisionGTADrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.precisionActive = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double rightTrigger = Robot.oi.driverAxisValue(RobotMap.Controller1_Right_Trigger);
    	double leftTrigger = Robot.oi.driverAxisValue(RobotMap.Controller1_Left_Trigger);
    	double leftJoystickXAxis = Robot.oi.driverAxisValue(RobotMap.Controller1_Left_X_Axis);
    	   
    	//Creating motor variables
    	double leftMotors = (rightTrigger - leftTrigger - leftJoystickXAxis)*RobotMap.GTA_Drive_Precision_Scaling_Teleop;
    	double rightMotors = (rightTrigger - leftTrigger + leftJoystickXAxis)*RobotMap.GTA_Drive_Precision_Scaling_Teleop*(-1);
    	
    	
    	Robot.driveTrain.setLeft(leftMotors);
    	Robot.driveTrain.setRight(rightMotors);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.precisionActive = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.precisionActive = false;
    }
}
