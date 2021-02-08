package org.firstinspires.ftc.teamcode.OpModes.teleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.wobbleGrabber.GoToMidCommand;
import org.firstinspires.ftc.teamcode.commands.wobbleGrabber.GrabCommand;
import org.firstinspires.ftc.teamcode.commands.wobbleGrabber.LiftCommand;
import org.firstinspires.ftc.teamcode.commands.wobbleGrabber.LowerCommand;
import org.firstinspires.ftc.teamcode.commands.wobbleGrabber.ReleaseCommand;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGrabberSubsystem;

import java.util.function.BooleanSupplier;

public class WobbleGrabberTest extends CommandOpMode {
    private Servo lifter;
    private Servo grabber;
    private WobbleGrabberSubsystem WobbleGrabber;
    private Trigger m_grabButton;
    private Trigger m_releaseButton;

    private GamepadEx driver;

    private GrabCommand grabCommand;
    private ReleaseCommand releaseCommand;
    private LiftCommand liftCommand;
    private LowerCommand lowerCommand;
    private GoToMidCommand goToMidCommand;

    @Override
    public void initialize() {
        this.lifter = hardwareMap.servo.get("lifter");
        this.grabber = hardwareMap.servo.get("grabber");
        this.WobbleGrabber = new WobbleGrabberSubsystem(grabber, lifter);

        this.grabCommand = new GrabCommand(this.WobbleGrabber);
        this.releaseCommand = new ReleaseCommand(this.WobbleGrabber);
        this.liftCommand = new LiftCommand(this.WobbleGrabber);
        this.lowerCommand = new LowerCommand(this.WobbleGrabber);
        this.goToMidCommand = new GoToMidCommand(this.WobbleGrabber);

        this.driver = new GamepadEx(gamepad1);

        this.driver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(this.lowerCommand);
        this.driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(this.liftCommand);
        this.driver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(this.goToMidCommand);
        TriggerReader rtReader = new TriggerReader(this.driver, GamepadKeys.Trigger.RIGHT_TRIGGER);
        m_grabButton = (new Trigger(rtReader::isDown)).whenActive(this.grabCommand);
        TriggerReader ltReader = new TriggerReader(this.driver, GamepadKeys.Trigger.LEFT_TRIGGER);
        m_releaseButton = (new Trigger(ltReader::isDown)).whenActive(this.releaseCommand);

    }
}
