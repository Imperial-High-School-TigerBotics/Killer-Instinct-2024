package frc.robot.commands;

import java.lang.constant.Constable;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

public class ArmCmd extends Command {
    
    private Arm arm;
    private XboxController xbox;

    public ArmCmd(Arm arm, XboxController xbox) {
        this.arm = arm;
        this.xbox = xbox;
        addRequirements(this.arm);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        
        if (xbox.getBButton()) {
            arm.reverseIntake();
        } else if (xbox.getLeftTriggerAxis() > 0.1) {
            arm.startIntaking(xbox.getLeftTriggerAxis());
        } else {
            arm.stopIntaking();
        }
        
        if (xbox.getLeftBumper()) {
            arm.goToAmpPos();
        } else if (xbox.getXButton()) {
            arm.goToLongShotPos();
        } else {
            arm.goDown();
        }
        
        if (xbox.getRightTriggerAxis() > Constants.SpeedScaleFactors.ShootingThreshold) {
            arm.startShooting(Constants.SpeedScaleFactors.ShootingSpeed);
        } else if (xbox.getRightBumper()) {
            arm.startShooting(Constants.SpeedScaleFactors.AmpShootingSpeed);
        } else {
            arm.stopShooting();
        }

        boolean set = true;
        if (set) {
            arm.goToPos();
        }

    }

    @Override
    public void end(boolean interrupted) {}
}
