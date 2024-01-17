// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
  CANSparkMax FLMotor = new CANSparkMax(Constants.FLMotorID, MotorType.kBrushless);
  CANSparkMax FRMotor = new CANSparkMax(Constants.FRMotorID, MotorType.kBrushless);
  CANSparkMax RLMotor = new CANSparkMax(Constants.RLMotorID, MotorType.kBrushless);
  CANSparkMax RRMotor = new CANSparkMax(Constants.RRMotorID, MotorType.kBrushless);
   
  /** Creates a new DriveSub. */
  public DriveSub() {
     FLMotor.follow(RLMotor);
     FRMotor.follow(RRMotor);
    RRMotor.setInverted(true);
  }

  public void setMotors(double leftSpeed, double rightSpeed) {
    RLMotor.set(leftSpeed);
    RRMotor.set(rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
