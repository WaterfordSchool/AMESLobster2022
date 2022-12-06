package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class TiltSubsystem extends SubsystemBase{
  public final CANSparkMax tilt;
  public final SparkMaxPIDController tiltPID;
  private final RelativeEncoder tiltEncoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, rotations, rawRots;
  public double desiredRots = 0;
  //public double rawRots = desiredRots/Constants.tiltReduction;
  public final double tiltEncoderTicks = desiredRots * 4096;

    public TiltSubsystem() {
      tilt = new CANSparkMax(Constants.TILTCANID, MotorType.kBrushless);
      tilt.setInverted(Constants.carriagekMotorInvert);
      tiltEncoder = tilt.getEncoder();
      tiltPID = tilt.getPIDController();
      tiltPID.setFF(Constants.tiltkF);
      tiltPID.setP(Constants.tiltkP);
      tiltPID.setI(Constants.tiltkI);
      tiltPID.setD(Constants.tiltkD);
      tiltPID.setOutputRange(Constants.tiltMinOutput, Constants.tiltMaxOutput);
      
    }
    
  public double desiredToRawRots(double desiredRots){
    rawRots = desiredRots/Constants.tiltReduction;
    return rawRots;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
    SmartDashboard.putNumber("Set Rotations", 0);

    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    double rotations = SmartDashboard.getNumber("Set Rotations", 0);

    if((p != kP)) { tiltPID.setP(p); kP = p; }
    if((i != kI)) { tiltPID.setI(i); kI = i; }
    if((d != kD)) { tiltPID.setD(d); kD = d; }
    if((iz != kIz)) { tiltPID.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { tiltPID.setFF(ff); kFF = ff; }
    if((max != kMaxOutput) || (min != kMinOutput)) { 
      tiltPID.setOutputRange(min, max); 
    
      
    }

    tiltPID.setReference(rotations, CANSparkMax.ControlType.kPosition);
    SmartDashboard.putNumber("SetPoint", rotations);
    SmartDashboard.putNumber("ProcessVariable", tiltEncoder.getPosition());
    }


  public void resetTiltEncoder(){
    //tiltEncoder.setIntegratedSensorPosition(0, 10);
    tiltEncoder.setPosition(0);
  }

  public void tiltForward(){
    rotations = 2;
    //TODO: CALCULATE ROTATIONS
  }

  public void tiltHome(){
    //tilt.set(ControlMode.Position, 0);
    rotations = 0;
  }
}
