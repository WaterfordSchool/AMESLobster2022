// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.commands.SpinnyIntakeCommand;
import frc.robot.commands.TiltForCommand;
import frc.robot.commands.TiltHomeCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SpinnySubsystem;
import frc.robot.subsystems.TiltSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  XboxController driver = new XboxController(0);
  XboxController operator = new XboxController(1);
  // The robot's subsystems and commands are defined here...
  
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final SpinnySubsystem m_SpinnySubsystem = new SpinnySubsystem();
  private final TiltSubsystem m_tiltSubsystem = new TiltSubsystem();

  private final ArcadeDrive m_arcadeFastDrive = new ArcadeDrive(m_driveTrain, 1, driver);
  private final ArcadeDrive m_arcadeSlowDrive = new ArcadeDrive(m_driveTrain, 0.3, driver);
  private final SpinnyIntakeCommand m_intake = new SpinnyIntakeCommand(m_SpinnySubsystem);
  private final SpinCommand m_spinRight = new SpinCommand(m_SpinnySubsystem, true);
  private final SpinCommand m_spinLeft = new SpinCommand(m_SpinnySubsystem, false);
  private final TiltHomeCommand m_tiltHome = new TiltHomeCommand(m_tiltSubsystem);
  private final TiltForCommand m_tiltFor = new TiltForCommand(m_tiltSubsystem);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //driverControllerButtons
    JoystickButton fastButton = new JoystickButton(driver, 1);
    JoystickButton slowButton = new JoystickButton(driver, 2);
    JoystickButton intakeButton = new JoystickButton(operator, Constants.intakeBucketButton);
    JoystickButton spinLeftButton = new JoystickButton(operator, Constants.spinLeftButton);
    JoystickButton spinRightButton = new JoystickButton(operator, Constants.spinRightButton);
    JoystickButton tiltForButton = new JoystickButton(operator, Constants.tiltScoreButton);
    JoystickButton tiltHomeButton = new JoystickButton(operator, Constants.tiltHomeButton);

    fastButton.whenPressed(m_arcadeFastDrive);
    slowButton.whenPressed(m_arcadeSlowDrive);
    intakeButton.whenPressed(m_intake);
    spinLeftButton.whenPressed(m_spinLeft);
    spinRightButton.whenPressed(m_spinRight);
    tiltForButton.whenPressed(m_tiltFor);
    tiltHomeButton.whenPressed(m_tiltHome);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
