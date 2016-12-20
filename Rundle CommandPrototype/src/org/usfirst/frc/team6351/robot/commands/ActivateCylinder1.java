package org.usfirst.frc.team6351.robot.commands;

import org.usfirst.frc.team6351.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;
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

public class ActivateCylinder1 extends Command {

	Solenoid s1;
	String operation;
	
    public ActivateCylinder1 (Solenoid funcS1, String operationString) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.pneumatics);
        
        s1 = funcS1;
        operation = operationString;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (operation == "extend") {
    		s1.set(true);
    	} else if (operation == "retract") {
    		s1.set(false);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
