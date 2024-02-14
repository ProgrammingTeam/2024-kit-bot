// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ShootCmd;
import frc.robot.commands.autos.*;
import frc.robot.commands.DriveCom;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LimelightDriveCom;
import frc.robot.commands.LineUpCom;
import frc.robot.commands.ShootCmd.ShootModes;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSub;
import frc.robot.subsystems.ShooterSub;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain m_DriveSub = new DriveTrain();
  private final ShooterSub m_ShooterSub = new ShooterSub();
  private final LimelightSub m_LimelightSub = new LimelightSub();
  private final SendableChooser<AutoSelector> autoChooser = new SendableChooser<>();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    m_DriveSub.setDefaultCommand(new DriveCom(m_DriveSub, m_driverController));
    m_ShooterSub.setDefaultCommand(new ShootCmd(m_ShooterSub, ShootModes.DONOTHING));

    autoChooser.setDefaultOption("Nothing", AutoSelector.DoNothing);
    autoChooser.addOption("Shoot n Drive", AutoSelector.ShootDriveAuto);
    autoChooser.addOption("Driving Back", AutoSelector.BackAuto);
    SmartDashboard.putData(autoChooser);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_driverController.y().whileTrue(new ShootCmd(m_ShooterSub, ShootModes.Shoot));
    m_driverController.a().whileTrue(new ShootCmd(m_ShooterSub, ShootModes.Load));
    m_driverController.b().whileTrue(new ShootCmd(m_ShooterSub, ShootModes.SpinUp));
    m_driverController.x().whileTrue(new ShootCmd(m_ShooterSub, ShootModes.AmpShot));
    m_driverController.button(1).whileTrue(new LimelightDriveCom(m_DriveSub, m_LimelightSub));
    m_driverController.button(1).whileTrue(new LineUpCom(m_DriveSub, m_LimelightSub));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    switch (autoChooser.getSelected()) {
      case ShootDriveAuto:
        return new ShootDriveAuto(m_DriveSub, m_ShooterSub);

      case BackAuto:
        return new BackAutoDrive(m_DriveSub);

      case DoNothing:
        return new DoNothing();
      default:
        return new DoNothing();
    }

  }
}
