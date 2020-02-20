/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Shooter.FullInitShot;
import frc.robot.commands.SnekLoader.Load;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

public class TrenchFiveBall extends SequentialCommandGroup {
  /**
   * Creates a new TrenchFiveBall.
   */
  public TrenchFiveBall() {
    super(
    race (new RunPath(PathList.TRENCH_FIVE_BALL.STEP_ONE),new Load()),
      new RunPath(PathList.TRENCH_FIVE_BALL.STEP_TWO),
      new FullInitShot()
    );
  }

}
