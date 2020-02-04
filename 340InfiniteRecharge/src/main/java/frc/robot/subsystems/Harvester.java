/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Harvester extends SubsystemBase {
  private CANSparkMax axleWheels;
  private Solenoid harvesterPneu;

  /**
   * Creates a new Intake.
   */
  public Harvester() {
    axleWheels = new CANSparkMax(Constants.INTAKE_AXLE, MotorType.kBrushless);
    harvesterPneu = new Solenoid(1);
  }

  public void setAxleWheels(double speed) {
    axleWheels.set(speed);
  }

  public void lowerHarvester(){
    harvesterPneu.set(true);
  }

  public void raiseHarvester(){
    harvesterPneu.set(false);
  }


}
