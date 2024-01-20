// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.MotorConstants;
import frc.robot.subsystems.ShooterSub;

public class ShootCmd extends Command {
  ShooterSub Shooter;
  ShootModes ShootSelection;
  double BottomMotor;
  double TopMotor;

  public ShootCmd(ShooterSub ShooterSystem, ShootModes Mode) {
    ShootSelection = Mode;
    Shooter = ShooterSystem;
    addRequirements(Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter.setLaunchMotors(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (ShootSelection) {
      case Shoot:
        BottomMotor = MotorConstants.InteriorShooterSpeed;
        TopMotor = MotorConstants.ExteriorShooterSpeed;
        break;
      case Load:
        BottomMotor = -MotorConstants.IntakeShooterSpeed;
        TopMotor = -MotorConstants.IntakeShooterSpeed;
        break;
      case SpinUp:
        BottomMotor = 0;
        TopMotor = MotorConstants.ExteriorShooterSpeed;
        break;
      // case 4:
      // BottomMotor = MotorConstants.InteriorShooterSpeed;
      // TopMotor = 0;
      // break;

      case DONOTHING:
        BottomMotor = 0;
        TopMotor = 0;
        break;

      default:
        BottomMotor = 0;
        TopMotor = 0;
        break;
    }
    Shooter.setLaunchMotors(BottomMotor, TopMotor);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.setLaunchMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public enum ShootModes {
    SpinUp,
    Shoot,
    Load,
    DONOTHING;
  }
}
