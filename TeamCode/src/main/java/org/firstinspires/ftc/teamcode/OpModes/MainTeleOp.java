package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BeaverRobot;

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
