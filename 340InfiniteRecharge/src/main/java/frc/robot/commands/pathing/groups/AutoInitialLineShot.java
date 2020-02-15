/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Harvester.IntakeBalls;
import frc.robot.commands.Harvester.SetHarvesterDown;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoInitialLineShot extends SequentialCommandGroup {
  /**
   * Creates a new AutoInitialLineShot.
   */
  public AutoInitialLineShot() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    //Needs revisions so make it more accurate. Make command to set the snek state machine to kFillTo3
    // super(new Shoot(), new SetHarvesterDown(), new IntakeBalls() ,new RunPath(PathList.TRENCH_RUN.RIGHT_LINE_ONE), new RunPath(PathList.TRENCH_RUN.INTIAL_LINE_SHOT));
  }
}
