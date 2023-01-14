// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private XboxController operator = new XboxController(1);
  private RobotContainer m_robotContainer;

  public final TalonFX spinLeft = new TalonFX(Constants.SPINNY1CANID);
    public final TalonFX spinRight = new TalonFX(Constants.SPINNY2CANID);
    CameraServer server;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.putVideo("blur", 420, 420);
    
  }

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();;
    }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
   if(operator.getRawButton(Constants.spinLeftButton)){
      spinLeft.set(ControlMode.PercentOutput, 0.4);
    }
    if(operator.getRawButton(Constants.spinRightButton)){
      spinRight.set(ControlMode.PercentOutput, -0.4);
    }
    if(!operator.getRawButton(Constants.spinLeftButton)){
      spinLeft.set(ControlMode.PercentOutput, 0);
    }
    if(!operator.getRawButton(Constants.spinRightButton)){
      spinRight.set(ControlMode.PercentOutput, 0);
    }
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
