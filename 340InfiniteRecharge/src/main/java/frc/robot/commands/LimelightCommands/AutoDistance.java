/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotContainer.Axis;

public class AutoDistance extends CommandBase {
  /**
   * Creates a new AutoDistance.
   */

   boolean hadTarget = false;

  public AutoDistance() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("AutoDistance Started");
	  RobotContainer.limelight.setPipeline(0); //set pipeline to zero
	  RobotContainer.limelight.setCammode(0); //makes sure that its in robot looks around mode
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.limelight.setLightState(3); //turns on limelight led
    if(!RobotContainer.limelight.haveTarget() && !hadTarget) {
      //Rumble soft if NO target
      Robot.robotContainer.setDriverRumble(0.7, 0);
      
      //Allow driver control and drive until target discovered
      if(Math.abs(Robot.robotContainer.getDriverAxis(Axis.LEFT_X)) >= .05 ||
        Math.abs(Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)) >= .05) {
          RobotContainer.drive.arcadeDrive(Robot.robotContainer.getDriverAxis(Axis.LEFT_Y)*.65, Robot.robotContainer.getDriverAxis(Axis.LEFT_X)*.7569);
      } else if(Math.abs(Robot.robotContainer.getDriverAxis(Axis.RIGHT_X)) >= .15 ||
        Math.abs(Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
          RobotContainer.drive.arcadeDrive(Robot.robotContainer.getDriverAxis(Axis.RIGHT_Y)*.3, Robot.robotContainer.getDriverAxis(Axis.RIGHT_X)*.45);
      } else {
        RobotContainer.drive.setDriveBoth(0);
      }
      } else { 
      //Stop rumble if there is a target
      Robot.robotContainer.setDriverRumble(0, 0);

      double distanceOffset = 0.0;

      if(Math.abs(RobotContainer.limelight.getDistance()) < .5){
        distanceOffset = 0.0;
      }
      else{
        double variable = 0.5;
        distanceOffset = (RobotContainer.limelight.getDistance() / 15) * variable; //needs to be tested, it will probably be janky, change the 15
      }
      
      double rightSpeed = distanceOffset;
      double leftSpeed = -distanceOffset;

      RobotContainer.drive.setDriveRight(rightSpeed);
      RobotContainer.drive.setDriveLeft(leftSpeed);


      }


      hadTarget = RobotContainer.limelight.haveTarget();
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  @Override
  public void end(boolean isFinished) { 
	System.out.println("AutoDistance Ended");
	Robot.robotContainer.setDriverRumble(0, 0);
	
	//return visual to driver camera if autonomous
	if(DriverStation.getInstance().isAutonomous()){
		RobotContainer.limelight.setCammode(1);
	}
	  //or when ready to score
	  //turn off led (no blindness please)

	RobotContainer.limelight.setLightState(1); //turns off limelight led
  }
}