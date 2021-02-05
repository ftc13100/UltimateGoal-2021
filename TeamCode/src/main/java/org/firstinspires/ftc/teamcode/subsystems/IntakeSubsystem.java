package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class IntakeSubsystem extends SubsystemBase {

    private Motor intakeMotorRight;
    private Motor intakeMotorLeft;

    public IntakeSubsystem(Motor right, Motor left) {
        this.intakeMotorRight = right;
        this.intakeMotorLeft = left;

        this.intakeMotorLeft.setInverted(false);
        this.intakeMotorRight.setInverted(true);
    }

    public void in() {
        this.intakeMotorLeft.set(-1.0);
        this.intakeMotorRight.set(-1.0);
    }

    public void stop() {
        this.intakeMotorLeft.stopMotor();
        this.intakeMotorRight.stopMotor();
    }

    public void out() {
        this.intakeMotorLeft.set(1.0);
        this.intakeMotorRight.set(1.0);
    }
}
