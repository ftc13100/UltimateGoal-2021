package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.config.Constants;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@TeleOp(name="TeleOp")
public class MainTeleOp extends CommandOpMode {

    private MotorEx intakeMotor;
    private Intake intake;

    private ControlBoard controlBoard;

    @Override
    public void initialize() {
        // initialize motors
        intakeMotor = new MotorEx(hardwareMap, "intakeMotor", MotorEx.GoBILDA.RPM_435);

        // initialize subsystems
        intake = new Intake(intakeMotor);

        // intake commands
        intake.setDefaultCommand(new IntakeCommand(intake, Constants.Intake.IntakeState.STOP));
        controlBoard.getIntakeIn().whenHeld(new IntakeCommand(intake, Constants.Intake.IntakeState.IN));
        controlBoard.getIntakeOut().whenHeld(new IntakeCommand(intake, Constants.Intake.IntakeState.OUT));

        // register subsystems
        register(intake);
    }
}
