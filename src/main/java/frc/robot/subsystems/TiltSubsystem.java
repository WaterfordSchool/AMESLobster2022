package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class TiltSubsystem extends SubsystemBase{
    public TiltSubsystem() {}
    TalonFX tilt = new TalonFX(0);
    TalonFXSensorCollection tiltEncoder = tilt.getSensorCollection();
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("tilt encoder relative ticks", tiltEncoder.getIntegratedSensorPosition());
    SmartDashboard.putNumber("tilt encoder absolute ticks", tiltEncoder.getIntegratedSensorAbsolutePosition());
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
