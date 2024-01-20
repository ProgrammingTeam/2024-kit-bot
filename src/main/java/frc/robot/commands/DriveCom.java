// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.lang.Math;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class DriveCom extends Command {
   private final DriveTrain m_Drive;
   private final CommandXboxController m_xbox; 
  /** Creates a new DriveCom. */
  public DriveCom(DriveTrain drive, CommandXboxController xboxController) {
    m_Drive = drive;
    m_xbox = xboxController;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Drive.setMotors(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.setMotors((Math.signum(-m_xbox.getRawAxis(1)) * (-m_xbox.getRawAxis(1) * -m_xbox.getRawAxis(1))), 
                      (Math.signum(-m_xbox.getRawAxis(5)) * (-m_xbox.getRawAxis(5) * -m_xbox.getRawAxis(5))));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
