package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DefaultDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final DoubleSupplier forwardPower;
    private final DoubleSupplier strafePower;
    private final DoubleSupplier rotatePower;

    public DefaultDrive(Drivetrain dt, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier rotate) {
        drivetrain = dt;
        forwardPower = forward;
        strafePower = strafe;
        rotatePower = rotate;
        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.driveRobotCentric(forwardPower.getAsDouble(), strafePower.getAsDouble(), rotatePower.getAsDouble());
    }
}
