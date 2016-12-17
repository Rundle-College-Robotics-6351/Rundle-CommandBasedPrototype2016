
package org.usfirst.frc.team6351.robot.subsystems;

import org.usfirst.frc.team6351.robot.commands.BeginDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Left Motors
    Victor frontLeft = new Victor(1);
    Victor backLeft = new Victor(2);
    //Right Motors
    Victor frontRight = new Victor(3);
    Victor backRight = new Victor(4);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BeginDrive());
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

