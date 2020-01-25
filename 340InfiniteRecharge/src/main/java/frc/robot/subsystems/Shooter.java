/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//PROTOTYPE

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;
import com.revrobotics.EncoderType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase {

  private static CANSparkMax shooterWheel;
  private CANEncoder shooterEncoder;
  private double targetVelocity;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooterWheel = new CANSparkMax(Constants.SNEKSHOOTER_SPARK_LAUNCHER, MotorType.kBrushless);
    shooterWheel.getPIDController().setP(0.0001);
    shooterWheel.getPIDController().setI(0.0);
    shooterWheel.getPIDController().setD(0.00005);
    shooterWheel.getPIDController().setFF(0.000174);
    shooterWheel.setInverted(true);
    shooterEncoder = shooterWheel.getEncoder(EncoderType.kHallSensor, 42);
  }

  // Returns RPM of shooterWheel
  public double getShooterVelocity() {
    return shooterEncoder.getVelocity();
  }

  public void setShooterWheel(double speed) {
    // if (speed < -1) {
    // speed = -1;
    // } else if (speed > 1) {
    // speed = 1;
    // }
      targetVelocity = speed;
    shooterWheel.getPIDController().setReference(speed, ControlType.kVelocity);
    // shooterWheel.set(speed);
  }

  public boolean isShooterAtSpeed(){
    return ((shooterEncoder.getVelocity() >= targetVelocity*.98) && (shooterEncoder.getVelocity() <= targetVelocity*1.02));
  
  }
}