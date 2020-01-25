/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Harvester;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;

public class IntakeBalls extends CommandBase {
  /**
   * Creates a new Harvest.
   */
  public IntakeBalls() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.harvester);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.harvester.isRightSensorTripped() && RobotContainer.harvester.isLeftSensorTripped()){
      RobotContainer.harvester.setRightAxleWheel(0);
      RobotContainer.harvester.setLeftAxleWheel(0);
    }
    else if(RobotContainer.harvester.isLeftSensorTripped()){
      RobotContainer.harvester.setRightAxleWheel(0);
      RobotContainer.harvester.setLeftAxleWheel(1);
    }
    else if(RobotContainer.harvester.isRightSensorTripped()){
      RobotContainer.harvester.setLeftAxleWheel(0);
      RobotContainer.harvester.setRightAxleWheel(1);
    }
    else{
      RobotContainer.harvester.setRightAxleWheel(1);
      RobotContainer.harvester.setLeftAxleWheel(1);
    }
  }

  // Called once the command ends or is interrupted.
  //If command is interuptted, stops the harvester
  @Override
  public void end(boolean interrupted) {
    RobotContainer.harvester.setRightAxleWheel(0);
    RobotContainer.harvester.setLeftAxleWheel(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
