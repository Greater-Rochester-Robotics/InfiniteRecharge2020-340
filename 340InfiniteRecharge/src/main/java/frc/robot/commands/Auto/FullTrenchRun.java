/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Shooter.FastBallWithHintOfLime;
import frc.robot.commands.Shooter.FullInitShot;
import frc.robot.commands.Shooter.FullTrenchAutoShotTest;
import frc.robot.commands.Shooter.ResetBallsShot;
import frc.robot.commands.SnekLoader.Load;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FullTrenchRun extends SequentialCommandGroup {
  /**
   * Creates a new FullTrenchRun.
   */
  public FullTrenchRun() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
    new ResetBallsShot(),
    race (new RunPath(PathList.FULL_TRENCH_RUN.STEP_ONE),new Load()),
      new RunPath(PathList.FULL_TRENCH_RUN.STEP_TWO),
      new FullTrenchAutoShotTest(),
      
    race (new RunPath(PathList.FULL_TRENCH_RUN.ZOOM), new Load()),
    new Load(1),
    new RunPath(PathList.FULL_TRENCH_RUN.ZOOM_BACK),
    new FastBallWithHintOfLime()
    );
  }
}