package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
//    //motors
//    private Motor shooter, intakeLeft, intakeRight;
//    private SimpleServo flicker;
//
//    //subsystems
//    private IntakeSubsystem intakeSubsystem;
//    private ShooterSubsystem shooterSubsystem;
//    private MecanumDriveSubsystem mecanumDriveSubsystem;
//
//    //commands
//    private IntakeCommand intakeCommand;
//    private OuttakeCommand outtakeCommand;
//    private ShooterCommand shooterCommand;
//    private InstantCommand runFlywheelCommand;
//    private MecanumDriveCommand mecanumDriveCommand;
//
//    //command groups
//    private ShooterGroup shooterGroup;
//
//    //gamepads
//    private GamepadEx driver;
//    private GamepadEx operator;
//
//    //misc
//    private TimedAction flickAction;

    @Override
    public void initialize() {
//        this.intakeLeft = new Motor(hardwareMap, "intakeLeft");
//        this.intakeRight = new Motor(hardwareMap, "intakeRight");
//        this.shooter = new Motor(hardwareMap, "shooter");
//        this.flicker = new SimpleServo(hardwareMap, "flicker", 0, 270);
//
//        this.flickAction = new TimedAction(
//                ()-> flicker.setPosition(0.5),
//                ()-> flicker.setPosition(0.27),
//                600,
//                true
//        );
//
//        this.intakeSubsystem = new IntakeSubsystem(this.intakeRight, this.intakeLeft);
//        this.shooterSubsystem = new ShooterSubsystem(shooter, flicker, flickAction, telemetry);
//        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);
//
//        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
//        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);
//        this.shooterCommand = new ShooterCommand(this.shooterSubsystem);
//        this.runFlywheelCommand = new InstantCommand(shooterSubsystem::shoot, shooterSubsystem);
//        this.mecanumDriveCommand = new MecanumDriveCommand(mecanumDriveSubsystem, () -> -driver.getLeftY(),
//                driver::getLeftX, driver::getRightX
//        );
//
//        this.shooterGroup = new ShooterGroup(runFlywheelCommand,
//                new WaitCommand(1500), shooterCommand);
//
//        driver = new GamepadEx(gamepad1);
//        operator = new GamepadEx(gamepad2);
//
//        operator.getGamepadButton(GamepadKeys.Button.A).whenHeld(this.shooterGroup);
//
//        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
//        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);
//
//        register(mecanumDriveSubsystem);
//        mecanumDriveSubsystem.setDefaultCommand(mecanumDriveCommand);
    }
}
