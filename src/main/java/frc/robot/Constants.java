// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

public static final int FRMotorID = 4;
public static final int FLMotorID = 2;
public static final int RLMotorID = 3;
public static final int RRMotorID = 5;
public static final int lowerShooterID = 6;
public static final int upperShooterID = 7;
public static final int IntakeLimiterSwitch = 7;

  public static class MotorConstants {
    public static final double ExteriorShooterSpeedSpeakerShot = 0.77                                                                                                                                                                                                                                                                                                                                                                                                         5; //Speaker Shooter Variable
    public static final double ExteriorShooterSpeedAmpShot = 0.25; // Amp Variable Variable
    public static final double InteriorShooterSpeedSpeakerShot = 0.775; //Speaker Shooter Variable
    public static final double InteriorShooterSpeedAmpShot = 0.25; // Amp Variable Variable
    public static final double IntakeShooterSpeed = 0.20; 
    public static final double RampingSpeakerShot = 0.775; //Ramping Speed for Speaker Shot
    public static final double RampingAmpShot = 0.25; //Ramping Spead for Amp Shot
    public static final double RampingVarible = 0.0; //Temporary!!
    public static final double ExteriorShooterSpeedVariable = 0.0; //Temporary!!
    public static final double InteriorShooterSpeedVariable = 0.0; //Temporary!!
    
    public static final double LeftAutoSpeed = 0.2;
    public static final double RightAutoSpeed = 0.2;

    public static final double GearRatio = 10.71;
    public static final int WheelDiameter = 6;
    public static final double MotorSpeedControler = 0.1;
  }
}
