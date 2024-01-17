// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {
  CANSparkMax upperShooter = new CANSparkMax(Constants.upperShooterID, MotorType.kBrushless);
  CANSparkMax lowerShooter = new CANSparkMax(Constants.lowerShooterID, MotorType.kBrushless);
  /** Creates a new LaunchSub. */
  public ShooterSub() {
  }
  
  public void setLaunchMotors(double lowerShooterSpeed, double upperShooterSpeed) {
    lowerShooter.set(lowerShooterSpeed);
    upperShooter.set(upperShooterSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
