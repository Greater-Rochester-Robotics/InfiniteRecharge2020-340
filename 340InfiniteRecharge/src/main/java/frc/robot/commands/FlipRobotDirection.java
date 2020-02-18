/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class FlipRobotDirection extends CommandBase {
  /**
   * Creates a new FlipRobotDirection.
   */
  public FlipRobotDirection() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //this is literal Space AIDs
    if(Constants.DRIVE_ENCODER_LEFT_CHANNEL_A == 2){
      Constants.DRIVE_ENCODER_LEFT_CHANNEL_A = 0;
      Constants.DRIVE_ENCODER_LEFT_CHANNEL_B = 1;
      Constants.DRIVE_ENCODER_RIGHT_CHANNEL_A = 3;
      Constants.DRIVE_ENCODER_RIGHT_CHANNEL_B = 2;
    } else {
      Constants.DRIVE_ENCODER_LEFT_CHANNEL_A = 2;
      Constants.DRIVE_ENCODER_LEFT_CHANNEL_B = 3;
      Constants.DRIVE_ENCODER_RIGHT_CHANNEL_A = 1;
      Constants.DRIVE_ENCODER_RIGHT_CHANNEL_B = 0 ;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
