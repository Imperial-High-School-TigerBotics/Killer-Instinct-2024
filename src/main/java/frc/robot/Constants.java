package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class BaseConstants{
        //Pigeon 2.0 Gyro
        public static final int PigeonID = 13;

        public static final int LiftMotor1ID = 20;
        public static final int LiftMotor2ID = 21;
        public static final int IntakeMotorID = 16;
        public static final int ShootingMotor1ID = 14;
        public static final int ShootingMotor2ID = 15;

        public static final int liftCoderID = 17;
    }

    public static final class ShooterConfig {
        public static final double DownPosition = -0.38;
        public static final double AmpPosition = -1.141289;
        public static final double SpeakerPosition = -0.77;
        public static final double LongShotPosition = -0.83;

        // Higher = smoother (1 = normal)
        public static final double UpSmoothness = 1;
        public static final double DownSmoothness = 3;

        public static final boolean Shooter1Reversed = true;
        public static final boolean Shooter2Reversed = false;
    }

    public static final class SpeedScaleFactors{
        public static final double SwerveMaxSpeed = 0.75; //Speed in percentage
        public static final double SwerveMaxTurnSpeed = 0.20;

        public static final double LifterMaxUpSpeed = 0.3;
        public static final double LifterMaxDownSpeed = 0.1;

        public static final double ShootingSpeed = 0.8;
        public static final double ShootingThreshold = 0.2;
        public static final double AmpShootingSpeed = 0.2;
    }


    public static final class ModuleConstants {
        public static final double kWheelDiameterMeters = Units.inchesToMeters(4);
        public static final double kDriveMotorGearRatio = 1 / 6.75;
        public static final double kTurningMotorGearRatio = 1 / 21.428;
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
        public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;
        public static final double kPTurning = 0.5;
    }

    public static final class DriveConstants {

        public static final double kTrackWidth = Units.inchesToMeters(24);
        // Distance between right and left wheels
        public static final double kWheelBase = Units.inchesToMeters(24);
        // Distance between front and back wheels
        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
                new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(kWheelBase / 2, kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

        public static final int kFrontLeftDriveMotorPort = 8; //Make sure motor ports match with robot (CAN)
        public static final int kBackLeftDriveMotorPort = 6;
        public static final int kFrontRightDriveMotorPort = 2;
        public static final int kBackRightDriveMotorPort = 4;

        public static final int kFrontLeftTurningMotorPort = 7;
        public static final int kBackLeftTurningMotorPort = 5;
        public static final int kFrontRightTurningMotorPort = 1;
        public static final int kBackRightTurningMotorPort = 3;

        public static final boolean kFrontLeftTurningEncoderReversed = false;
        public static final boolean kBackLeftTurningEncoderReversed = false;
        public static final boolean kFrontRightTurningEncoderReversed = false;
        public static final boolean kBackRightTurningEncoderReversed = false;

        public static final boolean kFrontLeftDriveEncoderReversed = false;
        public static final boolean kBackLeftDriveEncoderReversed = false;
        public static final boolean kFrontRightDriveEncoderReversed = false;
        public static final boolean kBackRightDriveEncoderReversed = false;

        public static final boolean isTurningReversed = true;

        public static final int kFrontLeftDriveAbsoluteEncoderPort = 12; //Make sure encoder ports match with robot (CAN)
        public static final int kBackLeftDriveAbsoluteEncoderPort = 11;
        public static final int kFrontRightDriveAbsoluteEncoderPort = 9;
        public static final int kBackRightDriveAbsoluteEncoderPort = 10;

        public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
        public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
        public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
        public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

        public static final double kFrontLeftDriveAbsoluteEncoderOffsetDeg = 120.673828;//0.331543;//127.353516;//11
        public static final double kBackLeftDriveAbsoluteEncoderOffsetDeg = -11.601563;//-0.043945; //272.460936;//10
        public static final double kFrontRightDriveAbsoluteEncoderOffsetDeg = 9.755859;//0.029297; //270.087891; //12
        public static final double kBackRightDriveAbsoluteEncoderOffsetDeg = 19.687500;//0.053223; //123.222656; //9

        public static final double kPhysicalMaxSpeedMetersPerSecond = 4.4; // Original: 5
        public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI; // Original: 2 * 2 * Math.PI

        public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond * SpeedScaleFactors.SwerveMaxSpeed;// / 4;
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
                kPhysicalMaxAngularSpeedRadiansPerSecond * SpeedScaleFactors.SwerveMaxSpeed;// / 4;
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3; //Original: 3
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3; //Original 3
    }

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = DriveConstants.kPhysicalMaxSpeedMetersPerSecond / 4;
        public static final double kMaxAngularSpeedRadiansPerSecond = //
                DriveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
        public static final double kMaxAccelerationMetersPerSecondSquared = 6;
        public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;
        public static final double kPXController = 1.5;
        public static final double kPYController = 1.5;
        public static final double kPThetaController = 3;

        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond,
                        kMaxAngularAccelerationRadiansPerSecondSquared);
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kControlsControllerPort = 1;

        public static final int kDriverYAxis = 1; //Make sure constants work for Logitech & Xbox controller
        public static final int kDriverXAxis = 0;
        public static final int kDriverRotAxis = 4;
        public static final int kDriverFieldOrientedButtonIdx = 1;

        public static final double kDeadband = 0.08;
    }
}