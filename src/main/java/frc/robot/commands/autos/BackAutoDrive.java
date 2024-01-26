// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BackAutoDrive extends SequentialCommandGroup {
  /** Creates a new BackAutoDrive. */
  public BackAutoDrive(DriveTrain m_DriveTrain, ShooterSub m_ShooterSub) {

    addCommands(
        new AutoDrive(m_DriveTrain, 5, false));
  }
}
