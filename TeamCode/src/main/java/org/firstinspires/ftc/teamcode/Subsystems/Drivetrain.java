package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Drivetrain extends SubsystemBase {
    private final MecanumDrive drive;

    private final double WHEEL_DIAMETER;

    public Drivetrain(MotorEx frontLeft, MotorEx frontRight, MotorEx backLeft, MotorEx backRight, final double diameter) {
        WHEEL_DIAMETER = diameter;
        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }

    public Drivetrain(HardwareMap hMap, String frontLeft, String frontRight, String backLeft,
                      String backRight, final double diameter) {
        this(new MotorEx(hMap, frontLeft), new MotorEx(hMap, frontRight), new MotorEx(hMap, backLeft), new MotorEx(hMap, backRight), diameter);
    }

    public void driveRobotCentric(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public void driveFieldCentric(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle) {
        drive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, gyroAngle);
    }
}
