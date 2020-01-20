/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.SnekShooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SnekShooter;
import frc.robot.subsystems.SnekShooter.State;
import frc.robot.Robot;

public class Regurgitate extends CommandBase {
  /**
   * Creates a new Regurgitate.
   */
  public Regurgitate() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.snekShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.snekShooter.setState(SnekShooter.State.kSpitBalls);
    RobotContainer.snekShooter.setShooterWheel(-100);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.snekShooter.setState(SnekShooter.State.kOff);
    RobotContainer.snekShooter.setShooterWheel(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
