package org.firstinspires.ftc.teamcode.commands.wobbleGrabber;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

public class PutDownCommand extends CommandBase {

    private WobbleGrabberSubsystem wobbleSubsystem;

    public PutDownCommand(WobbleGrabberSubsystem wobble) {
        this.wobbleSubsystem = wobble;
    }

    @Override
    public void initialize() {
        wobbleSubsystem.armHome();
    }

    @Override
    public void execute() {
        wobbleSubsystem.armDown();
    }

    @Override
    public void end(boolean interrupted) {
        wobbleSubsystem.stop();
    }
}
