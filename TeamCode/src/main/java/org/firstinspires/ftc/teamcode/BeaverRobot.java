package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.Robot;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.util.Safety;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class BeaverRobot extends Robot {
    private MecanumDrive drivetrain;
    private Intake intake;

    public BeaverRobot(MecanumDrive dt, Intake newIntake) {
        drivetrain = dt;
        intake = newIntake;
    }

    public BeaverRobot(Safety safetyMode, MecanumDrive dt, Intake newIntake) {
        this(dt, newIntake);
        setSafetyMode(safetyMode);
    }

}
