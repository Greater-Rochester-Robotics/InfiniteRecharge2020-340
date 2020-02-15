/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {




    // this is the new RobotMap  <<<<<<-----------------


	///////////////
	// DIO PORTS //
	///////////////

	/* Encoders */
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 0;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 1;

	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 2;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 3;
	
	/* Sensors */
	public static final int BALL_COUNTER_SENSOR = 4;


	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */


    /* LEDs */
	public static final int LED_PCM_CHANNEL = 10;

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */
	public static final int CLIMBER_LEFT_ARM = 31;
	public static final int CLIMBER_RIGHT_ARM =32;
	/* Falcon 500 */
	public static final int DRIVE_LEFT_CHANNEL_A = 23; //front-left20
    public static final int DRIVE_LEFT_CHANNEL_B = 22; //back-left21
	public static final int DRIVE_RIGHT_CHANNEL_A = 21; //back-right22
	public static final int DRIVE_RIGHT_CHANNEL_B = 20; //front-right23

	/* Spark MAXes */
	public static final int SHOOTER_WHEEL = 24; //launching wheel for the prototype
	public static final int BALL_HANDLER_MOTOR_0 = 25;
	public static final int BALL_HANDLER_MOTOR_1 = 26;
	public static final int BALL_HANDLER_MOTOR_2 = 27;
	public static final int BALL_HANDLER_MOTOR_3 = 28;
	public static final int BALL_HANDLER_MOTOR_4 = 29;
	public static final int INTAKE_AXLE = 30;

	/* Compressor/LED PCM */

	public static final int SECONDARY_PCM_ID = 11;

	///////////////
	// CONSTANTS //
	///////////////

	/* Shooter Speeds */
	public static final int TRENCH_SHOT_RPM = 4500;
	public static final int INIT_LINE_SHOT_RPM = 4500;
	public static final int WALL_SHOT_RPM = 4000;


	/* The Titular Zero Speed */
	public static final double ZERO_SPEED = 0.0;



}
