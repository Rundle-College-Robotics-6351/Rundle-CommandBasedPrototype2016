
package org.usfirst.frc.team6351.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team6351.robot.commands.AutoFwdSpinComeBack;
import org.usfirst.frc.team6351.robot.commands.TankDrive;
import org.usfirst.frc.team6351.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6351.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team6351.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static OI oi;

    Command autonomousStart;
    Command teleopStart;
    SendableChooser autoMode;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		autoMode = new SendableChooser();
		autoMode.addDefault("ForwardSpinComeBack", new AutoFwdSpinComeBack());
        SmartDashboard.putData("Auto mode", autoMode);
        pneumatics.start();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autonomousStart = (Command) autoMode.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousStart != null) autonomousStart.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousStart != null) autonomousStart.cancel();
        
        teleopStart = new TankDrive();
        teleopStart.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left Joystick Y", oi.driver1.getRawAxis(1));
        SmartDashboard.putNumber("Right Joystick Y", oi.driver1.getRawAxis(3));
        
        SmartDashboard.putBoolean("Compressor Enabled", pneumatics.getEnabled());
        SmartDashboard.putBoolean("Compressor Not Connected Fault", pneumatics.getConnectionFault());
        SmartDashboard.putBoolean("Compressor Current Fault", pneumatics.getCurrentFault());
        SmartDashboard.putBoolean("Compressor Shorted Fault", pneumatics.getShortFault());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
