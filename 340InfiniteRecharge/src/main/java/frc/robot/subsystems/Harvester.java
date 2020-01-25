/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Harvester extends SubsystemBase {
  private CANSparkMax leftAxleWheels, rightAxleWheels;
  private DigitalInput leftSensor, rightSensor;

  /**
   * Creates a new Intake.
   */
  public Harvester() {
    rightAxleWheels = new CANSparkMax(Constants.INTAKE_RIGHT_AXLE, MotorType.kBrushless);
    leftAxleWheels = new CANSparkMax(Constants.INTAKE_LEFT_AXLE, MotorType.kBrushless);
    leftSensor = new DigitalInput(5);
    rightSensor = new DigitalInput(6);
    rightAxleWheels.setInverted(true);
  }

  public void setRightAxleWheel(double speed){
      rightAxleWheels.set(speed);
  }
  public void setLeftAxleWheel(double speed){
    leftAxleWheels.set(speed);
  }
  public boolean isRightSensorTripped(){
    return rightSensor.get();
  }
  public boolean isLeftSensorTripped(){
    return leftSensor.get();
  }

}
