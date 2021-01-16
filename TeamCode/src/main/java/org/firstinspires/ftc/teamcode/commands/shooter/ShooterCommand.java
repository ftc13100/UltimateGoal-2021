package org.firstinspires.ftc.teamcode.commands.shooter;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

    private ShooterSubsystem shooterSubsystem;

    public ShooterCommand(ShooterSubsystem shooter) {
        this.shooterSubsystem = shooter;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        shooterSubsystem.flickReset();
    }

    @Override
    public void execute() {
        shooterSubsystem.flickReset();
        shooterSubsystem.flick();
    }

    public void stopShooter() {
        shooterSubsystem.stop();
    }

    public void returnHome() {
        shooterSubsystem.home();
    }
}
