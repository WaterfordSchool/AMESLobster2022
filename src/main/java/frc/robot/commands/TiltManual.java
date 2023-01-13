package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class TiltManual extends CommandBase{
    private final TiltSubsystem m_tiltSubsystem;
    private final XboxController m_controller;

        public TiltManual(TiltSubsystem subsystem, XboxController controller) {
            m_tiltSubsystem = subsystem;
            m_controller = controller;
            addRequirements(m_tiltSubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {
          }
          @Override
          public void execute() {
            m_tiltSubsystem.manualTilt(m_controller);
         }

         @Override
         public void end(boolean interrupted) {
         }

          @Override
          public boolean isFinished() {
            return false;
          }
}
