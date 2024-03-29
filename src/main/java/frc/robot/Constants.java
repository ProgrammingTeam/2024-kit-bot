// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int LJoystickID = 1;
    public static final int RJoystickID = 2;
  }


public static final int FRMotorID = 4;
public static final int FLMotorID = 2;
public static final int RLMotorID = 3;
public static final int RRMotorID = 5;
public static final int lowerShooterID = 7;
public static final int upperShooterID = 6;
public static final int IntakeLimiterSwitch = 7;

  
  public static class LimelightConstants{
    public static final int limelightHeight = 31;
    public static final double angleOffset = 0;
   
    public static final double kp = 0;
    public static final double DriveSpeed = 0;

    public static final double LimeDistFromFront = 33;
    public static final double[] targetHeights = {0, 53.375, 53.375, 58.125, 58.125, 53.375, 53.375, 58.125, 58.125, 53.375, 53.375, 52.75, 52.75, 52.75, 52.75, 52.75, 52.75};
    public static final double[] targetDistence = {0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  }
  public static class MotorConstants {
    public static final double ExteriorShooterSpeed = 1.0;
    public static final double InteriorShooterSpeed = 1.0;
    public static final double IntakeShooterSpeed = 0.50;

    public static final double LeftAutoSpeed = 0.15;
    public static final double RightAutoSpeed = 0.15;

    public static final double GearRatio = 10.71;
    public static final int WheelDiameter = 6;
    public static final double MotorSpeedControler = 0.1;
  }
}
