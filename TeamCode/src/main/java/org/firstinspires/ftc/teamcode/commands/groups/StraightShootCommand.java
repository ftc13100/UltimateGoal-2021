package org.firstinspires.ftc.teamcode.commands.groups;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.drive.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.commands.drive.NavToLineCommand;
import org.firstinspires.ftc.teamcode.commands.shooter.RapidCommand;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class StraightShootCommand extends SequentialCommandGroup {

    public StraightShootCommand(MecanumDriveSubsystem dt, ShooterSubsystem shoot) {
        addCommands(
                new NavToLineCommand(dt),
                new WaitCommand(500),
                new RapidCommand(shoot)
        );
    }
}
