/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.SnekLoader;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SnekLoader.State;

public class Load extends CommandBase {
  /**
   * Creates a new Load.
   */
  public Load() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.snekLoader);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // double[] speds = {-1.0,-0.5,0.0,0.5,1.0};
    // RobotContainer.snekShooter.setAllLoadWheels(speds);
    // RobotContainer.snekShooter.setShooterWheel(1.0);
    RobotContainer.snekLoader.setState(State.kFillTo4);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.snekLoader.setState(State.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (RobotContainer.snekLoader.getState() == State.kOff);
  }
}
