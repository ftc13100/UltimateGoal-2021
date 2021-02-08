package org.firstinspires.ftc.teamcode.OpModes.teleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.teamcode.subsystems.StackHeightDetectorSubsystem;

@TeleOp(name = "Stack Height")
public class StackHeightDetectorTest extends CommandOpMode {
    private AnalogInput bottomSensor;
    private AnalogInput topSensor;
    private StackHeightDetectorSubsystem SHD;
    @Override
    public void initialize() {
        this.bottomSensor = hardwareMap.analogInput.get("bottomSensor");
        this.topSensor = hardwareMap.analogInput.get("topSensor");
        this.SHD = new StackHeightDetectorSubsystem(bottomSensor, topSensor, telemetry);
    }
}
