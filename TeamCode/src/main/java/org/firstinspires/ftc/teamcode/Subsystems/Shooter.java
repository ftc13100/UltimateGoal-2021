package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.config.Constants;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    private MotorEx shooterMotor;

    public Shooter(MotorEx shooter) {
        shooterMotor = shooter;
        shooterMotor.setFeedforwardCoefficients(Constants.Shooter.SHOOTER_KS, Constants.Shooter.SHOOTER_KV);
    }

    public Shooter(HardwareMap hMap, String shooter) {
        shooterMotor = new MotorEx(hMap, shooter, MotorEx.GoBILDA.RPM_435);
        shooterMotor.setVeloCoefficients(
                Constants.Shooter.SHOOTER_KP,
                Constants.Shooter.SHOOTER_KI,
                Constants.Shooter.SHOOTER_KD
        );
        shooterMotor.setFeedforwardCoefficients(Constants.Shooter.SHOOTER_KS, Constants.Shooter.SHOOTER_KV);
    }

    public void setPower(double power) {
        shooterMotor.setRunMode(MotorEx.RunMode.RawPower);
        shooterMotor.set(power);
    }

    public void setVelocity(double velocity) {
        shooterMotor.setRunMode(MotorEx.RunMode.VelocityControl);
        shooterMotor.setVelocity(velocity);
    }

    public double getVelocity() {
        return shooterMotor.getVelocity();
    }

}
