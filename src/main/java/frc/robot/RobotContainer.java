// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//TODO: run the manual elevator command
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ElevatorManualCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeDefaultCommand;
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
  private final SpinnySubsystem m_SpinnySubsystem = new SpinnySubsystem(operator);
  //tilt
  //private final TiltSubsystem m_tiltSubsystem = new TiltSubsystem();
  private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

  private final ArcadeDrive m_arcadeFastDrive = new ArcadeDrive(m_driveTrain, 1, driver);
  private final ArcadeDrive m_arcadeSlowDrive = new ArcadeDrive(m_driveTrain, 0.3, driver);
  private final ArcadeDrive m_arcadeDefault = new ArcadeDrive(m_driveTrain, 0.8, driver);
  //private final IntakeDefaultCommand m_defaultintake = new IntakeDefaultCommand(m_SpinnySubsystem);
  private final SpinCommand m_spinAll = new SpinCommand(m_SpinnySubsystem, operator);
  //private final IntakeCommand m_intake = new IntakeCommand(m_SpinnySubsystem);
  /*private final SpinCommand m_spinRight = new SpinCommand(m_SpinnySubsystem, 0);
  private final SpinCommand m_spinLeft = new SpinCommand(m_SpinnySubsystem, 1);
  private final SpinCommand m_spinDefault = new SpinCommand(m_SpinnySubsystem, 2);*/
  //private final TiltForCommand m_tiltFor = new TiltForCommand(m_tiltSubsystem);
  private final ElevatorManualCommand m_elevatorManualCommand = new ElevatorManualCommand(m_elevatorSubsystem, operator);
  
  //tilt
  /*private final TiltForCommand m_tiltForCommand = new TiltForCommand(m_tiltSubsystem);
  private final TiltHomeCommand m_tiltHomeCommand = new TiltHomeCommand(m_tiltSubsystem);*/
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(m_arcadeDefault);
    m_SpinnySubsystem.setDefaultCommand(m_spinAll);
    //m_tiltSubsystem.setDefaultCommand(new TiltManual(m_tiltSubsystem, operator));
    m_elevatorSubsystem.setDefaultCommand(m_elevatorManualCommand);
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
    /*JoystickButton spinLeftButton = new JoystickButton(operator, Constants.spinLeftButton);
    JoystickButton spinRightButton = new JoystickButton(operator, Constants.spinRightButton);*/
    JoystickButton moveUpTiltButton = new JoystickButton(operator, Constants.moveUpTiltButton);
    JoystickButton carriageDownSlightButton = new JoystickButton(operator, Constants.carriageDownSlightButton);
    JoystickButton moveDownButton = new JoystickButton(operator, Constants.moveDownButton);
    JoystickButton tiltForButton = new JoystickButton(operator, 1);
    JoystickButton tiltHomeButton = new JoystickButton(operator, 2);

    fastButton.whenPressed(m_arcadeFastDrive);
    slowButton.whenPressed(m_arcadeSlowDrive);
    //tiltForButton.whenPressed(new TiltForCommand(m_tiltSubsystem));
    //tiltHomeButton.whenPressed(new TiltHomeCommand(m_tiltSubsystem));
    /*if(operator.getRawAxis(5)!=0){
      new TiltManual(m_tiltSubsystem, operator);
    }*/
    
    //intakeButton.whenPressed(m_spinIntake).whenReleased(m_defaultintake);
    //spinLeftButton.whenPressed(m_spinLeft).whenReleased(m_defaultintake);
    //spinLeftButton.whenReleased(m_defaultintakeleft);
    //spinRightButton.whenPressed(m_spinRight).whenReleased(m_defaultintake);
    //spinRightButton.whenReleased(m_defaultintakeright);
    //spinLeftButton.whenPressed(new SpinCommand(m_SpinnySubsystem, 1)).whenReleased(new IntakeDefaultCommand(m_SpinnySubsystem));
    //spinRightButton.whenPressed(new SpinCommand(m_SpinnySubsystem, 0)).whenReleased(new IntakeDefaultCommand(m_SpinnySubsystem));*/

    
    //spinLeftButton.whenPressed(m_spinLeft);
    //spinRightButton.whenPressed(m_spinRight);
    //moveUpTiltButton.whenPressed(new SequentialCommandGroup(m_elevatorUp, m_tiltFor));
    //carriageDownSlightButton.whenPressed(m_elevatorDownSlight);
    //moveDownButton.whenPressed(m_elevatorDownFull);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
