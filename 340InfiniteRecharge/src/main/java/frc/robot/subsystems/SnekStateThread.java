/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/*
TODO:
> Start and control thread from SnekLoader.java
> Figure out how to get data to the thread
> Get data from thread to SnekLoader
*/

public class SnekStateThread extends Thread {

    private static CANSparkMax[] handleMotors;
    private static CANDigitalInput[] handleSensors = new CANDigitalInput[5];
    private static CANEncoder[] handleEncoders = new CANEncoder[5];
    // If it is deemed necessary, uncomment all of ballsLoaded stuff
    private int ballsLoaded;
    private boolean isPaused;
    // private static boolean hadBall;
    double[] speeds = new double[5];
    int smartCount = 0;

    public enum SnekState {
    kFillTo4, kFillTo3, kFillTo2, kFillTo1, kFillTo0, kOff, kShootBall4, kShootBall3, kShootBall2, kShootBall1,
    kShootBall0, kSpitBalls
    }

    private SnekState snekState = SnekState.kOff;

    static final double MOTOR_IN_SPEED0 = 0.5;
    static final double MOTOR_IN_SPEED1 = 0.4;
    static final double MOTOR_IN_SPEED2 = 0.5;
    static final double MOTOR_IN_SPEED3 = 0.6;
    static final double MOTOR_IN_SPEED4 = 0.35;

    public SnekStateThread(){

    }

    
    public void run() {
        switch (snekState) {
            case kSpitBalls:
              speeds = new double[] { -1.0, -.85, -.7, -.6, -.5 };
              ballsLoaded = 0;
              break;
            case kFillTo4:
              enableOneLimit(4);
              speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, MOTOR_IN_SPEED2, MOTOR_IN_SPEED3, MOTOR_IN_SPEED4 };
              if (getHandleSensor(4)) {
                snekState = SnekState.kFillTo3;
              } else {
                ballsLoaded = 0;
                break;
              }
            case kFillTo3:
              speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, MOTOR_IN_SPEED2, MOTOR_IN_SPEED4, 0.0 };
              enableOneLimit(3);
              if (getHandleSensor(3)) {
                snekState = SnekState.kFillTo2;
              } else {
                ballsLoaded = 1;
                break;
              }
            case kFillTo2:
              speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED1, MOTOR_IN_SPEED4, 0.0, 0.0 };
              enableOneLimit(2);
              if (getHandleSensor(2)) {
                snekState = SnekState.kFillTo1;
              } else {
                ballsLoaded = 2;
                break;
              }
            case kFillTo1:
              speeds = new double[] { MOTOR_IN_SPEED0, MOTOR_IN_SPEED4, 0.0, 0.0, 0.0 };
              enableOneLimit(1);
              if (getHandleSensor(1)) {
                snekState = SnekState.kFillTo0;
              } else {
                ballsLoaded = 3;
                break;
              }
            case kFillTo0:
              speeds = new double[] { MOTOR_IN_SPEED0, 0.0, 0.0, 0.0, 0.0 };
              enableOneLimit(0);
              ballsLoaded = -1;
              if (getHandleSensor(0)) {
                ballsLoaded = 5;
                snekState = SnekState.kOff;
              } else {
                ballsLoaded = 4;
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
              speeds = new double[] { 0.0, 0.0, 0.0, .9, 1.0 };
              enableOneLimit(-1);
              break;
        
            case kShootBall2:
              speeds = new double[] { 0.0, 0.0, .7, .85, 1.0 };
              enableOneLimit(-1);
              break;
        
            case kShootBall1:
              speeds = new double[] { 0.0, .5, .7, .85, 1.0 };
              enableOneLimit(-1);
              break;
            case kShootBall0:
              speeds = new double[] { .3, .5, .75, .9, 1.0 };
              enableOneLimit(-1);
              break;
            default:
                speeds = new double[] {0.0,0.0,0.0,0.0,0.0};
            }
            if(isPaused){
              speeds = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
            }
            setAllHandleMotors(speeds);
        
            //SmartDashboard Pushes
            if(smartCount == 1){
              smartCount = 0;
            if (isJammed() && getSnekState() != SnekState.kSpitBalls) {
              SmartDashboard.putBoolean("isJammed", true);
            } else {
              SmartDashboard.putBoolean("isJammed", false);
            }
            
            SmartDashboard.putBoolean("Ball 0", handleSensors[0].get());
            SmartDashboard.putBoolean("Ball 1", handleSensors[1].get());
            SmartDashboard.putBoolean("Ball 2", handleSensors[2].get());
            SmartDashboard.putBoolean("Ball 3", handleSensors[3].get());
              SmartDashboard.putBoolean("Ball 4", handleSensors[4].get());
              SmartDashboard.putString("BallsLoaded", ""+ ballsLoaded);
            }
            smartCount++;

    }
    
    public boolean isJammed() {
        boolean isJammed = false;
        for (int i = 0; i <= 4; i++) {
          isJammed = isJammed || 
            ((handleMotors[i].get() != 0) && (handleEncoders[i].getVelocity() == 0))||
            handleMotors[i].getOutputCurrent() > 40.0;
        }
        return isJammed;
      }

      public SnekState getSnekState() {
        return snekState;
      }

      private void enableOneLimit(int sensorOn) {
        for (int i = 0; i <= 4; i++) {
          handleSensors[i].enableLimitSwitch(i == sensorOn);
        }
      }

      public boolean getHandleSensor(int sensor) {
        // PrintWriter writer;
        // try {
        //   writer = new PrintWriter("output.txt", "UTF-8");
        //   writer.println(handleSensors[sensor].get());
        //   writer.close();
        // } catch (FileNotFoundException e) {
        //   // TODO Auto-generated catch block
        //   e.printStackTrace();
        // } catch (UnsupportedEncodingException e) {
        //   // TODO Auto-generated catch block
        //   e.printStackTrace();
        // }
        return handleSensors[sensor].get();
      }

      private void setAllHandleMotors(double[] speeds) {
        for (int i = 0; i <= 4; i++) {
          handleMotors[i].set(speeds[i]);
        }
      }


}