package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class WobbleGrabberSubsystem extends SubsystemBase {
    private Servo grabber;
    private Servo lifter;
    public WobbleGrabberSubsystem(Servo grabber, Servo lifter){
        this.grabber = grabber;
        this.lifter = lifter;
    }
    public void grab(){
        this.grabber.setPosition(.1);
    }
    public void release(){
        this.grabber.setPosition(.75);
    }
    public void lift(){
        this.lifter.setPosition(.9);
    }
    public void lower(){
        this.lifter.setPosition(.1);
    }
    public void goToMid(){//for endgame use, lowers wobble goal over wall
        this.lifter.setPosition(.5);
    }
}
