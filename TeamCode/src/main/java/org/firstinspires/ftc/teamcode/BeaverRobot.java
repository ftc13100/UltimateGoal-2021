package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.Robot;
import com.arcrobotics.ftclib.util.Safety;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.ActuateIntake;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.drivebase.MecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Motor;
import org.firstinspires.ftc.teamcode.hardware.MotorEx;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BeaverRobot extends Robot {
    private final double WHEEL_DIAMETER = 100;

    private LinearOpMode opMode;

    private MotorEx frontLeft, frontRight, backLeft, backRight, intakeMotor;
    private Drivetrain drivetrain;
    private Intake intake;

    private ControlBoard controlBoard;

    public BeaverRobot(LinearOpMode opMode, boolean teleOp) {
        opMode = opMode;

        initHardware();

        if (teleOp) initTeleOp();
        else initAuto();
    }

    public void initHardware() {
        frontLeft = new MotorEx(opMode.hardwareMap, "frontLeft", MotorEx.GoBILDA.RPM_312);
        frontRight = new MotorEx(opMode.hardwareMap, "frontRight", MotorEx.GoBILDA.RPM_312);
        backLeft = new MotorEx(opMode.hardwareMap, "backLeft", MotorEx.GoBILDA.RPM_312);
        backRight = new MotorEx(opMode.hardwareMap, "backRight", MotorEx.GoBILDA.RPM_312);

        intakeMotor = new MotorEx(opMode.hardwareMap, "intakeMotor", MotorEx.GoBILDA.RPM_435);

        intake = new Intake(intakeMotor);
        drivetrain = new Drivetrain(frontLeft, frontLeft, backLeft, backRight, WHEEL_DIAMETER);

        controlBoard = new ControlBoard(opMode.gamepad1, opMode.gamepad2);
    }

    public void initTeleOp() {
        // intake commands
        intake.setDefaultCommand(new ActuateIntake(intake, 0.0));
        controlBoard.getIntakeIn().whenHeld(new ActuateIntake(intake, 1.0));
        controlBoard.getIntakeOut().whenHeld(new ActuateIntake(intake, -1.0));

        // drivetrain commands

        // register loops
        register(intake, drivetrain);
    }

    public void initAuto() {
        
    }
}
