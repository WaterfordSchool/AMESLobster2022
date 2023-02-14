// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.ElevatorManualCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.TiltForCommand;
import frc.robot.commands.TiltHomeCommand;
import frc.robot.commands.TiltManual;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.SpinnySubsystem;
import frc.robot.subsystems.TiltSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  XboxController driver = new XboxController(0);
  XboxController operator = new XboxController(1);
  // The robot's subsystems and commands are defined here...
  
  //subsystems
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final SpinnySubsystem m_SpinnySubsystem = new SpinnySubsystem(operator);
  //tilt
  private final TiltSubsystem m_tiltSubsystem = new TiltSubsystem();

  private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  private final ArcadeDrive m_arcadeFastDrive = new ArcadeDrive(m_driveTrain, 1, driver);
  private final ArcadeDrive m_arcadeSlowDrive = new ArcadeDrive(m_driveTrain, 0.3, driver);
  private final ArcadeDrive m_arcadeDefault = new ArcadeDrive(m_driveTrain, 0.8, driver);

  private final ElevatorManualCommand m_elevatorManualCommand = new ElevatorManualCommand(m_elevatorSubsystem, operator);
  private final TiltManual m_tiltManualCommand = new TiltManual(m_tiltSubsystem, operator);


  private final SequentialCommandGroup comboCommand = new SequentialCommandGroup(new TiltForCommand(m_tiltSubsystem, operator), new WaitCommand(1), new TiltHomeCommand(m_tiltSubsystem, operator), new WaitCommand(1), new TiltForCommand(m_tiltSubsystem, operator));
  private final ParallelCommandGroup betterComboCommand = new ParallelCommandGroup(new ElevatorUpCommand(m_elevatorSubsystem).withTimeout(1), comboCommand);
  
  //auto
  private final AutoDrive m_autoDriveForward1 = new AutoDrive(m_driveTrain, 2, .4, 0);
  private final AutoDrive m_autoDriveForward2 = new AutoDrive(m_driveTrain, 2, 0, .5);
  private final AutoDrive m_autoDriveForward3 = new AutoDrive(m_driveTrain, 2, .4, 0);
  private final AutoDrive m_autoDriveForward4 = new AutoDrive(m_driveTrain, 2, -.7, 0);
  //private final SequentialCommandGroup auto = new SequentialCommandGroup(m_autoDriveForward1, m_autoDriveForward2, m_autoDriveForward3, m_autoDriveForward4);

  private final AutoDrive m_driveForward = new AutoDrive(m_driveTrain, 1, .5, 0);
  private final AutoDrive m_spinALot = new AutoDrive(m_driveTrain, 1, 0, .5);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(m_arcadeDefault);
    m_tiltSubsystem.setDefaultCommand(m_tiltManualCommand);
    m_elevatorSubsystem.setDefaultCommand(m_elevatorManualCommand);
    m_chooser.setDefaultOption("forward", m_driveForward);
    m_chooser.addOption("spin", m_spinALot);
    SmartDashboard.putData("autos", m_chooser);
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
    /*JoystickButton spinLeftButton = new JoystickButton(operator, Constants.spinLeftButton);
    JoystickButton spinRightButton = new JoystickButton(operator, Constants.spinRightButton);*/
    JoystickButton tiltForButton = new JoystickButton(operator, 1);
    JoystickButton tiltHomeButton = new JoystickButton(operator, 2);
    JoystickButton comboButton = new JoystickButton(operator, Constants.combo);

    fastButton.whenPressed(m_arcadeFastDrive);
    slowButton.whenPressed(m_arcadeSlowDrive);
    tiltForButton.whileHeld(new TiltForCommand(m_tiltSubsystem, operator));
    tiltHomeButton.whileHeld(new TiltHomeCommand(m_tiltSubsystem, operator));
    comboButton.whenPressed(betterComboCommand);
    tiltHomeButton.whenInactive(new TiltManual(m_tiltSubsystem, operator));
    tiltForButton.whenInactive(new TiltManual(m_tiltSubsystem, operator));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}