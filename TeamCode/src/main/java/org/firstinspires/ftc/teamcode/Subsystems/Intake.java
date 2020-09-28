package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.Motor;
import org.firstinspires.ftc.teamcode.hardware.MotorEx;

public class Intake extends SubsystemBase {

    private final MotorEx intakeMotor;

    public Intake(MotorEx intakeMotor) {
        this.intakeMotor = intakeMotor;
    }

    public Intake(HardwareMap map, String intakeMotor) {
        this.intakeMotor = new MotorEx(map, intakeMotor, Motor.GoBILDA.RPM_435);
    }

    public void setPower(double power) {
        intakeMotor.set(power);
    }
}
