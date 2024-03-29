package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnySubsystem;

public class SpinCommand extends CommandBase{
        
        private final SpinnySubsystem m_spinnySubsystem;
        private final XboxController spinController;

        public SpinCommand(SpinnySubsystem subsystem, XboxController controller) {
            m_spinnySubsystem = subsystem;
            spinController = controller;
            addRequirements(m_spinnySubsystem);
          }
        
          // Called when the command is initially scheduled.
          @Override
          public void initialize() {

          }
        
          @Override
        public void execute() {
            /*if(isrld == 0){
                m_spinnySubsystem.spinRight();
            }
            if(isrld == 1){
                m_spinnySubsystem.spinLeft();
            }
            if(isrld == 2){
                m_spinnySubsystem.spinRight();
                m_spinnySubsystem.spinLeft();
            }*/
            m_spinnySubsystem.allSpin(spinController);
        }

            // Called once the command ends or is interrupted.
        /*@Override
        public void end(boolean interrupted) {
            if(isrld == 0){
                m_spinnySubsystem.spinStopRight();
            }
            if(isrld == 1){
                m_spinnySubsystem.spinStopLeft();
            }
            if(isrld == 2){
                m_spinnySubsystem.spinStopLeft();
                m_spinnySubsystem.spinStopRight();
            }
            m_spinnySubsystem.stopSpin();
        }*/

            // Returns true when the command should end.
        @Override
        public boolean isFinished() {
           return false;
         }
      }