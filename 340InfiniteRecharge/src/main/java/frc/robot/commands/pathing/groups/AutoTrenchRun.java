/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.GetSmol;
import frc.robot.commands.Harvester.IntakeBalls;
import frc.robot.commands.Harvester.StopIntake;
import frc.robot.commands.LimelightCommands.AutoAlign;
import frc.robot.commands.Shooter.LowerCobraHood;
import frc.robot.commands.Shooter.PrepHoodShot;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.Shooter.SmartLimeShot;
import frc.robot.commands.SnekLoader.Load;
import frc.robot.commands.SnekLoader.StopSnek;
import frc.robot.commands.pathing.RunPath;
import frc.robot.commands.pathing.PathList.TRENCH_RUN;
import frc.robot.subsystems.Harvester;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoTrenchRun extends SequentialCommandGroup {
  /**
   * Creates a new AutoTrenchRun.
   */
  public AutoTrenchRun() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
    new PrepHoodShot(0),
    race(new RunPath(TRENCH_RUN.TEST_TRENCH_PATH_TWO), new Load()),
    new StopIntake(),
     new StopSnek(), //race runs two commands in parallel and finishes when one command finishes
    //new RunPath(TRENCH_RUN.BACKWARDS_TWO_BALL), 
     new AutoAlign(),
     new SmartLimeShot(),
     new LowerCobraHood()
    // race(new RunPath(TRENCH_RUN.TWO_BALL_STEAL), new Load())
    );
  }
}
