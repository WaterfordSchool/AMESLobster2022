// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ElevatorUpCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ElevatorSubsystem m_elevatorSubsystem;


  public ElevatorUpCommand(ElevatorSubsystem carriageSub) {
    m_elevatorSubsystem = carriageSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(carriageSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_elevatorSubsystem.moveUp();
  }

 // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
