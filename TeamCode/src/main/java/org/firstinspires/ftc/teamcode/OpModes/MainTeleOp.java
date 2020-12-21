package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.ShootCommand;
import org.firstinspires.ftc.teamcode.config.ControlBoard;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@TeleOp(name="TeleOp")
public class MainTeleOp extends CommandOpMode {
    private Shooter shooter;

    private ControlBoard controlBoard;

    @Override
    public void initialize() {
        controlBoard = new ControlBoard(this);

        //initialize subsystems
        shooter = new Shooter(hardwareMap);

        //shooter commands
        controlBoard.getRunShooter().toggleWhenPressed(new ShootCommand(shooter));

        //register subsystems
        register(shooter);
    }
}
