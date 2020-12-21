package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.config.Constants;

public class Shooter extends SubsystemBase {
    private final MotorEx shooterMotor;

    public Shooter(MotorEx shooterMotor) {
        this.shooterMotor = shooterMotor;
        shooterMotor.setRunMode(Motor.RunMode.VelocityControl);
        shooterMotor.setVeloCoefficients(
                Constants.Shooter.SHOOTER_KP,
                Constants.Shooter.SHOOTER_KI,
                Constants.Shooter.SHOOTER_KD
        );
        shooterMotor.setFeedforwardCoefficients(
                Constants.Shooter.SHOOTER_KS,
                Constants.Shooter.SHOOTER_KV
        );
    }

    public Shooter(HardwareMap map, String shooterMotorName) {
        this.shooterMotor = new MotorEx(map, shooterMotorName, Motor.GoBILDA.BARE);
        shooterMotor.setRunMode(Motor.RunMode.VelocityControl);
        shooterMotor.setVeloCoefficients(
                Constants.Shooter.SHOOTER_KP,
                Constants.Shooter.SHOOTER_KI,
                Constants.Shooter.SHOOTER_KD
        );
        shooterMotor.setFeedforwardCoefficients(
                Constants.Shooter.SHOOTER_KS,
                Constants.Shooter.SHOOTER_KV
        );
    }

    public Shooter(HardwareMap map) {
        shooterMotor = new MotorEx(map, "shooter", Motor.GoBILDA.BARE);
        shooterMotor.setRunMode(Motor.RunMode.VelocityControl);
        shooterMotor.setVeloCoefficients(
                Constants.Shooter.SHOOTER_KP,
                Constants.Shooter.SHOOTER_KI,
                Constants.Shooter.SHOOTER_KD
        );
        shooterMotor.setFeedforwardCoefficients(
                Constants.Shooter.SHOOTER_KS,
                Constants.Shooter.SHOOTER_KV
        );
    }

    public void shoot() {
        shooterMotor.set(Constants.Shooter.SHOOT_VELOCITY);
    }

    public void stop() {
        shooterMotor.stopMotor();
    }
}
