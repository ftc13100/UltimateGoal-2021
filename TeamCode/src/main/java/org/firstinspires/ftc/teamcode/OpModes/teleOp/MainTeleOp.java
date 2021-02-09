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

import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.groups.ShooterGroup;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.commands.shooter.ShooterCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.util.TimedAction;

@TeleOp(name="TeleOp")
public class MainTeleOp extends CommandOpMode {
    //motors
    private Motor shooter, intakeLeft, intakeRight;
    private Servo flicker;

    //subsystems
    private IntakeSubsystem intakeSubsystem;
    private ShooterSubsystem shooterSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands
    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private ShooterCommand shooterCommand;
    private InstantCommand runFlywheelCommand;
    private MecanumDriveCommand mecanumDriveCommand;

    //command groups
    private ShooterGroup shooterGroup;

    //gamepads
    private GamepadEx driver;

    //misc
    private TimedAction flickAction;

    @Override
    public void initialize() {
        this.intakeLeft = new Motor(hardwareMap, "intakeL");
        this.intakeRight = new Motor(hardwareMap, "intakeR");
        this.shooter = new Motor(hardwareMap, "shooter");
        this.flicker = hardwareMap.get(Servo.class, "flicker");

        this.flickAction = new TimedAction(
                ()-> flicker.setPosition(0.75),
                ()-> flicker.setPosition(0.1),
                600,
                true
        );

        this.intakeSubsystem = new IntakeSubsystem(this.intakeRight, this.intakeLeft);
        this.shooterSubsystem = new ShooterSubsystem(shooter, flicker, flickAction, telemetry);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
        this.shooterCommand = new ShooterCommand(this.shooterSubsystem);
        this.runFlywheelCommand = new InstantCommand(shooterSubsystem::shoot, shooterSubsystem);
        driver = new GamepadEx(gamepad1);
        this.mecanumDriveCommand = new MecanumDriveCommand(this.mecanumDriveSubsystem, () -> -driver.getLeftY(),
                driver::getLeftX, driver::getRightX
        );

        this.shooterGroup = new ShooterGroup(runFlywheelCommand,
                new WaitCommand(750), shooterCommand);



        driver.getGamepadButton(GamepadKeys.Button.A).whenHeld(this.shooterGroup);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);

        register(this.mecanumDriveSubsystem);
        this.mecanumDriveSubsystem.setDefaultCommand(this.mecanumDriveCommand);
    }
}
