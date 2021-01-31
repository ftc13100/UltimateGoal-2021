package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
@TeleOp(name = "Intake")

public class IntakeTest extends CommandOpMode {

    private Motor intakeLeft, intakeRight;

    private IntakeSubsystem intakeSubsystem;

    private IntakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;

    private GamepadEx driver;

    @Override
    public void initialize() {
        this.intakeLeft = new Motor(hardwareMap, "intakeL");
        this.intakeRight = new Motor(hardwareMap, "intakeR");

        this.intakeSubsystem = new IntakeSubsystem(this.intakeRight, this.intakeLeft);

        this.intakeCommand = new IntakeCommand(this.intakeSubsystem);
        this.outtakeCommand = new OuttakeCommand(this.intakeSubsystem);

        driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(this.intakeCommand);
        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(this.outtakeCommand);
    }
}
