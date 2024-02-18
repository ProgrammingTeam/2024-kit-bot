// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveCom extends Command {
  private final DriveTrain m_Drive;
  private final CommandJoystick m_LeftJoystick;
  private final CommandJoystick m_RightJoystick;
  private DifferentialDrive differentialDrive;
  /** Creates a new DriveCom. */
  public DriveCom(DriveTrain drive, CommandJoystick leftJoystick, CommandJoystick rightJoystick) {
    m_Drive = drive;
    m_LeftJoystick = leftJoystick;
    m_RightJoystick = rightJoystick;
    
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    differentialDrive = m_Drive.getDifferentialDrive();
    m_Drive.setMotors(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    differentialDrive.curvatureDrive(-m_LeftJoystick.getRawAxis(1) * ((-m_RightJoystick.getRawAxis(3) + 1) / 2),
       -m_RightJoystick.getRawAxis(0) * ((-m_RightJoystick.getRawAxis(3) + 1) / 2), true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
