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

public class ActivateBothCylinders extends Command {

	boolean op1;
	boolean op2;
	
    public ActivateBothCylinders(boolean opFor1, boolean opFor2) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    	
    	op1 = opFor1;
    	op2 = opFor2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.pneumatics.activateCylinder(Robot.pneumatics.s1, op1);
    		Robot.pneumatics.activateCylinder(Robot.pneumatics.s2, op2);
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
