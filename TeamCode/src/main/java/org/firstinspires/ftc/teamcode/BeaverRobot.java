package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.config.Constants.Intake.IntakeState;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class BeaverRobot extends Robot {
    private final double WHEEL_DIAMETER = 100;

    private LinearOpMode opMode;

    private MotorEx intakeMotor;
    private Intake intake;

    private ControlBoard controlBoard;

    public BeaverRobot(LinearOpMode opMode, boolean teleOp) {
        this.opMode = opMode;

        initHardware();

        if (teleOp) initTeleOp();
        else initAuto();
    }

    public void initHardware() {
        intakeMotor = new MotorEx(opMode.hardwareMap, "intakeMotor", MotorEx.GoBILDA.RPM_435);

        intake = new Intake(intakeMotor);

        controlBoard = new ControlBoard(opMode);
    }

    public void initTeleOp() {
        // intake commands
        intake.setDefaultCommand(new IntakeCommand(intake, IntakeState.STOP));
        controlBoard.getIntakeIn().whenHeld(new IntakeCommand(intake, IntakeState.IN));
        controlBoard.getIntakeOut().whenHeld(new IntakeCommand(intake, IntakeState.OUT));

        // register loops
        register(intake);
    }

    public void initAuto() {
        
    }
}
