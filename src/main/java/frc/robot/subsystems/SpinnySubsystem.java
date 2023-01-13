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
    
      public SpinnySubsystem(XboxController operator) {
        spinLeft = new TalonFX(Constants.SPINNY1CANID);
        spinRight = new TalonFX(Constants.SPINNY2CANID);
        spinLeft.config_kP(0, 0.15);
        spinLeft.config_kF(0, 0);
        spinLeft.config_kI(0, 0);
        spinLeft.config_kD(0, 0);

        spinRight.config_kP(0, 0.15);
        spinRight.config_kF(0, 0);
        spinRight.config_kI(0, 0);
        spinRight.config_kD(0, 0);
      }
      
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      SmartDashboard.putNumber("spinny encoder left value", spinLeft.getSelectedSensorPosition());
      SmartDashboard.putNumber("spinny encoder right value", spinRight.getSelectedSensorPosition());
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
        spinLeft.set(ControlMode.Position, 200);
        spinRight.set(ControlMode.Position, -200);
    }

    public void resetEncoders(){
      spinLeft.setSelectedSensorPosition(0);
      spinRight.setSelectedSensorPosition(0);
    }
    
    public void stopSpin(){
        spinLeft.set(ControlMode.PercentOutput, 0);
        spinRight.set(ControlMode.PercentOutput, 0);
    }

    public void allSpin(XboxController control){
      /*spinLeft.set(ControlMode.PercentOutput, -.2*control.getRawAxis(1));
      spinRight.set(ControlMode.PercentOutput, .2*control.getRawAxis(1));*/
      if(control.getRawButton(5)){
        spinLeft.set(ControlMode.PercentOutput, -.2);
        spinRight.set(ControlMode.PercentOutput, -.2);
      }
      //spin right
      if(control.getRawButton(6)){
        spinRight.set(ControlMode.PercentOutput, .2);
        spinLeft.set(ControlMode.PercentOutput, .2);
      }
      if(control.getRawButton(3)){
        spinLeft.set(ControlMode.PercentOutput, 0.6);
        spinRight.set(ControlMode.PercentOutput, -0.6);
      }
      //while all buttons inactive
      if(!control.getRawButton(5) && !control.getRawButton(6) && !control.getRawButton(3)){
        //spit out
      if(control.getRawAxis(2)>0 ){
        spinLeft.set(ControlMode.PercentOutput, .25*control.getRawAxis(2));
        spinRight.set(ControlMode.PercentOutput, -.25*control.getRawAxis(2));
      }
      //intake
      if(control.getRawAxis(3)>0 ){
        spinLeft.set(ControlMode.PercentOutput, -.6*control.getRawAxis(3));
        spinRight.set(ControlMode.PercentOutput, .6*control.getRawAxis(3));
       }
       //TODO spin control
    }
  }
}
  