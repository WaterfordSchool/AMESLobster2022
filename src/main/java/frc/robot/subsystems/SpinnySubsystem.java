package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinnySubsystem extends SubsystemBase{
    public final TalonFX spinLeft;
    public final TalonFX spinRight;
    XboxController spinOperator;
    
      public SpinnySubsystem(XboxController operator) {
        spinLeft = new TalonFX(Constants.SPINNY1CANID);
        spinRight = new TalonFX(Constants.SPINNY2CANID);
        operator = spinOperator;
      }
      
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    public void spinLeft(){
        spinLeft.set(ControlMode.PercentOutput, -0.25);
        //spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void spinRight(){
        spinRight.set(ControlMode.PercentOutput, 0.25);
        //spinLeft.set(ControlMode.PercentOutput, 0);

    }

    public void spinStopLeft(){
      spinLeft.set(ControlMode.PercentOutput, 0);
    }

    public void spinStopRight(){
      spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void intake(){
        spinLeft.set(ControlMode.PercentOutput, -0.25);
        spinRight.set(ControlMode.PercentOutput, 0.25);
    }
    
    public void stopSpin(){
        spinLeft.set(ControlMode.PercentOutput, 0);
        spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void allSpin(){
      if(spinOperator.getRawButton(5)){
        spinLeft.set(ControlMode.PercentOutput, -.2);
        spinRight.set(ControlMode.PercentOutput, -.2);
      }
      //spin right
      if(spinOperator.getRawButton(6)){
        spinRight.set(ControlMode.PercentOutput, .2);
        spinLeft.set(ControlMode.PercentOutput, .2);
      }
      if(spinOperator.getRawButton(3)){
        spinLeft.set(ControlMode.PercentOutput, 0.6);
        spinRight.set(ControlMode.PercentOutput, -0.6);
      }
      
      
      //while all buttons inactive
      if(!spinOperator.getRawButton(5) && !spinOperator.getRawButton(6) && !spinOperator.getRawButton(3)){
        //spit out
      if(spinOperator.getRawAxis(2)>0 ){
        spinLeft.set(ControlMode.PercentOutput, .25*spinOperator.getRawAxis(2));
        spinRight.set(ControlMode.PercentOutput, -.25*spinOperator.getRawAxis(2));
      }
      //intake
      if(spinOperator.getRawAxis(3)>0 ){
        spinLeft.set(ControlMode.PercentOutput, -.6*spinOperator.getRawAxis(3));
        spinRight.set(ControlMode.PercentOutput, .6*spinOperator.getRawAxis(3));
       }
    }
  }
}
  