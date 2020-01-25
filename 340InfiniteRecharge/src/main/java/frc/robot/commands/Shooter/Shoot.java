/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SnekLoader.State;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends CommandBase {
  private int stateIndex;

  /**
   * Creates a new Shoot.
   */
  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter, RobotContainer.snekLoader);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stateIndex = 4;
    RobotContainer.shooter.setShooterWheel(5500);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Reinstantiate if PID loop isn't working for the flywheel to spin up between
    // shots
    // if(RobotContainer.shooter.isShooterAtSpeed()){
    if ((stateIndex == 4) && RobotContainer.shooter.isShooterAtSpeed()) {
      RobotContainer.snekLoader.setState(State.kShootBall4);
      stateIndex = 3;
    } else if (stateIndex == 3 && (!RobotContainer.snekLoader.getHandleSensor(4))) {
      RobotContainer.snekLoader.setState(State.kShootBall3);
      stateIndex = 2;
    } else if (stateIndex == 2 && (!RobotContainer.snekLoader.getHandleSensor(3))) {
      RobotContainer.snekLoader.setState(State.kShootBall2);
      stateIndex = 1;
    } else if (stateIndex == 1 && (!RobotContainer.snekLoader.getHandleSensor(2))) {
      RobotContainer.snekLoader.setState(State.kShootBall1);
      stateIndex = 0;
    } else if (stateIndex == 0 && (!RobotContainer.snekLoader.getHandleSensor(1))) {
      RobotContainer.snekLoader.setState(State.kShootBall0);
      stateIndex = -1;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooter.setShooterWheel(0.0);
    RobotContainer.snekLoader.setState(State.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
