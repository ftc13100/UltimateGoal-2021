package org.firstinspires.ftc.teamcode.opModes.auto;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.groups.auto.StraightShootCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.util.TimedAction;

public class StraightShootAuto extends CommandOpMode {
    //motors
    private Motor shooter;
    private Servo flicker;

    //subsystems
    private ShooterSubsystem shooterSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;

    //commands

    //command groups

    private TimedAction flickAction;

    private StraightShootCommand autoRoutine;

    @Override
    public void initialize() {
        this.shooter = new Motor(hardwareMap, "shooter");
        this.flicker = hardwareMap.get(Servo.class, "flicker");

        this.flickAction = new TimedAction(
                ()-> flicker.setPosition(0.75),
                ()-> flicker.setPosition(0.1),
                600,
                true
        );

        this.shooterSubsystem = new ShooterSubsystem(shooter, flicker, flickAction, telemetry);
        this.mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);

        this.autoRoutine = new StraightShootCommand(this.mecanumDriveSubsystem, this.shooterSubsystem);

        schedule(this.autoRoutine);
    }
}
