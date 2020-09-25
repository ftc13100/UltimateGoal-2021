package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.YellowJacket435;

public class Intake extends SubsystemBase {

    private final YellowJacket435 intakeMotor;

    public Intake(final HardwareMap map) {
        intakeMotor = new YellowJacket435(map, "intakeMotor");
    }

    public void setPower(double power) {
        intakeMotor.set(power);
    }
}
