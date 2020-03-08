/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SnekLoader;
import frc.robot.subsystems.Harvester;

public class NewPrepPlus extends CommandBase {

  /**
   * Creates a new PrepHoodShot.
   */


  public NewPrepPlus() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter, RobotContainer.snekLoader, RobotContainer.harvester);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.shooter.raiseHardStop();
    RobotContainer.shooter.raiseHood();
    RobotContainer.shooter.setShooterWheel(Constants.INITIATION_SHOT_RPM);
    RobotContainer.snekLoader.setState(SnekLoader.State.kFillTo4);
    RobotContainer.harvester.lowerHarvester();
    RobotContainer.harvester.setAxleWheels(6.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.harvester.setAxleWheels(0.0);
    RobotContainer.harvester.raiseHarvester();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
