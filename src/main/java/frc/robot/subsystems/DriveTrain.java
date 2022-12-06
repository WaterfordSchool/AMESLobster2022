// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX left1;
    private WPI_TalonSRX left2;
    private WPI_TalonSRX right1;
    private WPI_TalonSRX right2;

    private MotorControllerGroup leftDrive; 
    private MotorControllerGroup rightDrive; 

    private DifferentialDrive dDrive;

    private XboxController driver;
    
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    left1 = new WPI_TalonSRX(Constants.L1CANID);
    left2 = new WPI_TalonSRX(Constants.L2CANID);
    right1 = new WPI_TalonSRX(Constants.R1CANID);
    right2 = new WPI_TalonSRX(Constants.R2CANID);


    leftDrive = new MotorControllerGroup(left1, left2);
    rightDrive = new MotorControllerGroup(right1, right2);

    dDrive = new DifferentialDrive(leftDrive, rightDrive);
    
     //ramping
     final double t = 0.3;
     left1.configOpenloopRamp(t);
     left2.configOpenloopRamp(t);
     right1.configOpenloopRamp(t);
     right2.configOpenloopRamp(t);
 
 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /*public void driveSlow(){
      drive(driver, 0.3);
  }
  public void driveFast(){
      drive(driver, 1);
  }*/

  public void drive(XboxController driveController, double kSpeed) {
    dDrive.arcadeDrive(driveController.getRawAxis(0) * kSpeed, driveController.getRawAxis(3) * kSpeed);
    if(driveController.getRawAxis(2) > 0){
    dDrive.arcadeDrive(driveController.getRawAxis(0) * kSpeed, -driveController.getRawAxis(2) * kSpeed);
  }
}
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
