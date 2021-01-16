package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake extends SubsystemBase {

    private final MotorEx intakeMotor;

    public Intake(MotorEx intakeMotor) {
        this.intakeMotor = intakeMotor;
    }

    public Intake(HardwareMap map, String intakeMotor) {
        this.intakeMotor = new MotorEx(map, intakeMotor, MotorEx.GoBILDA.RPM_435);
    }

    public void setPower(double power) {
        intakeMotor.set(power);
    }
}
