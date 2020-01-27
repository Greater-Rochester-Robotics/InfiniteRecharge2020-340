/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * This class is for ball handling with 5 CANSparkMax objects with limit
 * switches plugged into the SparkMax
 */
public class SnekLoader extends SubsystemBase {

  private static CANSparkMax[] handleMotors;
  private static CANDigitalInput[] handleSensors;
  private static CANEncoder[] handleEncoders;

  public enum State {
    kFillTo4, kFillTo3, kFillTo2, kFillTo1, kFillTo0, kOff, kShootBall4, kShootBall3, kShootBall2, kShootBall1,
    kShootBall0, kSpitBalls
  }

  private State state = State.kOff;

  static final double MOTOR_IN_SPEED0 = 0.3;
  static final double MOTOR_IN_SPEED1 = 0.4;
  static final double MOTOR_IN_SPEED2 = 0.5;
  static final double MOTOR_IN_SPEED3 = 0.6;
  static final double MOTOR_IN_SPEED4 = 0.35;

  public SnekLoader() {
    handleMotors = new CANSparkMax[] {
        // TODO:Need to set CAN Id for motors
        new CANSparkMax(Constants.BALL_HANDLER_MOTOR_0, MotorType.kBrushless),
        new CANSparkMax(Constants.BALL_HANDLER_MOTOR_1, MotorType.kBrushless),
        new CANSparkMax(Constants.BALL_HANDLER_MOTOR_2, MotorType.kBrushless),
        new CANSparkMax(Constants.BALL_HANDLER_MOTOR_3, MotorType.kBrushless),
        new CANSparkMax(Constants.BALL_HANDLER_MOTOR_4, MotorType.kBrushless) };
    // sets default setup for motors
    for (int i = 0; i <= 4; i++) {
      handleMotors[i].restoreFactoryDefaults();
      handleMotors[i].setIdleMode(IdleMode.kBrake);// set brake mode, so motors stop on a dime
      handleMotors[i].enableVoltageCompensation(12.0);// enable volatge compensation mode 12V
      handleSensors[i] = handleMotors[i].getForwardLimitSwitch(LimitSwitchPolarity.kNormallyClosed);
      handleSensors[i].enableLimitSwitch(false);// now disable limit switches, we'll turn these on later, one at a time
      handleEncoders[i] = handleMotors[i].getEncoder();
    }
    for (int i = 0; i <= 3; i++) {
      // inverts motors 0-3
      handleMotors[i].setInverted(true);
    }
  }

  @Override
  public void periodic() {
    if (isJammed() && getState() != State.kSpitBalls) {
      state = State.kOff;
      // TODO: find way to inform driver of jam, also hasn't been tested.
    }
    // This method will be called once per scheduler run
    double[] speeds = new double[5];
    switch (state) {
    case kSpitBalls:
      speeds = new double[] { -1.0, -.85, -.7, -.6, -.5 };
      break;
    case kFillTo4:
      enableOneLimit(4);
      speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, MOTOR_IN_SPEED2, MOTOR_IN_SPEED3, MOTOR_IN_SPEED4 };
      if (getHandleSensor(4)) {
        state = State.kFillTo3;
      } else {
        break;
      }
    case kFillTo3:
      speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, MOTOR_IN_SPEED2, .35, 0.0 };
      enableOneLimit(3);
      if (getHandleSensor(3)) {
        state = State.kFillTo2;
      } else {
        break;
      }
    case kFillTo2:
      speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, .35, 0.0, 0.0 };
      enableOneLimit(2);
      if (getHandleSensor(2)) {
        state = State.kFillTo1;
      } else {
        break;
      }
    case kFillTo1:
      speeds = new double[] { MOTOR_IN_SPEED0, .35, 0.0, 0.0, 0.0 };
      enableOneLimit(1);
      if (getHandleSensor(1)) {
        state = State.kFillTo0;
      } else {
        break;
      }
    case kFillTo0:
      speeds = new double[] { MOTOR_IN_SPEED0, 0.0, 0.0, 0.0, 0.0 };
      enableOneLimit(0);
      if (getHandleSensor(0)) {
        state = State.kOff;
      } else {
        break;
      }

    case kOff:
      speeds = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
      enableOneLimit(-1);
      break;

    case kShootBall4:
      speeds = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
      enableOneLimit(-1);

      break;

    case kShootBall3:
      speeds = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0 };
      enableOneLimit(-1);

      break;

    case kShootBall2:
      speeds = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0 };
      enableOneLimit(-1);

      break;
    case kShootBall1:
      speeds = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0 };
      enableOneLimit(-1);

      break;

    case kShootBall0:
      speeds = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
      enableOneLimit(-1);
      break;
    }
    setAllHandleMotors(speeds);
  }

  /**
   * sets the state of the ballHandler periodic function
   * 
   * @param state enumeration State
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * returns current state
   * 
   * @return current state
   */
  public State getState() {
    return state;
  }

  /**
   * returns boolean of limit switch
   * 
   * @param sensor
   * @return boolean
   */
  public boolean getHandleSensor(int sensor) {
    return handleSensors[sensor].get();
  }

  /**
   * sets one limit switch on while setting the rest off
   * 
   * @param sensorOn the sensor you want on, -1 if you want all to be off
   */
  private void enableOneLimit(int sensorOn) {
    for (int i = 0; i <= 4; i++) {
      handleSensors[i].enableLimitSwitch(i == sensorOn);
    }
  }

  /**
   * sets all of the handler motors to speeds
   * 
   * @param speeds an array of numbers
   */
  private void setAllHandleMotors(double[] speeds) {
    for (int i = 0; i <= 4; i++) {
      handleMotors[i].set(speeds[i]);
    }
  }

  /**
   * detects if a motor is being sent power, but isn't going
   * 
   * @return if a jam is in progress
   */
  public boolean isJammed() {
    boolean isJammed = false;
    for (int i = 0; i <= 4; i++) {
      isJammed = isJammed || ((handleMotors[i].get() != 0) && (handleEncoders[i].getVelocity() == 0));
    }
    return isJammed;
  }
}
