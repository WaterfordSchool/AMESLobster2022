package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class TiltForCommand extends CommandBase{
        
        private final TiltSubsystem m_tiltSubsystem;

        public TiltForCommand(TiltSubsystem subsystem) {
            m_tiltSubsystem = subsystem;
            addRequirements(m_tiltSubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {
            //m_tiltSubsystem.tiltForward();
          }
        
          @Override
          public boolean isFinished() {
            return true;
          }
      }