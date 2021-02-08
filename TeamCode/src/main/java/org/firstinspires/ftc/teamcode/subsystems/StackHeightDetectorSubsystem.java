package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.AnalogInput;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class StackHeightDetectorSubsystem extends SubsystemBase {
    private AnalogInput bottomSensor;
    private AnalogInput topSensor;
    private Telemetry telemetry;
    public enum Height {
        ZERO, ONE, FOUR
    }
    private double bottomThreshold;
    private double topThreshold;
    private final double threshMultiplier = 0.85;
    public StackHeightDetectorSubsystem(AnalogInput bottomSensor, AnalogInput topSensor, Telemetry telemetry){
        this.bottomSensor = bottomSensor;
        this.topSensor = topSensor;
        this.bottomThreshold = bottomSensor.getVoltage()*this.threshMultiplier;
        this.topThreshold = topSensor.getVoltage()*this.threshMultiplier;
        this.telemetry = telemetry;
    }
    public Height getHeight() {
        if(bottomSensor.getVoltage() < bottomThreshold && topSensor.getVoltage() < topThreshold){
            return Height.FOUR;
        }
        else if(bottomSensor.getVoltage() < bottomThreshold){
            return Height.ONE;
        }
        return Height.ZERO;
    }

    @Override
    public void periodic() {
        telemetry.addData("Bottom Sensor Voltage", bottomSensor.getVoltage());
        telemetry.addData("Top Sensor Voltage", topSensor.getVoltage());
        telemetry.update();
    }
}
