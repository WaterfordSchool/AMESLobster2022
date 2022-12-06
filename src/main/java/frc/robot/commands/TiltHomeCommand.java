package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class TiltHomeCommand extends CommandBase{
    private final TiltSubsystem m_tiltSubsystem;

        public TiltHomeCommand(TiltSubsystem subsystem) {
            m_tiltSubsystem = subsystem;
            addRequirements(m_tiltSubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {
            //m_tiltSubsystem.tiltHome();
          }
        
          @Override
          public boolean isFinished() {
            return true;
          }
}
