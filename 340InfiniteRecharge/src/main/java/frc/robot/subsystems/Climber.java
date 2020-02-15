/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    private static TalonSRX leftArm , rightArm;
  /**
   * Creates a new Climber.
   */
  public Climber() {
        leftArm = new TalonSRX(Constants.CLIMBER_LEFT_ARM);
        rightArm = new TalonSRX(Constants.CLIMBER_RIGHT_ARM);

        // rightArm.set(ControlMode.Follower, Constants.CLIMBER_LEFT_ARM);
        // rightArm.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb() {
    leftArm.set(ControlMode.PercentOutput, .8);
    rightArm.set(ControlMode.PercentOutput, .8);
  }

  public void descend() {
    leftArm.set(ControlMode.PercentOutput, -.8);
    rightArm.set(ControlMode.PercentOutput, -.8);
  }

  public void stop() {
    leftArm.set(ControlMode.PercentOutput, 0);
    rightArm.set(ControlMode.PercentOutput, 0);
  }

  public void leftDown() {
    leftArm.set(ControlMode.PercentOutput, -.8);
    rightArm.set(ControlMode.PercentOutput, 0);
  }

  public void rightDown() {
    leftArm.set(ControlMode.PercentOutput, 0);
    rightArm.set(ControlMode.PercentOutput, -.8);

  }
  
}
