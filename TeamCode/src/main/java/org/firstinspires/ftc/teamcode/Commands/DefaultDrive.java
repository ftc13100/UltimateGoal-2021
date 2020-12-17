package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DefaultDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final DoubleSupplier leftY, leftX, rightX;

    public DefaultDrive(Drivetrain dt, DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightX) {
        drivetrain = dt;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;

        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.drive(leftY.getAsDouble(), leftX.getAsDouble(), rightX.getAsDouble());
    }
}
