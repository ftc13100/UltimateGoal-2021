package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class WobbleGrabberSubsystem extends SubsystemBase {

    private Servo grabber;
    private Servo lifter;
    private boolean grabbing = false;

    public WobbleGrabberSubsystem(Servo grabber, Servo lifter){
        this.grabber = grabber;
        this.lifter = lifter;
    }

    public void closeGrabber(){
        this.grabber.setPosition(.1);
        this.grabbing = true;
    }

    public boolean isGrabbing() {
        return this.grabbing;
    }

    public void openGrabber(){
        this.grabber.setPosition(.75);
        this.grabbing = false;
    }

    public void armUp(){
        this.lifter.setPosition(.9);
    }
    public void armDown(){
        this.lifter.setPosition(.1);
    }
    public void armHome(){//for endgame use, lowers wobble goal over wall
        this.lifter.setPosition(.5);
    }

    public void stop() {
        this.lifter.close();
    }
}
