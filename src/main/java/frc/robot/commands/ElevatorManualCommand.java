package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorManualCommand extends CommandBase{
        
        private final ElevatorSubsystem m_elevatorSubsystem;
        double speed;
        XboxController manualControl;

        public ElevatorManualCommand(ElevatorSubsystem esubsystem, XboxController operatorController) {
            m_elevatorSubsystem = esubsystem;
            addRequirements(m_elevatorSubsystem);
            manualControl = operatorController;
          }
          @Override
          public void initialize(){}

          // Called when the command is initially scheduled.
          @Override
          public void execute() {
            m_elevatorSubsystem.moveManual(manualControl);
          }
        
          @Override
          public boolean isFinished() {
            return false;
          }
  }