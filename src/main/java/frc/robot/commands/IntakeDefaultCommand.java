package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnySubsystem;
import frc.robot.subsystems.TiltSubsystem;

public class IntakeDefaultCommand extends CommandBase{
        
        private final SpinnySubsystem m_spinnySubsystem;
        
        public IntakeDefaultCommand(SpinnySubsystem subsystem) {
            m_spinnySubsystem = subsystem;
            addRequirements(m_spinnySubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {
          }
        
          @Override
        public void execute() {
                m_spinnySubsystem.stopSpin();
            
       }

            // Called once the command ends or is interrupted.
        @Override
        public void end(boolean interrupted) {
        }

            // Returns true when the command should end.
        @Override
        public boolean isFinished() {
           return false;
         }
      }