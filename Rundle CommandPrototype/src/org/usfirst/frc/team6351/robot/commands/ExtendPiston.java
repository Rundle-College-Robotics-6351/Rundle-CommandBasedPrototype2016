
package org.usfirst.frc.team6351.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6351.robot.Robot;

/**
 *
 */
public class ExtendPiston extends Command {

	Solenoid s1;
	Solenoid s2;
	
    public ExtendPiston(Solenoid funcS1) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneumatics);
        
        s1 = funcS1;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	s1.set(true);
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
