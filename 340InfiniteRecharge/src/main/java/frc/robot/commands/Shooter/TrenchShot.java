/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TrenchShot extends SequentialCommandGroup {
  /**
   * Creates a new TrenchShot.
   */
  public TrenchShot() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    //Puts up hood, aims, shoots all balls, stops shooter and loader wheels
   // super(new RaiseCobraHood(), new Shoot(numToShoot, Constants.TRENCH_SHOT_RPM));
  }
}
