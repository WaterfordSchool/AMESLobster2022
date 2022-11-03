// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private CANSparkMax left1;
    private CANSparkMax left2;
    private CANSparkMax left3;
    private CANSparkMax right1;
    private CANSparkMax right2;
    private CANSparkMax right3;

    private MotorControllerGroup leftDrive; 
    private MotorControllerGroup rightDrive; 

    private DifferentialDrive dDrive;

    private XboxController driver;
    
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    left1 = new CANSparkMax(0, MotorType.kBrushless);
    left2 = new CANSparkMax(1, MotorType.kBrushless);
    left3 = new CANSparkMax(2, MotorType.kBrushless);
    right1 = new CANSparkMax(3, MotorType.kBrushless);
    right2 = new CANSparkMax(4, MotorType.kBrushless);
    right3 = new CANSparkMax(5, MotorType.kBrushless);

    leftDrive = new MotorControllerGroup(left1, left2, left3);
    rightDrive = new MotorControllerGroup(right1, right2, right3);

    dDrive = new DifferentialDrive(leftDrive, rightDrive);
    
     //ramping
     final double t = 0.4;
     left1.setOpenLoopRampRate(t);
     left2.setOpenLoopRampRate(t);
     left3.setOpenLoopRampRate(t);
     right1.setOpenLoopRampRate(t);
     right2.setOpenLoopRampRate(t);
     right3.setOpenLoopRampRate(t);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void initDefaultCommand(){
    //set default command for subsystem
    drive(driver, 0.8);
  }
  public void driveSlow(){
      drive(driver, 0.3);
  }
  public void driveFast(){
      drive(driver, 1);
  }

  public void drive(XboxController driveController, double kSpeed) {
    dDrive.arcadeDrive(-driveController.getRawAxis(0) * kSpeed, -driveController.getRawAxis(3) * kSpeed);
    if(driveController.getRawAxis(2) > 0){
    dDrive.arcadeDrive(-driveController.getRawAxis(0) * kSpeed, driveController.getRawAxis(2) * kSpeed);
  }
}

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
