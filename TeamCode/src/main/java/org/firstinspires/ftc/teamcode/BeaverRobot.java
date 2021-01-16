package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.ActuateIntake;
import org.firstinspires.ftc.teamcode.commands.DefaultDrive;
import org.firstinspires.ftc.teamcode.commands.RunShooter;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class BeaverRobot extends Robot {
//    private final double WHEEL_DIAMETER = 100;
//
//    private LinearOpMode opMode;
//
//    private MotorEx frontLeft, frontRight, backLeft, backRight, intakeMotor, shooterMotor;
//    private Drivetrain drivetrain;
//    private Intake intake;
//    private Shooter shooter;
//
//    private ControlBoard controlBoard;
//
//    public BeaverRobot(LinearOpMode opMode, boolean teleOp) {
//        this.opMode = opMode;
//
//        initHardware();
//
//        if (teleOp) initTeleOp();
//        else initAuto();
//    }
//
//    public void initHardware() {
//        frontLeft = new MotorEx(opMode.hardwareMap, "frontLeft", MotorEx.GoBILDA.RPM_312);
//        frontRight = new MotorEx(opMode.hardwareMap, "frontRight", MotorEx.GoBILDA.RPM_312);
//        backLeft = new MotorEx(opMode.hardwareMap, "backLeft", MotorEx.GoBILDA.RPM_312);
//        backRight = new MotorEx(opMode.hardwareMap, "backRight", MotorEx.GoBILDA.RPM_312);
//
//        intakeMotor = new MotorEx(opMode.hardwareMap, "intakeMotor", MotorEx.GoBILDA.RPM_435);
//
//        shooterMotor = new MotorEx(opMode.hardwareMap, "shooterMotor", MotorEx.GoBILDA.RPM_435);
//
//        intake = new Intake(intakeMotor);
//        shooter = new Shooter(shooterMotor);
//        drivetrain = new Drivetrain(frontLeft, frontLeft, backLeft, backRight, WHEEL_DIAMETER);
//
//        controlBoard = new ControlBoard(opMode);
//    }
//
//    public void initTeleOp() {
//        // intake commands
//        intake.setDefaultCommand(new ActuateIntake(intake, 0.0));
//        controlBoard.getIntakeIn().whenHeld(new ActuateIntake(intake, 1.0));
//        controlBoard.getIntakeOut().whenHeld(new ActuateIntake(intake, -1.0));
//
//        // shooter commands
//        shooter.setDefaultCommand(new RunShooter(shooter, 0.0));
//        controlBoard.getRunShooter().whenHeld(new RunShooter(shooter, 1.0));
//
//        // drivetrain commands
//        drivetrain.setDefaultCommand(new DefaultDrive(drivetrain, controlBoard.getDriveForward(), controlBoard.getDriveStrafe(), controlBoard.getDriverRotate()));
//
//        // register loops
//        register(intake, shooter, drivetrain);
//    }
//
//    public void initAuto() {
//
//    }
}
