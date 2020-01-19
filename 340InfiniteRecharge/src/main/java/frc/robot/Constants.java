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

	public static final int SNEKSHOOTER_TALONSRX_1 = 2;
	public static final int SNEKSHOOTER_TALONSRX_2 = 3;
	public static final int SNEKSHOOTER_TALONSRX_3 = 4;
	public static final int SNEKSHOOTER_TALONSRX_4 = 5;
	public static final int SNEKSHOOTER_TALONSRX_5 = 6;

	//Commented numbers are on prac bot. THEY ARE NOT NOT PERMANENT ON EITHER BOT


	/* Spark MAXes */
	public static final int DRIVE_SPARK_LEFT_CHANNEL_A = 20; //front-left
    public static final int DRIVE_SPARK_LEFT_CHANNEL_B = 21; //back-left
	public static final int DRIVE_SPARK_RIGHT_CHANNEL_A = 22; //back-right
	public static final int DRIVE_SPARK_RIGHT_CHANNEL_B = 23; //front-right
	public static final int SNEKSHOOTER_SPARK_LAUNCHER = 24; //launching wheel for the prototype 

	/* Compressor/LED PCM */
	public static final int SECONDARY_PCM_ID = 11;

	///////////////
	// CONSTANTS //
	///////////////

	/* C speed */


	/* Elevator speed */

	



	/* The Titular Zero Speed */
	public static final double ZERO_SPEED = 0.0;



	/* Elevator heights */


}
