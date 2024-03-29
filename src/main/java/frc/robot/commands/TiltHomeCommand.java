package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TiltSubsystem;

public class TiltHomeCommand extends CommandBase{
    private final TiltSubsystem m_tiltSubsystem;
    private final XboxController m_controller;

        public TiltHomeCommand(TiltSubsystem subsystem, XboxController controller) {
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
            m_tiltSubsystem.tiltHome();
         }
          @Override
          public boolean isFinished() {
            return m_tiltSubsystem.getManualInput(m_controller) != 0;
          }
}
