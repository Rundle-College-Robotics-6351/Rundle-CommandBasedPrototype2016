
package org.usfirst.frc.team6351.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6351.robot.Robot;
import org.usfirst.frc.team6351.robot.RobotMap;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.driverAxisValue(RobotMap.Joystick_Left_Y_Axis)*(RobotMap.Tank_Drive_Scaling_Teleop)*(-1);
    	double rightSpeed = Robot.oi.driverAxisValue(RobotMap.Joystick_Right_Y_Axis)*(RobotMap.Tank_Drive_Scaling_Teleop);
    	
    	Robot.driveTrain.setLeft(leftSpeed);
    	Robot.driveTrain.setLeft(rightSpeed);
    	
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
