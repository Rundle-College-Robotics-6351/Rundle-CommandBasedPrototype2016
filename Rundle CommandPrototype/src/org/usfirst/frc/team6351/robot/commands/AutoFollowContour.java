package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

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

public class AutoFollowContour extends Command {

	double xPosition;
	double centerX = 320;
	
    public AutoFollowContour() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	xPosition = Robot.centerX;
    	
    	double distance = centerX - xPosition;
    
    	if (xPosition != 0) {
    		if (distance < 0.0 && distance > -160) {
        		Robot.driveTrain.setLeft(-0.1);
        		Robot.driveTrain.setRight(-0.1);
        	} 
        	if (distance < 0.0 && distance < -160) {
        		Robot.driveTrain.setLeft(-0.3);
        		Robot.driveTrain.setRight(-0.3);
        	}
        	if (distance > 0.0 && distance < 160) {
        		Robot.driveTrain.setLeft(0.1);
        		Robot.driveTrain.setRight(0.1);
        	} 
        	if (distance > 0.0 && distance > 160) {
        		Robot.driveTrain.setLeft(0.3);
        		Robot.driveTrain.setRight(0.3);
        	}
        	
        	if (distance >= -5 && distance <= 5) {
        		Robot.driveTrain.setLeft(0);
        		Robot.driveTrain.setRight(0);
        	}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
