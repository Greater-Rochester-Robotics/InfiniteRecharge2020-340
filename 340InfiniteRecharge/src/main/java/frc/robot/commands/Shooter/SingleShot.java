/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.SnekLoader.State;

public class SingleShot extends CommandBase {
  /**
   * Creates a new SingleShot.
   */
  public SingleShot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter,RobotContainer.snekLoader);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.shooter.setShooterWheel(5500);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!RobotContainer.snekLoader.getHandleSensor(4) && (!RobotContainer.shooter.getShooterSensor())){
      RobotContainer.shooter.setShooterWheel(0.0);
      RobotContainer.snekLoader.setState(State.kFillTo4);
    }
    else if(RobotContainer.shooter.isShooterAtSpeed()){
      RobotContainer.snekLoader.setState(State.kShootBall4);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //If driver wants to press per shot don't enable this
    // RobotContainer.snekLoader.setState(State.kOff);
    // RobotContainer.shooter.setShooterWheel(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (!RobotContainer.snekLoader.getHandleSensor(4));
  }
}
