package org.firstinspires.ftc.teamcode.commands.wobbleGrabber;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

public class PickUpCommand extends CommandBase {

    WobbleGrabberSubsystem wobbleSubsystem;

    public PickUpCommand(WobbleGrabberSubsystem wobble) {
        this.wobbleSubsystem = wobble;
    }

    @Override
    public void initialize() {
        wobbleSubsystem.armHome();
    }

    @Override
    public void execute() {
        wobbleSubsystem.armUp();
    }

    @Override
    public void end(boolean interrupted) {
        wobbleSubsystem.stop();
    }
}
