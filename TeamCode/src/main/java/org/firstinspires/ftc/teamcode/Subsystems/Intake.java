package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.config.Constants.Intake.IntakeState;


public class Intake extends SubsystemBase {

    private final MotorEx intakeMotor;

    private IntakeState intakeState = IntakeState.STOP;

    public Intake(MotorEx intakeMotor) {
        this.intakeMotor = intakeMotor;
    }

    public Intake(HardwareMap map, String intakeMotor) {
        this.intakeMotor = new MotorEx(map, intakeMotor, MotorEx.GoBILDA.RPM_435);
    }

    public void setIntakeState(IntakeState state) {
        intakeMotor.set(state.getIntakePower());
        intakeState = state;
    }

}
