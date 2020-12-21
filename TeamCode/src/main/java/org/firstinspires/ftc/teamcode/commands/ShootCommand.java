package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class ShootCommand extends CommandBase {
    private Shooter shooter;

    public ShootCommand(Shooter subsystem) {
        shooter = subsystem;

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.shoot();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
