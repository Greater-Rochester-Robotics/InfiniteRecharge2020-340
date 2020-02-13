/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotContainer.Axis;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  public Limelight() {

  }

  public void periodic(){
    getDistance();
  }
  public void setPipeline(int Pipeline){
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(Pipeline);
  }
  
  public void setCammode(int Cammode){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(Cammode);
  }

  public void setLightState(int LightState){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(LightState);  //controls if limelight is on or not
  }

  public boolean haveTarget(){
    return (NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1); //returns true if it detects a target
  }

  public double angleToTarget(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0); //returns the angle offset (+ is left of target, - is right of target)
  }

  public double verticalAngleToTarget(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0); //returns the vertical angle offset
  }

  public static int calcHoodShot(){
    //distance equation: rpm = -0.00004x^3 -33.771x + 4919
    // double rpm = -0.00004*Math.pow(getDistance(), 3) - 33.771*getDistance() +4919;
    double rpm = 0.0;
    SmartDashboard.putString("Expected Rpm", ""+rpm);
    return (int) rpm;
  }

  public double getDistance(){
    //TODO: find actual values for these, and implement/test them
    //all distance values are in inches
    double cameraHeight =  25.5;    //not final value
    double targetHeight = 98; //final value = 98.25
    double cameraAngle = 32.1;    //changeable
    double Distance = ((targetHeight - cameraHeight) / Math.tan(Math.toRadians(cameraAngle + RobotContainer.limelight.verticalAngleToTarget())))-12.5; // Returns distance to target, 12.5 is distance camera is from front? of robot
    // System.out.println("Math = " + Math.tan( Math.toRadians(cameraAngle + RobotContainer.limelight.verticalAngleToTarget()) ) +"   distance = " + Distance);
    SmartDashboard.putString("Distance", ""+Distance);
    // System.out.println(Distance);
    return Distance;
    //d = (h2-h1) / tan(a1+a2)
    //h2 = height of target above floor
    //h1 = height of camera above floorh 
    //a1 = angle of camera (angle from line parallel to floor)
    //a2 = angle to target (vertical)
    //d = distance to target
  }



}
