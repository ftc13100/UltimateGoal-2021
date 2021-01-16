package org.firstinspires.ftc.teamcode.commands.groups;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.shooter.ShooterCommand;

public class ShooterGroup extends SequentialCommandGroup {

    private ShooterCommand shooterCommand;

    public ShooterGroup(InstantCommand runFlywheel, WaitCommand waitCommand, ShooterCommand shoot) {
        this.shooterCommand = shoot;

        addCommands(runFlywheel, waitCommand, shoot);
    }

    @Override
    public void end(boolean interrupted){
        shooterCommand.stopShooter();
        shooterCommand.returnHome();
    }
}
