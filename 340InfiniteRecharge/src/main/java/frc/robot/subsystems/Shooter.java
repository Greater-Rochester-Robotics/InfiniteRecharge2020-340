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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase {

  private static CANSparkMax shooterWheel;
  private CANEncoder shooterEncoder;
  private double targetVelocity;
  private DigitalInput ballCounter;
  private int ballsShot = 0;
  private int totalBallsShot = 0;
  private boolean ballWasPresent;
  private Solenoid hoodMover;

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
    ballCounter = new DigitalInput(Constants.BALL_COUNTER_SENSOR);
    ballWasPresent = false;
    hoodMover = new Solenoid(2);
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
 
  public void raiseHood(){
    hoodMover.set(true);
  }

  public void lowerHood(){
    hoodMover.set(false);
  }

  public void resetBallsShot(){
    ballsShot = -0;
  }

  public int getBallsShot(){
    return ballsShot;
  }

  public boolean getShooterSensor(){
    return (ballCounter.get());
  }

  public int getTotalBallsShot(){
    return totalBallsShot;
  }

  @Override
  public void periodic(){
    //if ballCounter sensor is false and ball sensor was true previously, add one
    if (!ballCounter.get() && ballWasPresent){
      ballsShot ++;
      totalBallsShot++;
    }

    ballWasPresent = ballCounter.get();
  }
}
