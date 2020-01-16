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

	/* Sensors */



	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */


    /* LEDs */
	public static final int LED_PCM_CHANNEL = 7;

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */

	//Commented numbers are on prac bot. THEY ARE NOT NOT PERMANENT ON EITHER BOT


	/* Spark MAXes */
	public static final int ELEVATOR_A_MOTOR_CAN_ID = 13; //mid
	public static final int ELEVATOR_B_MOTOR_CAN_ID = 12; //left
	public static final int ELEVATOR_C_MOTOR_CAN_ID = 14; //right
	public static final int DRIVE_SPARK_LEFT_CHANNEL_A = 20; //front-left
    public static final int DRIVE_SPARK_LEFT_CHANNEL_B = 21; //back-left
	public static final int DRIVE_SPARK_RIGHT_CHANNEL_A = 22; //back-right
    public static final int DRIVE_SPARK_RIGHT_CHANNEL_B = 23; //front-right

	/* Compressor/LED PCM */
	public static final int SECONDARY_PCM_ID = 10;

	///////////////
	// CONSTANTS //
	///////////////

	/* C speed */


	/* Elevator speed */

	



	/* The Titular Zero Speed */
	public static final double ZERO_SPEED = 0.0;



	/* Elevator heights */


}
