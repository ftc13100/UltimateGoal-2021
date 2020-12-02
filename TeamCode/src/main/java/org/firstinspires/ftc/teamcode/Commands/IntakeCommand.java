package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.config.Constants.Intake.IntakeState;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

public class IntakeCommand extends CommandBase {

    private Intake intake;
    private IntakeState intakeState;

    public IntakeCommand(Intake intake, IntakeState intakeState) {
        addRequirements(intake);
        this.intake = intake;
        this.intakeState = intakeState;
    }

    @Override
    public void initialize() {
        intake.setIntakeState(intakeState);
    }
}
