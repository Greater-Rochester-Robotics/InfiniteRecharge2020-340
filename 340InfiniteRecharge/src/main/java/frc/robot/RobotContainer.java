/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//TODO: remember to use TODO: remember to use TODO: remember to use TODO: remember to use TODO: etc.
//recursive todo reminding you to use todo to locate things
package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.SnekShooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.DriveXOne;
import frc.robot.commands.SnekShooter.Load;
import frc.robot.commands.SnekShooter.Shoot;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

 
  
  final Joystick driver = new Joystick(0);
  final Joystick coDriver = new Joystick(1);
  
    ////////////////////
    // DRIVER BUTTONS //
    ////////////////////
  
    final Button driverA = new JoystickButton(driver, 1);
    final Button driverB = new JoystickButton(driver, 2);
    final Button driverX = new JoystickButton(driver, 3);
    final Button driverY = new JoystickButton(driver, 4);
    final Button driverLB = new JoystickButton(driver, 5);
    final Button driverRB = new JoystickButton(driver, 6);
    final Button driverBack = new JoystickButton(driver, 7);
    final Button driverStart = new JoystickButton(driver, 8);
    final Button driverLS = new JoystickButton(driver, 9);
    final Button driverRS = new JoystickButton(driver, 10);
    final Button driverDUp = new DPad(driver, DPad.Direction.UP);
    final Button driverDDown = new DPad(driver, DPad.Direction.DOWN);
    final Button driverDLeft = new DPad(driver, DPad.Direction.LEFT);
    final Button driverDRight = new DPad(driver, DPad.Direction.RIGHT);
    final Button driverLTButton = new JoyTriggerButton(driver, .3, Axis.LEFT_TRIGGER);
    final Button driverRTButton = new JoyTriggerButton(driver, .3, Axis.RIGHT_TRIGGER);
  
    ///////////////////////
    // CO-DRIVER BUTTONS //
    ///////////////////////
  
    final Button coDriverA = new JoystickButton(coDriver, 1);
    final Button coDriverB = new JoystickButton(coDriver, 2);
    final Button coDriverX = new JoystickButton(coDriver, 3);
    final Button coDriverY = new JoystickButton(coDriver, 4);
    final Button coDriverLB = new JoystickButton(coDriver, 5);
    final Button coDriverRB = new JoystickButton(coDriver, 6);
    final Button coDriverBack = new JoystickButton(coDriver, 7);
    final Button coDriverStart = new JoystickButton(coDriver, 8);
    final Button coDriverLS = new JoystickButton(coDriver, 9);
    final Button coDriverRS = new JoystickButton(coDriver, 10);
    final Button coDriverDUp = new DPad(coDriver, DPad.Direction.UP);
    final Button coDriverDDown = new DPad(coDriver, DPad.Direction.DOWN);
    final Button coDriverDLeft = new DPad(coDriver, DPad.Direction.LEFT);
    final Button coDriverDRight = new DPad(coDriver, DPad.Direction.RIGHT);
    final Button coDriverLTButton = new JoyTriggerButton(coDriver, .7, Axis.LEFT_TRIGGER);
    final Button coDriverRTButton = new JoyTriggerButton(coDriver, .7, Axis.RIGHT_TRIGGER);



    public static Drive drive;
    public static Compressor compressor;
    public static SnekShooter snekShooter;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    //TODO: comment this out to drive
    //drive  = new Drive();
    snekShooter = new SnekShooter();
    //TODO: Pneumatics system, set that up
    //compressor = new Compressor(Constants.SECONDARY_PCM_ID);
    //TODO: commented out default drive for testing purposes
    //CommandScheduler.getInstance().setDefaultCommand(drive, new DriveXOne());

    
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //driverRTButton.whenHeld(new RunPath(PathList.LEFT_ROCKET.HECK_PATH));
    //driverRTButton.whenReleased(new DriveXOne());
    driverRB.whenPressed(new Load());
    driverLB.whenPressed(new Shoot());
  }



  public enum Axis {
		LEFT_X(0),
		LEFT_Y(1),
		LEFT_TRIGGER(2),
		RIGHT_TRIGGER(3),
		RIGHT_X(4),
		RIGHT_Y(5);

		private int axis;

		private Axis(int axis) {
			this.axis = axis;
		}

		public int getAxisNumber() {
			return axis;
		}
  }
  /**
	 * 
	 * @param axis
	 * @return
	 */
	public double getDriverAxis(Axis axis) {
		return (driver.getRawAxis(axis.getAxisNumber()) < -.1 || driver.getRawAxis(axis.getAxisNumber()) > .1 ) ? driver.getRawAxis(axis.getAxisNumber()) : 0;
	}

	/**
	 * Accessor method to set driver rumble function
	 * @param leftRumble
	 * @param rightRumble
	 */
	public void setDriverRumble (double leftRumble, double rightRumble){
		driver.setRumble(RumbleType.kLeftRumble, leftRumble);
		driver.setRumble(RumbleType.kRightRumble, rightRumble);
	}
	/**
	 * 
	 * @param axis
	 * @return
	 */
	public double getCoDriverAxis(Axis axis) {
		return (coDriver.getRawAxis(axis.getAxisNumber()) < -.1 || coDriver.getRawAxis(axis.getAxisNumber()) > .1 ) ? coDriver.getRawAxis(axis.getAxisNumber()) : 0;
	}


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
