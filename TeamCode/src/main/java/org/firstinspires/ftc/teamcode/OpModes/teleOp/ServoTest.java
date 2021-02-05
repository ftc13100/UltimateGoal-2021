package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Flicker")
public class ServoTest extends CommandOpMode {

    private Servo flicker;

    private GamepadEx driver;

    @Override
    public void initialize() {
        flicker = hardwareMap.get(Servo.class, "flicker");
        flicker.setDirection(Servo.Direction.REVERSE);

        driver = new GamepadEx(gamepad1);

        driver.getGamepadButton(GamepadKeys.Button.A).whenPressed(new InstantCommand(this::home));
        driver.getGamepadButton(GamepadKeys.Button.B).whenPressed(new InstantCommand(this::push));

    }

    public void home() {
        flicker.setPosition(0.1);
    }

    public void push() {
        flicker.setPosition(0.75);
    }
}
