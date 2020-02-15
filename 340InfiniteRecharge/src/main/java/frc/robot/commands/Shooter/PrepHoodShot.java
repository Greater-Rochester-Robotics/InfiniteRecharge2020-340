/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.SnekLoader;

public class PrepHoodShot extends CommandBase {

  Timer tm;
  double time;
  /**
   * Creates a new PrepHoodShot.
   */
  
  public PrepHoodShot(){
    this(1.5);
  }

  public PrepHoodShot(double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter, RobotContainer.snekLoader);
    this.time = time;
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.shooter.raiseHardStop();
    RobotContainer.shooter.raiseHood();
    RobotContainer.shooter.setShooterWheel(3000);
    RobotContainer.snekLoader.setState(SnekLoader.State.kFillTo4);
    tm = new Timer();
    tm.reset();
    tm.start();
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
    return (RobotContainer.shooter.isShooterAtSpeed() || tm.get() >= time);
  }
}
