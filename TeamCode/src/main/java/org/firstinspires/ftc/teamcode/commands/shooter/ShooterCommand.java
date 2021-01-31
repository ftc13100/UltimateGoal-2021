package org.firstinspires.ftc.teamcode.commands.shooter;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

    private ShooterSubsystem shooterSubsystem;

    public ShooterCommand(ShooterSubsystem shooter) {
        this.shooterSubsystem = shooter;

        //addRequirements(this.shooterSubsystem);
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
        shooterSubsystem.setRunMode(Motor.RunMode.RawPower);
        shooterSubsystem.stop();
    }

    public void returnHome() {
        shooterSubsystem.home();
    }
}
