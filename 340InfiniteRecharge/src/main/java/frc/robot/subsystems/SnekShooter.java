/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//PROTOTYPE

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SnekShooter extends SubsystemBase {

  private static CANSparkMax shooterWheel;
  private static TalonSRX loadWheel1, loadWheel2, loadWheel3, loadWheel4, loadWheel5;
  private DigitalInput switch1, switch2, switch3, switch4, switch5;
  public enum State{
    kFillTo5,kFillTo4,kFillTo3,kFillTo2,kFillTo1,kOff,kShootBall5,kShootBall4,kShootBall3,kShootBall2,kShootBall1,kSpitBalls
  }
private State state = State.kOff;

static final double MOTOR_IN_SPEED1 = 0.3;
static final double MOTOR_IN_SPEED2 = 0.4;
static final double MOTOR_IN_SPEED3 = 0.5;
static final double MOTOR_IN_SPEED4 = 0.6;
static final double MOTOR_IN_SPEED5 = 0.35;
  /**
   * Creates a new Shooter.
   */
  public SnekShooter() {

    loadWheel1 = new TalonSRX(Constants.SNEKSHOOTER_TALONSRX_1);
    loadWheel2 = new TalonSRX(Constants.SNEKSHOOTER_TALONSRX_2);
    loadWheel3 = new TalonSRX(Constants.SNEKSHOOTER_TALONSRX_3);
    loadWheel4 = new TalonSRX(Constants.SNEKSHOOTER_TALONSRX_4);
    loadWheel5 = new TalonSRX(Constants.SNEKSHOOTER_TALONSRX_5);
    shooterWheel = new CANSparkMax(Constants.SNEKSHOOTER_SPARK_LAUNCHER, MotorType.kBrushless);
    shooterWheel.getPIDController().setP(0.0001);
    shooterWheel.getPIDController().setI(0.0);
    shooterWheel.getPIDController().setD(0.00005);
    shooterWheel.getPIDController().setFF(0.000174);
    switch1 = new DigitalInput(0);
    switch2 = new DigitalInput(1);
    switch3 = new DigitalInput(2);
    switch4 = new DigitalInput(3);
    switch5 = new DigitalInput(4);
    shooterWheel.setInverted(true);
    loadWheel1.setInverted(true);
    loadWheel3.setInverted(true);
    loadWheel2.setInverted(true);
    loadWheel4.setInverted(true);
  }

  public void setState(State state){
    this.state = state;
  }

  public State getState(){
    return state;
  }

  public void setLoadWheel(TalonSRX loadWheel, double speed){
    if (speed < -1) {
      speed = -1;
    } else if (speed > 1) {
      speed = 1;
    }    
    //TODO: this speed will change as voltage drops
    loadWheel.set(ControlMode.PercentOutput, speed);
  }

  public void setAllLoadWheels(double[] speeds){
    setLoadWheel(loadWheel1, speeds[0]);
    setLoadWheel(loadWheel2, speeds[1]);
    setLoadWheel(loadWheel3, speeds[2]);
    setLoadWheel(loadWheel4, speeds[3]);
    setLoadWheel(loadWheel5, speeds[4]);        
  }

  public void setShooterWheel(double speed){
    // if (speed < -1) {
    //   speed = -1;
    // } else if (speed > 1) {
    //   speed = 1;
    // }    
    
    shooterWheel.getPIDController().setReference(speed ,ControlType.kVelocity);
    // shooterWheel.set(speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double[] speeds = new double[5];
    switch(state){
      case kSpitBalls:
        speeds = new double[] {-1.0,-.85,-.7,-.6,-.5};
        break;
      case kFillTo5:
        speeds = new double[] {MOTOR_IN_SPEED1,MOTOR_IN_SPEED2,MOTOR_IN_SPEED3,MOTOR_IN_SPEED4,MOTOR_IN_SPEED5};
        if(!switch5.get()){
          state = State.kFillTo4;
        }else{
          break;
        }
      case kFillTo4:
        speeds = new double[] {MOTOR_IN_SPEED1,MOTOR_IN_SPEED2,MOTOR_IN_SPEED3,.35,0.0};
        
        if(!switch4.get()){
          state = State.kFillTo3;
        }else{
          break;
        }
      case kFillTo3:
        speeds = new double[] {MOTOR_IN_SPEED1,MOTOR_IN_SPEED2,.35,0.0,0.0};
        
      if(!switch3.get()){
        state = State.kFillTo2;
      }else{
        break;
      }
      case kFillTo2:
        speeds = new double[] {MOTOR_IN_SPEED1,.35,0.0,0.0,0.0};
        
      if(!switch2.get()){
        state = State.kFillTo1;
      }else{
        break;
      }
      case kFillTo1:
      speeds = new double[] {MOTOR_IN_SPEED1,0.0,0.0,0.0,0.0};
        
      if(!switch1.get()){
        state = State.kOff;
      }else{
        break;
      }
      case kOff:
        speeds = new double[] {0.0,0.0,0.0,0.0,0.0};
        
        break;
      case kShootBall5:
        speeds = new double[] {0.0,0.0,0.0,0.0,1.0};
        if(switch5.get()){
          state = State.kShootBall4;
        }else{
          break;
        }
      case kShootBall4:
        speeds = new double[] {0.0,0.0,0.0,1.0,1.0};
        if(switch4.get()){
          state = State.kShootBall3;
        }else{
          break;
        }
      case kShootBall3:
        speeds = new double[] {0.0,0.0,1.0,1.0,1.0};
        if(switch3.get()){
          state = State.kShootBall1;
        }else{
          break;
        }
      // case kShootBall2:
      //   speeds = new double[] {0.0,1.0,1.0,1.0,1.0};
      //   if(switch2.get()){
      //     state = State.kShootBall1;
      //   }else{
      //     break;
      //   }
      case kShootBall1:
        speeds = new double[] {1.0,1.0,1.0,1.0,1.0};
        break;
    }
    setAllLoadWheels(speeds);
  }
}
