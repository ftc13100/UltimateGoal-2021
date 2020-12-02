package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RunShooter extends CommandBase {
    private Shooter shooter;
    private double shooterVelocity;

    public RunShooter(Shooter shooter1, double velocity) {
        shooter = shooter1;
        shooterVelocity = velocity;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setVelocity(shooterVelocity);
    }

    @Override
    public boolean isFinished() {
        //keep running the shooter as long as we are not at the right velocity
        return shooter.getVelocity() != shooterVelocity;
    }
}
