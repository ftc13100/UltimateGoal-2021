package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    private MotorEx shooterMotor;

    public Shooter(MotorEx shooter) {
        shooterMotor = shooter;
    }

    public Shooter(HardwareMap hMap, String shooter) {
        shooterMotor = new MotorEx(hMap, shooter, MotorEx.GoBILDA.RPM_435);
    }

    public void setPower(double power) {
        shooterMotor.set(power);
    }

}
