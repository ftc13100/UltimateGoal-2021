package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BeaverRobot;
import org.firstinspires.ftc.teamcode.drivebase.MecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.MotorEx;
import org.firstinspires.ftc.teamcode.commands.ActuateIntake;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

@TeleOp(name="TeleOp")
public class MainTeleOp extends LinearOpMode {

    BeaverRobot robot = new BeaverRobot(this, true);

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            //the scheduler will keep track of all of the triggers we made
            robot.run();
        }

        robot.reset();
    }
}
