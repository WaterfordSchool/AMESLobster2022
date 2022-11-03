package frc.robot.subsystems;

import javax.management.relation.Relation;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CarriageSubsystem extends SubsystemBase{
  public final TalonSRX carriage;
    public CarriageSubsystem() {
      carriage = new TalonSRX(Constants.CARRIAGECANID);
      carriage.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
      carriage.setSensorPhase(Constants.carriagekSensorPhase);
      carriage.setInverted(Constants.carriagekMotorInvert);
      carriage.configAllowableClosedloopError(0, Constants.carriagekPIDLoopIdx, Constants.kTimeoutMs);
      carriage.config_kF(Constants.carriagekPIDLoopIdx, Constants.carriagekF, Constants.kTimeoutMs);
      carriage.config_kP(Constants.carriagekPIDLoopIdx, Constants.carriagekP, Constants.kTimeoutMs);
      carriage.config_kI(Constants.carriagekPIDLoopIdx, Constants.carriagekI, Constants.kTimeoutMs);
      carriage.config_kD(Constants.carriagekPIDLoopIdx, Constants.carriagekD, Constants.kTimeoutMs);

    }
    
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void resetCarriageEncoder(){

  }

  public void moveUpSet(){
    carriage.set(ControlMode.Position, demand);
    }
 
}
