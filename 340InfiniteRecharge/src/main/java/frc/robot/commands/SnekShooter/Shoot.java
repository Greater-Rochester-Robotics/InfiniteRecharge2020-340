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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends CommandBase {
  Timer timer = new Timer();
  /**
   * Creates a new Shoot.
   */
  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.snekShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    RobotContainer.snekShooter.setShooterWheel(5500);
   // SmartDashboard.putNumber("newSpeed",5500);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get()>1.5){
      RobotContainer.snekShooter.setState(SnekShooter.State.kShootBall5);
    }
   // double newSpeed = SmartDashboard.getNumber("newSpeed", 5500);
    //RobotContainer.snekShooter.setShooterWheel(newSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.snekShooter.setShooterWheel(0.0);
    RobotContainer.snekShooter.setState(SnekShooter.State.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
