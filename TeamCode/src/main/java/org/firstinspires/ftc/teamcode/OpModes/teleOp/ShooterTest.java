package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.groups.ShooterGroup;
import org.firstinspires.ftc.teamcode.commands.shooter.ShooterCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.util.TimedAction;

@TeleOp(name = "Shooter")
public class ShooterTest extends CommandOpMode {

    private Motor shooter;

    private Servo flicker;

    private ShooterSubsystem shooterSubsystem;

    private ShooterCommand shooterCommand;
    private InstantCommand runFlywheelCommand;

    private ShooterGroup shooterGroup;

    private GamepadEx driver;

    private TimedAction flickAction;

    @Override
    public void initialize() {
        this.shooter = new Motor(hardwareMap, "shooter");
        this.flicker = hardwareMap.get(Servo.class, "flicker");

        this.flickAction = new TimedAction(
                ()-> flicker.setPosition(0.5),
                ()-> flicker.setPosition(0.27),
                1000,
                true
        );

        this.shooterSubsystem = new ShooterSubsystem(shooter, flicker, flickAction, telemetry);

        this.shooterCommand = new ShooterCommand(this.shooterSubsystem);
        this.runFlywheelCommand = new InstantCommand(shooterSubsystem::shoot, shooterSubsystem);

        this.shooterGroup = new ShooterGroup(runFlywheelCommand,
                new WaitCommand(1500), shooterCommand);

        driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.A).whenHeld(this.shooterGroup);
    }
}
