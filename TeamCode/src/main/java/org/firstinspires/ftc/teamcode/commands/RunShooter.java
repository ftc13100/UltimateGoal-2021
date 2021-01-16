package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RunShooter extends CommandBase {
    private Shooter shooter;
    private double shooterPower;

    public RunShooter(Shooter shooter1, double power) {
        shooter = shooter1;
        shooterPower = power;
    }

    @Override
    public void execute() {
        shooter.setPower(shooterPower);
    }
}
