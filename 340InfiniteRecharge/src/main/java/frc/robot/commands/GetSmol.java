/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SnekLoader;

public class GetSmol extends CommandBase {
  /**
   * Creates a new GetSmall.
   */
  public GetSmol() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter, /*RobotContainer.colorWheel,*/RobotContainer.snekLoader, RobotContainer.harvester, RobotContainer.limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.harvester.setAxleWheels(0);
    RobotContainer.harvester.raiseHarvester();
    RobotContainer.snekLoader.setState(SnekLoader.State.kOff);
    RobotContainer.shooter.stop();
    RobotContainer.shooter.lowerHood();
    RobotContainer.shooter.raiseHardStop();
    RobotContainer.limelight.setLightState(1);
    RobotContainer.snekLoader.setPause(false);
    //colour wheel down
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
