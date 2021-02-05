package org.firstinspires.ftc.teamcode.commands.shooter;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class RapidCommand extends CommandBase {

    private ShooterSubsystem shooter;
    private int shots;

    public RapidCommand(ShooterSubsystem subsystem){
        shooter = subsystem;
        shots = 0;
    }

    @Override
    public void initialize() {
        shooter.flickReset();
        shots = 0;
        shooter.setRunMode(Motor.RunMode.VelocityControl);
    }

    @Override
    public void execute() {
        while (shots < 3) {
            if (!shooter.isRunning()) {
                shooter.flickReset();
                shots++;
            }
            shooter.flick();
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooter.home();
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return shots == 3;
    }
}
