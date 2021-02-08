package org.firstinspires.ftc.teamcode.commands.wobbleGrabber;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

public class ReleaseCommand extends CommandBase {
    private WobbleGrabberSubsystem WobbleGrabber;
    public ReleaseCommand(WobbleGrabberSubsystem wg){
        this.WobbleGrabber = wg;
    }
    @Override
    public void execute() {
        this.WobbleGrabber.openGrabber();
    }
}