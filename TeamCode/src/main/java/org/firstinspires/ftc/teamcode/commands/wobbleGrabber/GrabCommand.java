package org.firstinspires.ftc.teamcode.commands.wobbleGrabber;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

public class GrabCommand extends CommandBase {
    private WobbleGrabberSubsystem WobbleGrabber;
    public GrabCommand(WobbleGrabberSubsystem wg){
    this.WobbleGrabber = wg;
    }
    @Override
    public void execute() {
        this.WobbleGrabber.closeGrabber();
    }
}
