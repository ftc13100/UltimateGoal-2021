package org.firstinspires.ftc.teamcode.config;

public class Constants {
    public static class Shooter {
        // feedforward constants
        public static final double SHOOTER_KS = 0.0;
        public static final double SHOOTER_KV = 0.0;

        // feedback constants
        public static final double SHOOTER_KP = 0.0;
        public static final double SHOOTER_KI = 0.0;
        public static final double SHOOTER_KD = 0.0;
    }

    public static class Intake {
        public enum IntakeState {
            IN(1.0), STOP(0.0), OUT(-1.0);

            private double intakePower;

            public double getIntakePower() {
                return this.intakePower;
            }

            IntakeState(double power) {
                this.intakePower = power;
            }
        }
    }
}
