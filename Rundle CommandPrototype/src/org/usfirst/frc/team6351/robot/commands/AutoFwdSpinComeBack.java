
package org.usfirst.frc.team6351.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

/**
 *
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class AutoFwdSpinComeBack extends Command {

    public AutoFwdSpinComeBack() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto*-1);
    	Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto);
		Timer.delay(2);
    	Robot.driveTrain.setLeft(0);
    	Robot.driveTrain.setRight(0);
		//Spin 180
    	Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto);
    	Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto);
		Timer.delay(1);
    	Robot.driveTrain.setLeft(0);
    	Robot.driveTrain.setRight(0);
		//Come Back
    	Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto*-1);
    	Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto);
		Timer.delay(2);
    	Robot.driveTrain.setLeft(0);
    	Robot.driveTrain.setRight(0);
		//Spin 180
    	Robot.driveTrain.setLeft(RobotMap.Drive_Scaling_Auto);
    	Robot.driveTrain.setRight(RobotMap.Drive_Scaling_Auto);
		Timer.delay(1);
    	Robot.driveTrain.setLeft(0);
    	Robot.driveTrain.setRight(0);
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
    	Robot.driveTrain.setLeft(0);
    	Robot.driveTrain.setRight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
