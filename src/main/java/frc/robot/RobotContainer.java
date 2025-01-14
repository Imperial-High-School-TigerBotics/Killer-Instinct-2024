package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.BaseConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArmCmd;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

    private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
    private Arm arm;
    private ArmCmd armCmd;

    private final Joystick driverJoystick = new Joystick(OIConstants.kDriverControllerPort);

    public static XboxController driverController = new XboxController(OIConstants.kDriverControllerPort);
    public static XboxController intakeController = new XboxController(OIConstants.kControlsControllerPort);

    public RobotContainer() {
        swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(
                swerveSubsystem, 
                () -> -driverJoystick.getRawAxis(OIConstants.kDriverYAxis),
                () -> driverJoystick.getRawAxis(OIConstants.kDriverXAxis),
                () -> driverJoystick.getRawAxis(OIConstants.kDriverRotAxis),
                () -> !driverJoystick.getRawButton(OIConstants.kDriverFieldOrientedButtonIdx)));

        arm = new Arm();
        armCmd = new ArmCmd(arm, intakeController);
        arm.setDefaultCommand(armCmd);

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(driverJoystick, 1).onTrue(Commands.runOnce(() -> swerveSubsystem.zeroHeading()));
    }


public Command getAutonomousCommand() {
        return null;
     }
}