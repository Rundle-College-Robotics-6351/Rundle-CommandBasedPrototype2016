
package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.RobotMap;
import org.usfirst.frc.team6351.robot.commands.GTADrive;
import org.usfirst.frc.team6351.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Left Motors
    Victor frontLeft = new Victor(RobotMap.Motor_Front_Left);
    Victor backLeft = new Victor(RobotMap.Motor_Back_Left);
    //Right Motors
    Victor frontRight = new Victor(RobotMap.Motor_Front_Right);
    Victor backRight = new Victor(RobotMap.Motor_Back_Right);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GTADrive());
    }
    public void setLeft (double speed) {
    	frontLeft.set(speed);
    	backLeft.set(speed);
    	
    }
    public void setRight (double speed) {
    	frontRight.set(speed);
    	backRight.set(speed);
    	
    }
}

