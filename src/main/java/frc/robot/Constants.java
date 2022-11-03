// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //CAN ids
        //drive motors
        public static final int R1CANID = 1;
        public static final int R2CANID = 2;
        public static final int R3CANID = 3;
        public static final int L1CANID = 4;
        public static final int L2CANID = 5;
        public static final int L3CANID = 6;
    
            //spinny motors
        public static final int SPINNY1CANID = 7;
        public static final int SPINNY2CANID = 8;
    
            //tilt motor
        public static final int TILTCANID = 9;
    
            //carriage motor
        public static final int CARRIAGECANID = 10;
    
        //ramping
        public static final double RAMP_VAL = 0.1;
    
        //controls
            //driver controls
                //axes
            
                //buttons
            public static final int slowDriveButton = 3;
            public static final int fastDriveButton = 1;
            //operator controls
                //axes
            public static final int rotateLeftAxis = 0;
            public static final int rotateRightAxis = 1;
            public static final int tiltFineAxis = 2; //probably don't use
                //buttons
            public static final int intakeBucketButton = 1;
            public static final int tiltScoreButton = 2;
            public static final int tiltHomeButton = 3;
            public static final int spinLeftButton = 4;
            public static final int spinRightButton = 5;

        //encoder values
            //carriage
            public static final double carriageRots = 2;
            public static final double carriageEncoderCounts = carriageRots * 42;

        //feedback loop stuff
    public static final int carriagekSlotIdx = 0;

	public static final int carriagekPIDLoopIdx = 0;

	public static final int kTimeoutMs = 30;
	
	public static boolean carriagekSensorPhase = true;

	public static boolean carriagekMotorInvert = false;

    public static final int tiltkSlotIdx = 1;

    public static final int tiltkPIDLoopIdx = 1;

    public static boolean tiltkSensorPhase = true;

    public static boolean tiltkMotorInvert = false;

    //gains
    public static final double carriagekP = 0.15;
    public static final double carriagekI = 0.0;
    public static final double carriagekD = 0.0;
    public static final double carriagekF = 0.0;

    public static final double tiltkP = 0.15;
    public static final double tiltkI = 0.0;
    public static final double tiltkD = 0.0;
    public static final double tiltkF = 0.0;
}
