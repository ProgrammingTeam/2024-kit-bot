// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.ShootCmd;
import frc.robot.commands.ShootCmd.ShootModes;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootDriveAuto extends SequentialCommandGroup {
  public ShootDriveAuto(DriveTrain m_DriveTrain, ShooterSub m_ShooterSub) {

    addCommands(

    Commands.race(
      new ShootCmd(m_ShooterSub, ShootModes.SpinUp),
      Commands.waitSeconds(1)),
    Commands.race(
      new ShootCmd(m_ShooterSub, ShootModes.Shoot),
      Commands.waitSeconds(0.5)),
    new AutoDrive(m_DriveTrain, 5, false)
    );
    // addCommands(new FooCommand(), new BarCommand());
    addCommands();
  }
}
