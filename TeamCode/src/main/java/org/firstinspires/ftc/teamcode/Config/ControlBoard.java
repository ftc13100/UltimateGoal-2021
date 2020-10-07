package org.firstinspires.ftc.teamcode.config;


import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.function.DoubleSupplier;

public class ControlBoard {
    private GamepadEx driver;
    private GamepadEx operator;

    public ControlBoard(OpMode opMode) {
        driver = new GamepadEx(opMode.gamepad1);
        operator = new GamepadEx(opMode.gamepad2);
    }

    GamepadButton intakeIn = new GamepadButton(operator, GamepadKeys.Button.A);
    GamepadButton intakeOut = new GamepadButton(operator, GamepadKeys.Button.B);

    GamepadButton runShooter = new GamepadButton(operator, GamepadKeys.Button.X);

    DoubleSupplier driveForward = () -> driver.getLeftY();
    DoubleSupplier driveStrafe = () -> driver.getLeftX();
    DoubleSupplier driverRotate = () -> driver.getRightX();


    public GamepadButton getIntakeIn() {
        return intakeIn;
    }

    public GamepadButton getIntakeOut() {
        return intakeOut;
    }

    public GamepadButton getRunShooter() { return runShooter; }

    public DoubleSupplier getDriveForward() { return driveForward; }

    public DoubleSupplier getDriveStrafe() { return driveStrafe; }

    public DoubleSupplier getDriverRotate() { return driverRotate; }



}
