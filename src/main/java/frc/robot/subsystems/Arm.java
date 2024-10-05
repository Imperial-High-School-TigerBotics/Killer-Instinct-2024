package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Arm extends SubsystemBase {

    private CANSparkMax lifter1;
    private CANSparkMax lifter2;

    private CANcoder liftCoder;

    private TalonFX intakeMotor;

    private TalonFX shooter1;
    private TalonFX shooter2;

    private double intendedPos = 0;

    public Arm() {
        lifter1 = new CANSparkMax(Constants.BaseConstants.LiftMotor1ID, MotorType.kBrushless);
        lifter2 = new CANSparkMax(Constants.BaseConstants.LiftMotor2ID, MotorType.kBrushless);
        lifter1.setIdleMode(IdleMode.kBrake);
        lifter2.setIdleMode(IdleMode.kBrake);
        
        liftCoder = new CANcoder(Constants.BaseConstants.liftCoderID);

        intakeMotor = new TalonFX(Constants.BaseConstants.IntakeMotorID);

        shooter1 = new TalonFX(Constants.BaseConstants.ShootingMotor1ID);
        shooter2 = new TalonFX(Constants.BaseConstants.ShootingMotor2ID);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("cancoder calculated pos", getLiftPos());
    }

    public void goToPos() {

        double speed = intendedPos - getLiftPos();
        if (speed > 0) { // going down
            speed /= Constants.ShooterConfig.DownSmoothness;
        } else { // going up
            speed /= Constants.ShooterConfig.UpSmoothness;
        }

        if (speed > Constants.SpeedScaleFactors.LifterMaxDownSpeed) {
            speed = Constants.SpeedScaleFactors.LifterMaxDownSpeed;
        } else if (speed < -Constants.SpeedScaleFactors.LifterMaxUpSpeed) {
            speed = -Constants.SpeedScaleFactors.LifterMaxUpSpeed;
        }

        lifter1.set(speed);
        lifter2.set(speed);
    }

    public void goDownBasic() {
        lifter1.set(0.2);
        lifter2.set(0.2);
    }
    public void goUpBasic() {
        lifter1.set(-0.2);
        lifter2.set(-0.2);
    }
    public void stopBasic() {
        lifter1.set(0);
        lifter2.set(0);
    }

    public void goDown() {
        intendedPos = Constants.ShooterConfig.DownPosition;
    }
    public void goToAmpPos() {
        intendedPos = Constants.ShooterConfig.AmpPosition;
    }
    public void goToSpeakerPos() {
        intendedPos = Constants.ShooterConfig.SpeakerPosition;
    }
    public void goToLongShotPos() {
        intendedPos = Constants.ShooterConfig.LongShotPosition;
    }

    public void startShooting(double speed) {
        shooter1.set((Constants.ShooterConfig.Shooter1Reversed ? -1 : 1) * speed);
        shooter2.set((Constants.ShooterConfig.Shooter2Reversed ? -1 : 1) * speed);
    }
    public void stopShooting() {
        shooter1.set(0);
        shooter2.set(0);
    }

    public void startIntaking(double speed) {
        intakeMotor.set(speed * 0.4);
    }
    public void reverseIntake() {
        intakeMotor.set(-0.2);
    }
    public void stopIntaking() {
        intakeMotor.set(0);
    }

    public void stopEverything() {
        stopIntaking();
        stopShooting();
    }

    public double getLiftPos() {
        return liftCoder.getPosition().getValueAsDouble();
    }
}
