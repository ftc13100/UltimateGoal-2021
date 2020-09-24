package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.ActuateIntake;
import org.firstinspires.ftc.teamcode.Config.ControlBoard;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;


public class TeleOp extends LinearOpMode {
    //subsystems
    private Intake intake;

    //control board
    private ControlBoard controlBoard;


    @Override
    public void runOpMode() throws InterruptedException {
        intake = new Intake(hardwareMap);

        controlBoard = new ControlBoard(gamepad1, gamepad2);

        //intake controls
        intake.setDefaultCommand(new ActuateIntake(intake, 0.0));
        controlBoard.getIntakeIn().whenHeld(new ActuateIntake(intake, 1.0));
        controlBoard.getIntakeOut().whenHeld(new ActuateIntake(intake, -1.0));

        while (opModeIsActive() && !isStopRequested()) {
            //the scheduler will keep track of all of the triggers we made
            CommandScheduler.getInstance().run();
        }
    }
}
