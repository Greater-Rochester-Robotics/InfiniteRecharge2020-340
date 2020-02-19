/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Harvester.IntakeBalls;
import frc.robot.commands.LimelightCommands.AutoAlign;
import frc.robot.commands.Shooter.SmartLimeShot;
import frc.robot.commands.pathing.RunPath;
import frc.robot.commands.pathing.PathList.TRENCH_RUN;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoTrenchRun6 extends SequentialCommandGroup {
  /**
   * Creates a new AutoTrenchRun6.
   */
  public AutoTrenchRun6() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new SmartLimeShot(),
      race(new RunPath(TRENCH_RUN.THREE_BALL), new IntakeBalls()),
      // new RunPath(TRENCH_RUN.BACKWARDS_THREE_BALL),
      new AutoAlign(),
      new SmartLimeShot()
    );
  }
}
