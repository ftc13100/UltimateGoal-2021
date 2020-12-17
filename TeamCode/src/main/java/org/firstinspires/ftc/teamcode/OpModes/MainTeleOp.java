package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BeaverRobot;
import org.firstinspires.ftc.teamcode.commands.DefaultDrive;
import org.firstinspires.ftc.teamcode.config.Constants;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@TeleOp(name="TeleOp")
public class MainTeleOp extends CommandOpMode {

    private Drivetrain drivetrain;

    private ControlBoard controlBoard;

    @Override
    public void initialize() {
        // initialize motors


        // initialize subsystems
        drivetrain = new Drivetrain(new SampleMecanumDrive(hardwareMap), false);

        // register subsystems
        register(drivetrain);

        // drive commands
        drivetrain.setDefaultCommand(new DefaultDrive(
                drivetrain,
                controlBoard.getDriveForward(),
                controlBoard.getDriveStrafe(),
                controlBoard.getDriverRotate()
        ));

        //schedule logging
        schedule();
    }
}
