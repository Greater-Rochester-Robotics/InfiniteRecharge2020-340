/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Harvester extends SubsystemBase {
  private CANSparkMax axleWheels;
  private DoubleSolenoid harvesterPneu;

  /**
   * Creates a new Intake.
   */
  public Harvester() {
    axleWheels = new CANSparkMax(Constants.INTAKE_AXLE, MotorType.kBrushless);
    harvesterPneu = new DoubleSolenoid(0,1);
  }

  public void setAxleWheels(double volts) {
    axleWheels.setVoltage(volts);
  }

  public void lowerHarvester(){
    RobotContainer.limelight.setStreamMode(2);
    harvesterPneu.set(Value.kForward);
  }

  public void raiseHarvester(){
    harvesterPneu.set(Value.kReverse);
  }


}
