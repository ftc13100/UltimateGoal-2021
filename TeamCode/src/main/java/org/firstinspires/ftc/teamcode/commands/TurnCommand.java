package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class TurnCommand extends CommandBase {

    private final Drivetrain drive;
    private final double angle;

    public TurnCommand(Drivetrain drive, double angle) {
        this.drive = drive;
        this.angle = angle;
        
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.turn(angle);
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return Thread.currentThread().isInterrupted() || !drive.isBusy();
    }

}
