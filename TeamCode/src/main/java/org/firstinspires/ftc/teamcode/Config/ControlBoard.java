package org.firstinspires.ftc.teamcode.config;


import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ControlBoard {
    private GamepadEx driver;
    private GamepadEx operator;

    public ControlBoard(Gamepad gamepad1, Gamepad gamepad2) {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
    }

    GamepadButton intakeIn = new GamepadButton(operator, GamepadKeys.Button.A);
    GamepadButton intakeOut = new GamepadButton(operator, GamepadKeys.Button.B);


    public GamepadButton getIntakeIn() {
        return intakeIn;
    }

    public GamepadButton getIntakeOut() {
        return intakeOut;
    }

}
