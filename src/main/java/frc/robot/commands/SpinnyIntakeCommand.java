package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnySubsystem;
import frc.robot.subsystems.TiltSubsystem;

public class SpinnyIntakeCommand extends CommandBase{
        
        private final SpinnySubsystem m_spinnySubsystem;

        public SpinnyIntakeCommand(SpinnySubsystem subsystem) {
            m_spinnySubsystem = subsystem;
            addRequirements(m_spinnySubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {
          }
        
          @Override
        public void execute() {
            m_spinnySubsystem.intake();
        }

            // Called once the command ends or is interrupted.
        @Override
        public void end(boolean interrupted) {
            m_spinnySubsystem.stop();
        }

            // Returns true when the command should end.
        @Override
        public boolean isFinished() {
           return true;
         }
      }