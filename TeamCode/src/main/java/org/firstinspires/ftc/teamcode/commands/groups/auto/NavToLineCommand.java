package org.firstinspires.ftc.teamcode.commands.groups.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

public class NavToLineCommand extends SequentialCommandGroup {

    public NavToLineCommand(MecanumDriveSubsystem dt) {
        addCommands(
                new InstantCommand(() ->  dt.setDrivePower(new Pose2d(0, 0.5, 0))),
                new WaitUntilCommand(() -> dt.getPoseEstimate().getY() >= 24)
                        .whenFinished(() -> {
                            dt.setDrivePower(new Pose2d());
                        }),
                new WaitCommand(250),
                new InstantCommand(() ->  dt.setDrivePower(new Pose2d(0.5, 0, 0))),
                new WaitUntilCommand(() -> dt.getPoseEstimate().getX() >= 48)
                        .whenFinished(() -> {
                            dt.setDrivePower(new Pose2d());
                        })
        );
    }
}
