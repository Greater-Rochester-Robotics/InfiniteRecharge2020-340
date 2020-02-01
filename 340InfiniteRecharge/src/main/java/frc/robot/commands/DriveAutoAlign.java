/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotContainer.Axis;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAutoAlign extends CommandBase {
	
	double hadTarget = 0;

	public DriveAutoAlign() {
		addRequirements (RobotContainer.drive);
		/**
		 * step 1: left trigger is pressed
		 * step 2: robot uses data from limelight to drive forward and adjust as needed
		 * setp 3: stops when trigger is released or in position to score
		 */

	  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
	  //turn on limelight, make sure leds are on 
	  //get starting point (or set)
	  //set pipeline as zeor woowo
	  //add as needed
	  System.out.println("DriveAutoAlign Started");
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0); //set pipeline to zero
	 
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //makes sure that its in robot looks around mode

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //turns on limelight led boi
	//  RobotContainer.drive.setLEDs(true); // also turn on PCM LEDs
	  // drive forward constnagt slow speed 
	  // adjust angle robot is at as needed
	  double haveTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
	  double angleToTarget=NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
	  if(haveTarget == 0 && hadTarget == 0) {
		//Rumble soft if NO target
		Robot.robotContainer.setDriverRumble(0.7, 0);
		
		//Allow driver control and drive until target discovered
		if(Math.abs(Robot.robotContainer.getDriverAxis(Axis.LEFT_X)) >= .05 ||
			Math.abs(Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)) >= .05) {
				RobotContainer.drive.arcadeDrive(Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)*.65, Robot.robotContainer.getDriverAxis(Axis.LEFT_X)*.7569);
		} else if(Math.abs(Robot.robotContainer.getDriverAxis(Axis.RIGHT_X)) >= .15 ||
			Math.abs(Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
				RobotContainer.drive.arcadeDrive(Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)*.3, Robot.robotContainer.getDriverAxis(Axis.RIGHT_X)*.45);
		} else {
			RobotContainer.drive.setDriveBoth(0);
		}
	  } else { 
		//Stop rumble if there is a target
		Robot.robotContainer.setDriverRumble(0, 0);
		
		// //get forward speed from driver
		double moveValue=0;//-.2;
		if(	Math.abs(Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)) >= .05) {
			moveValue = Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)*.4;
		} else if(Math.abs(Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
			moveValue = Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)*.3;
		}
		
		double rotateValue=0;
		// write a function for rotateValue, so that it is driven by angleToTarget
		if (Math.abs(angleToTarget) < .5){
			rotateValue = 0;
		}else{
			double variable = .5;
			//finds the speed we want to move in proportion to how far away we are from the target, modify the variable value to vary the
			//speed and accuracy at which the limelight finds the target 
			rotateValue = (((angleToTarget)/35)*(moveValue+.45)) * variable; 
			System.out.println(rotateValue);
		}
		
		double rightSpeed = moveValue + rotateValue;
		double leftSpeed = moveValue - rotateValue;
		// System.out.println("Right speed: " +rightSpeed);
		// System.out.println("Left speed: " +leftSpeed);
		RobotContainer.drive.setDriveLeft(leftSpeed);
		RobotContainer.drive.setDriveRight(rightSpeed);
		

	  }
	  hadTarget = haveTarget;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean isFinished) { 
	  System.out.println("DriveAutoAlign Ended");
	Robot.robotContainer.setDriverRumble(0, 0);
	
	//return visual to driver camera if autonomous
	if(DriverStation.getInstance().isAutonomous()){
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
	}
	  //when right trigger is released
	  //or when ready to score
	  //turn off led (no blindness please)

	NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //turns off limelight led boi
	// RobotContainer.drive.setLEDs(false); //also turn off PCM LEDs
  }
}