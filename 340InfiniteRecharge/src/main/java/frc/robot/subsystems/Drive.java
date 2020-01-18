/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.PCM_LED;
import frc.robot.Constants;
import frc.robot.commands.DriveXOne;

/**
 * <h1>Drive</h1>
 * Moves the robot between two places. Always uses the Xbox ONE controller
 * command unless explicitly told otherwise<br>
 * <br>
 * Overall gear ratio: 44/5
 */
public class Drive extends SubsystemBase {
	private double leftSpeed, rightSpeed; //Makes math easier for fancy drive

	//RIP IMU
	// private static ADIS16448_IMU imu;
	private static ADXRS450_Gyro gyro;
	private static Encoder encLeft, encRight;
	private static CANSparkMax driveLeftA, driveLeftB, driveRightA, driveRightB;
	private static PCM_LED led;

	/**
	 * Set up the Sparks and encoders with the ports specified
	 * in {@link Constants}, and the IMU with the Y-axis as yaw
	 */
	public Drive() {
		// imu = new ADIS16448_IMU(ADIS16448_IMU.Axis.kZ); //The parameter here is the axis the IMU interprets as being yaw. This will depend on how the RIO is oriented
		// imu.calibrate();
		// imu.reset();

		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		encLeft = new Encoder(Constants.DRIVE_ENCODER_LEFT_CHANNEL_A, Constants.DRIVE_ENCODER_LEFT_CHANNEL_B);
		encRight = new Encoder(Constants.DRIVE_ENCODER_RIGHT_CHANNEL_A, Constants.DRIVE_ENCODER_RIGHT_CHANNEL_B);

		//256 ticks to 6pi inches = .0234375pi inches per tick
		encLeft.setDistancePerPulse(.0234375 * Math.PI);
		encRight.setDistancePerPulse(.0234375 * Math.PI);

		encLeft.setReverseDirection(true);
		encRight.setReverseDirection(true);

		driveLeftA = new CANSparkMax(Constants.DRIVE_SPARK_LEFT_CHANNEL_A, MotorType.kBrushless);
		driveLeftB = new CANSparkMax(Constants.DRIVE_SPARK_LEFT_CHANNEL_B, MotorType.kBrushless);
		driveRightA = new CANSparkMax(Constants.DRIVE_SPARK_RIGHT_CHANNEL_A, MotorType.kBrushless);
		driveRightB = new CANSparkMax(Constants.DRIVE_SPARK_RIGHT_CHANNEL_B, MotorType.kBrushless);
		
		//TODO: Commented out PCM LED due to null exception
		//led = new PCM_LED(Constants.SECONDARY_PCM_ID, Constants.LED_PCM_CHANNEL);

		//TODO: consider enslaving B motors to A motors

		//Negate all speeds to the left side to account for mirrored axes
		driveLeftA.setInverted(true);
		driveLeftB.setInverted(true);

	}

	//@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveXOne());
	}

	/**
	 * @return left encoder raw count
	 */
	public int getLeftEncoder() {
		return encLeft.get();
	}

	/**
	 * @return right encoder raw count
	 */
	public int getRightEncoder() {
		return encRight.get();
	}

	/**
	 * @return encoder-derived left rail speed
	 */
	public double getLeftSpeed() {
		return encLeft.getRate();
	}

	/**
	 * @return encoder-derived right rail speed
	 */
	public double getRightSpeed() {
		return encRight.getRate();
	}

	/**
	 * @return left encoder distance
	 */
	public double getLeftDistance() {
		return encLeft.getDistance();
	}

	/**
	 * @return right encoder distance
	 */
	public double getRightDistance() {
		return encRight.getDistance();
	}

	/**
	 * Zero the left encoder
	 */
	public void resetLeftEncoder() {
		encLeft.reset();
	}

	/**
	 * Zero the right encoder
	 */
	public void resetRightEncoder() {
		encRight.reset();
	}

	/**
	 * Zero both encoders
	 */
	public void resetBothEncoders() {
		encLeft.reset();
		encRight.reset();
	}

	/**
	 * Set the speed, as a percentage of max forward speed, of the left drive rail
	 * @param speed percentage of max forward speed
	 */
	public void setDriveLeft(double speed) {
		if(speed < -1) {
			speed = -1;
		} else if (speed > 1) {
			speed = 1;
		}

		driveLeftA.set(speed);
		driveLeftB.set(speed);
	}

	/**
	 * Set the speed, as a percentage of max forward speed, of the right drive rail
	 * @param speed percentage of max forward speed
	 */
	public void setDriveRight(double speed) {
		if(speed < -1) {
			speed = -1;
		} else if (speed > 1) {
			speed = 1;
		}

		driveRightA.set(speed);
		driveRightB.set(speed);
	}

	/**
	 * Set the drive train to a given speed, as a percentage of max forward speed<br>
	 * Both rails will be at equal speed
	 */
	public void setDriveBoth(double speed) {
		setDriveLeft(speed);
		setDriveRight(speed);
	}

	/**
	 * Set the drive train to a given speed, as a percentage of max forward speed<br>
	 * Rails are independently sped
	 */
	public void setDriveBoth(double lSpeed, double rSpeed) {
		setDriveLeft(lSpeed);
		setDriveRight(rSpeed);
	}

	/**
	 * Stop the drive train
	 */
	public void stopDrive() {
		setDriveBoth(0);
	}

	/**
	 * Get the robot's yaw angle
	 */
	public double getRotation() {
		// return imu.getAngleZ();
		return gyro.getAngle();
	}

	/**
	 * Zero the gyro
	 */
	public void gyroReset() {
		// imu.reset();
		gyro.reset();
	}

	/**
	 * Calibrate the gyro
	 */
	public void gyroCalibrate() {
		gyro.calibrate();
	}

	/**
	 * Turns the LEDs on/off (for Limelight assitance)
	 * @param isOn {@code true} to turn them on, {@code false} to turn them off
	 */
	public void setLEDs(boolean isOn) {
		led.set(isOn);
	}

	/**
     * One joystick drive mode. One stick axis speeds forward/backwards, the other adds rotation on robot yaw axis
     * @param moveValue forward/backward speed, as a percentage of max forward speed
     * @param rotateValue rotation speed, as a percentage of max rightward rotation speed
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
		if(moveValue > 0.0) {
		    if(rotateValue > 0.0) {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = Math.max(moveValue, rotateValue);
		    } else {
		    	leftSpeed = Math.max(moveValue, -rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    }
		} else {
		    if(rotateValue > 0.0) {
		    	leftSpeed = -Math.max(-moveValue, rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    } else {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = -Math.max(-moveValue, -rotateValue);
		    }
		}

		setDriveBoth( leftSpeed , rightSpeed ); //This new drivebase is too fast
	}

	/**
     * One joystick drive mode. One stick axis speeds forward/backwards, the other adds rotation on robot yaw axis<br>
	 * This one also controls mantis banebot wheels
     * @param moveValue forward/backward speed, as a percentage of max forward speed
     * @param rotateValue rotation speed, as a percentage of max rightward rotation speed
     */
    public void arcadeDriveWithMantis(double moveValue, double rotateValue) {
		if(moveValue > 0.0) {
		    if(rotateValue > 0.0) {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = Math.max(moveValue, rotateValue);
		    } else {
		    	leftSpeed = Math.max(moveValue, -rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    }
		} else {
		    if(rotateValue > 0.0) {
		    	leftSpeed = -Math.max(-moveValue, rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    } else {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = -Math.max(-moveValue, -rotateValue);
		    }
		}

		setDriveBoth(leftSpeed * .2, rightSpeed * .2); //This new drivebase is too fast
	}
}
