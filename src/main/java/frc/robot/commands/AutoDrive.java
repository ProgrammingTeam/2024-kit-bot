// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.MotorConstants;
import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends Command {
  private final DriveTrain DriveSub;
  double MaxLeftDis;
  double MaxRightDis;
  double RLPosition;
  boolean MetDistance;
  private final boolean ForwardOrBackward;
  private final double DriveDistEncoderRotations;

  public AutoDrive(DriveTrain m_DriveTrain, double TotalDistanceIn, boolean Forward) {
    DriveSub = m_DriveTrain;
    DriveDistEncoderRotations = TotalDistanceIn * MotorConstants.GearRatio / (MotorConstants.WheelDiameter * Math.PI);
    ForwardOrBackward = Forward;

    addRequirements(DriveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveSub.resetEncoders();
    DriveSub.setMotors(0, 0);
    SmartDashboard.putBoolean("auto started", true);
    MetDistance = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RLPosition = DriveSub.RLEncoderPoll;
   
    if (ForwardOrBackward == true) {
      if (DriveDistEncoderRotations <= RLPosition) {
        DriveSub.setMotors(0, 0);
        MetDistance = true;
      } 
      
      else {
        DriveSub.setMotors(MotorConstants.LeftAutoSpeed, MotorConstants.RightAutoSpeed);
      }

    } else if (ForwardOrBackward == false) {
      if (-DriveDistEncoderRotations >= RLPosition) {

        DriveSub.setMotors(0, 0);
        MetDistance = true;
      } 
      
      else {
        DriveSub.setMotors(-MotorConstants.LeftAutoSpeed, -MotorConstants.RightAutoSpeed);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSub.setMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return MetDistance;
  }
}
