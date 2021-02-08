package org.firstinspires.ftc.teamcode.commands.wobbleGrabber;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

public class LowerCommand extends CommandBase {
    private WobbleGrabberSubsystem WobbleGrabber;
    public LowerCommand(WobbleGrabberSubsystem wg){
        this.WobbleGrabber = wg;
    }
    @Override
    public void execute() {
        this.WobbleGrabber.armDown();
    }
}