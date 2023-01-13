package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class TiltForCommand extends CommandBase{
        
        private final TiltSubsystem m_tiltSubsystem;
        private final XboxController m_controller;

        public TiltForCommand(TiltSubsystem subsystem, XboxController controller) {
            m_tiltSubsystem = subsystem;
            m_controller = controller;
            addRequirements(m_tiltSubsystem);
          }

          @Override
          public void initialize() {
          }
        
          @Override
          public void execute() {
            m_tiltSubsystem.tiltForward();
          }
        
          @Override
          public boolean isFinished() {
            return m_tiltSubsystem.getManualInput(m_controller) != 0;
          }
      }