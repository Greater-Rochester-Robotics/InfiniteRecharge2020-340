/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CompressorOn extends CommandBase {
  Timer timer = new Timer();
  /**
   * Creates a new CompressorOn.
   */
  public CompressorOn() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( RobotContainer.compressor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get()>2){
      RobotContainer.compressor.startCompressor();
    }
  }

 

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
