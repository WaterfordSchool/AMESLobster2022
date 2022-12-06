package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinnySubsystem extends SubsystemBase{
    public final TalonFX spinLeft;
    public final TalonFX spinRight;
   
      public SpinnySubsystem() {
        spinLeft = new TalonFX(Constants.SPINNY1CANID);
        spinRight = new TalonFX(Constants.SPINNY2CANID);
      }
      
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    public void spinLeft(){
        spinLeft.set(ControlMode.PercentOutput, -0.25);
        spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void spinRight(){
        spinRight.set(ControlMode.PercentOutput, 0.25);
        spinLeft.set(ControlMode.PercentOutput, 0);

    }

    public void intake(){
        spinLeft.set(ControlMode.PercentOutput, -0.25);
        spinRight.set(ControlMode.PercentOutput, 0.25);
    }
    
    public void stopSpin(){
        spinLeft.set(ControlMode.PercentOutput, 0);
        spinRight.set(ControlMode.PercentOutput, 0);
    }

  }
  