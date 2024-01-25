// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {
  CANSparkMax upperShooter = new CANSparkMax(Constants.upperShooterID, MotorType.kBrushless);
  CANSparkMax lowerShooter = new CANSparkMax(Constants.lowerShooterID, MotorType.kBrushless);
  DigitalInput IntakeLimiterSwitch = new DigitalInput(Constants.IntakeLimiterSwitch);

  /** Creates a new LaunchSub. */
  public ShooterSub() {
  }

  public void setLaunchMotors(double lowerShooterSpeed, double upperShooterSpeed) {
    if (IntakeLimiterSwitch.get() == true) {
      lowerShooter.set(lowerShooterSpeed);
      upperShooter.set(upperShooterSpeed);
    } else {
      lowerShooter.set(clamper(lowerShooterSpeed, 0.0, 1.0));
      upperShooter.set(clamper(upperShooterSpeed, 0.0, 1.0));
    }
  }

  private double clamper(double val, double min, double max) {
    if (val > max)
      return max;
    if (val < min)
      return min;
    return val;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
