package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.TimedAction;

public class ShooterSubsystem extends SubsystemBase {

    private Motor shooterFlywheel;
    private Servo shooterFlicker;

    private TimedAction timedAction;
    private Telemetry telemetry;

    public ShooterSubsystem(Motor flywheel, Servo flicker, TimedAction action, Telemetry telemetry) {
        this.shooterFlywheel = flywheel;
        this.shooterFlicker = flicker;

        this.timedAction = action;
        this.telemetry = telemetry;

        this.shooterFlywheel.setRunMode(Motor.RunMode.VelocityControl);
        this.shooterFlywheel.setVeloCoefficients(1.2, 0, 0.07);

        // this.shooterFlywheel.setFeedforwardCoefficients(0, 1.1);
    }

    public boolean isRunning() { return timedAction.running(); }
    
    public void shoot() {
        shooterFlywheel.set(1.0);
    }

    public void stop() {
        shooterFlywheel.stopMotor();
    }

    public void flick() {
        timedAction.run();
    }

    public void flickReset() {
        if (!timedAction.running()) {
            timedAction.reset();
        }
    }

    public void home() {
        shooterFlicker.setPosition(0.1);
    }

    public void setRunMode(Motor.RunMode runMode){
        shooterFlywheel.setRunMode(runMode);
    }

    @Override
    public void periodic() {
        telemetry.addData("Shooter Velocity: ", shooterFlywheel.getCorrectedVelocity());
        telemetry.update();
    }
}
