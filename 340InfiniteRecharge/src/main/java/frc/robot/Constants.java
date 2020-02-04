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




	//////////////////
	// PWM CHANNELS //
	//////////////////

	/* Talons */



	///////////////
	// DIO PORTS //
	///////////////

	/* Encoders */
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 8;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 9;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 6;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 7;

	///////////////////////FOR PROTOTYPE SNEKSHOOTER
	public static final int SNEKSHOOTER_ENCODER_TALONSRX1_A = 12;
	public static final int SNEKSHOOTER_ENCODER_TALONSRX2_A = 13;
	public static final int SNEKSHOOTER_ENCODER_TALONSRX3_A = 14;
	public static final int SNEKSHOOTER_ENCODER_TALONSRX4_A = 15;
	public static final int SNEKSHOOTER_ENCODER_TALONSRX5_A = 16;
	public static final int SNEKSHOOTER_ENCODER_SHOOTER_A = 17;
	///////////////////////FOR PROTOTYPE SNEKSHOOTER

	
	/* Sensors */
	public static final int BALL_COUNTER_SENSOR = 7;


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

	/* Falcon 500 */
	public static final int DRIVE_LEFT_CHANNEL_A = 20; //front-left
    public static final int DRIVE_LEFT_CHANNEL_B = 21; //back-left
	public static final int DRIVE_RIGHT_CHANNEL_A = 22; //back-right
	public static final int DRIVE_RIGHT_CHANNEL_B = 23; //front-right

	/* Spark MAXes */
	public static final int SNEKSHOOTER_SPARK_LAUNCHER = 24; //launching wheel for the prototype
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
	public static final int TRENCH_SHOT_RPM = 5500;
	public static final int INIT_LINE_SHOT_RPM = 5500;
	public static final int WALL_SHOT_RPM = 5000;


	/* The Titular Zero Speed */
	public static final double ZERO_SPEED = 0.0;



}
