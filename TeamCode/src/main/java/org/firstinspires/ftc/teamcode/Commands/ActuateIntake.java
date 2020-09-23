package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class ActuateIntake extends CommandBase {
    private final Intake intake;
    private final double intakePower;

    public ActuateIntake(Intake intake, double power) {
        this.intake = intake;
        this.intakePower = power;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setPower(intakePower);
    }

}
