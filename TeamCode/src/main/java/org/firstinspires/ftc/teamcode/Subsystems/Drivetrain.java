package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drivebase.MecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.MotorEx;


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
}
