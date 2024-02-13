// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.MotorConstants;

public class DriveTrain extends SubsystemBase {
  public double RLEncoderPoll;
  CANSparkMax FLMotor = new CANSparkMax(Constants.FLMotorID, MotorType.kBrushless);
  CANSparkMax FRMotor = new CANSparkMax(Constants.FRMotorID, MotorType.kBrushless);
  CANSparkMax RLMotor = new CANSparkMax(Constants.RLMotorID, MotorType.kBrushless);
  CANSparkMax RRMotor = new CANSparkMax(Constants.RRMotorID, MotorType.kBrushless);
  DifferentialDrive Curvature = new DifferentialDrive(RLMotor, RRMotor);
  RelativeEncoder RLEncoder = RLMotor.getEncoder();

  /** Creates a new DriveSub. */
  public DriveTrain() {
    FLMotor.follow(RLMotor);
    FRMotor.follow(RRMotor);

  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    Curvature.curvatureDrive(leftSpeed, rightSpeed, false);
  }

  @Override
  public void periodic() {
    RLEncoderPoll = RLEncoder.getPosition();
    SmartDashboard.putNumber("DriveDistEncoderRotations", 5 / (MotorConstants.WheelDiameter * Math.PI * MotorConstants.GearRatio));
    SmartDashboard.putNumber("Encoder", RLEncoderPoll);
  }

  public void resetEncoders() {
    RLEncoder.setPosition(0);
  }
}
