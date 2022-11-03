package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class TiltSubsystem extends SubsystemBase{
  public final TalonFX tilt;
  public final TalonFXSensorCollection tiltEncoder;
    public TiltSubsystem() {
      tilt = new TalonFX(0);
      tiltEncoder = tilt.getSensorCollection();
      tilt.setSensorPhase(Constants.tiltkSensorPhase);
      tilt.setInverted(Constants.carriagekMotorInvert);
      tilt.configAllowableClosedloopError(0, Constants.carriagekPIDLoopIdx, Constants.kTimeoutMs);
      tilt.config_kF(Constants.tiltkPIDLoopIdx, Constants.tiltkF, Constants.kTimeoutMs);
      tilt.config_kP(Constants.tiltkPIDLoopIdx, Constants.tiltkP, Constants.kTimeoutMs);
      tilt.config_kI(Constants.tiltkPIDLoopIdx, Constants.tiltkI, Constants.kTimeoutMs);
      tilt.config_kD(Constants.tiltkPIDLoopIdx, Constants.tiltkD, Constants.kTimeoutMs);
    }
    
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("tilt encoder relative ticks", tiltEncoder.getIntegratedSensorPosition());
    SmartDashboard.putNumber("tilt encoder absolute ticks", tiltEncoder.getIntegratedSensorAbsolutePosition());
  }

  public void configTilt(){
      }

  public void resetTiltEncoder(){
    tiltEncoder.setIntegratedSensorPosition(0, 10);
  }

  public void tiltForward(){
    tilt.set(ControlMode.Position, 1365.33);

  }

  public void tiltHome(){
    tilt.set(ControlMode.Position, 0);
  }
}
