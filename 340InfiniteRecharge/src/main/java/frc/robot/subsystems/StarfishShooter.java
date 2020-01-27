/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class StarfishShooter extends SubsystemBase {
  private static CANSparkMax starShooter, starLoader;
  // private DigitalInput 
  /**
   * Creates a new StarfishShooter.
   */
  public StarfishShooter() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
