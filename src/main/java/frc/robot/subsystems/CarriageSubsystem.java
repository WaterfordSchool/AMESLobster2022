package frc.robot.subsystems;

import javax.management.relation.Relation;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CarriageSubsystem extends SubsystemBase{
    public CarriageSubsystem() {}
    TalonSRX carriage = new TalonSRX(Constants.CARRIAGECANID);
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void resetCarriageEncoder(){

  }

  public void moveUpSet(){
    carriage.set(ControlMode.Position, demand);
    }
  
  public void configCarriage(){
    carriage.setSensorPhase(Constants.kSensorPhase);
    carriage.setInverted(Constants.kMotorInvert);
    carriage.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    carriage.config_kF(Constants.kPIDLoopIdx, Constants.kF, Constants.kTimeoutMs);
    carriage.config_kP(Constants.kPIDLoopIdx, Constants.kP, Constants.kTimeoutMs);
    carriage.config_kI(Constants.kPIDLoopIdx, Constants.kI, Constants.kTimeoutMs);
    carriage.config_kD(Constants.kPIDLoopIdx, Constants.kD, Constants.kTimeoutMs);
  }
}
