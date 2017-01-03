
package org.usfirst.frc.team6351.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team6351.robot.commands.AutoFollowContour;
import org.usfirst.frc.team6351.robot.commands.AutoFwdSpinComeBack;
import org.usfirst.frc.team6351.robot.commands.AutoTestMovement;
import org.usfirst.frc.team6351.robot.commands.GTADrive;
import org.usfirst.frc.team6351.robot.commands.TankDrive;
import org.usfirst.frc.team6351.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6351.robot.subsystems.Pneumatics;
import org.usfirst.frc.team6351.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

/**
 * Rundle College Team 6351, 2016
 * Code for Prototype Robot
 * Programmed in Java by Davis Carlson and Max Gilmour
 * 
 */

public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Sensors sensors = new Sensors();
	public static OI oi;

    Command autonomousStart;
    Command teleopStart;
    SendableChooser autoMode;
    
	public static double centerYContour;
	public static double centerXContour;
	NetworkTable GRIPContourReport = NetworkTable.getTable("GRIP/blueSquare");

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//System.load("/usr/local/lib/lib_OpenCV/java/opencv_java2410.so");
		oi = new OI();
		autoMode = new SendableChooser();
		autoMode.addDefault("Auto: ForwardSpinReturn", new AutoFwdSpinComeBack());
		autoMode.addObject("Auto: Follow GRIP Contour (Shape)", new AutoFollowContour());
		autoMode.addObject("Auto: TEST MODE", new AutoTestMovement());
        SmartDashboard.putData("Auto mode", autoMode);
        pneumatics.start();
        //sensors.gyro.calibrate();
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
    	
    	getGRIP();
    	
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousStart != null) autonomousStart.cancel();
        
        teleopStart = new GTADrive(); 
        teleopStart.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Compressor Enabled", pneumatics.getEnabled());
        SmartDashboard.putBoolean("Compressor Not Connected Fault", pneumatics.getConnectionFault());
        SmartDashboard.putBoolean("Compressor Current Fault", pneumatics.getCurrentFault());
        SmartDashboard.putBoolean("Compressor Shorted Fault", pneumatics.getShortFault());
        
        SmartDashboard.putNumber("Left Joystick Y", oi.driver1.getRawAxis(1));
        SmartDashboard.putNumber("Right Joystick Y", oi.driver1.getRawAxis(3));
        SmartDashboard.putBoolean("Precision Mode Active", oi.driverLeftBumper.get());
        
        SmartDashboard.putNumber("GyroAngle", sensors.getGyroAngle());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void getGRIP() {
    	
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	double[] widthValue = new double[0];
    	
    	int widthPos = 0;
    	double[] dataArrayY = GRIPContourReport.getNumberArray("centerY", yValue);
    	double[] dataArrayX = GRIPContourReport.getNumberArray("centerX", xValue);
    	double[] dataArrayWidth = GRIPContourReport.getNumberArray("width", widthValue);
    	
    	for(int i = 0; i < dataArrayWidth.length; i++){
    		if(dataArrayWidth[i] > dataArrayWidth[widthPos]){
    			widthPos = i;
    		}
    	}
    	//single double
        if (dataArrayY.length > widthPos) {	
    		centerYContour = dataArrayY[widthPos];
        }
    	//single double
        if (dataArrayX.length > widthPos){
        	centerXContour = dataArrayX[widthPos];
        }
    		
		//Showing the value of centerY on the smart dashboard
		SmartDashboard.putNumber("The value of centerY is ", centerYContour);
		
		//Showing the value of centerX on the smart dashboard
		SmartDashboard.putNumber("The value of centerX is ", centerXContour);
    }
}
