package com.team254.frc2015.behavior;

import com.team254.frc2015.ElevatorSafety;

import java.util.Optional;

/**
 * Created by tombot on 2/26/15.
 */
public class RobotSetpoints {

    public enum IntakeAction {
        NONE, OPEN, CLOSE, NEUTRAL
    }

    public enum RollerAction {
        NONE, INTAKE, EXHAUST
    }

    public enum TopCarriagePivotAction {
        NONE, PIVOT_DOWN, PIVOT_UP
    }

    public enum TopCarriageClawAction {
        NONE, OPEN, CLOSE
    }

    public enum BottomCarriageFlapperAction {
        NONE, OPEN, CLOSE
    }

    public enum BottomCarriagePusherAction {
        NONE, EXTEND, RETRACT
    }

    public static final Optional<Double> m_nullopt = Optional.empty();

    public ElevatorSafety.Setpoints m_elevator_setpoints = new ElevatorSafety.Setpoints();
    public BottomCarriageFlapperAction flapper_action;
    public TopCarriageClawAction claw_action;
    public TopCarriagePivotAction pivot_action;
    public IntakeAction intake_action;
    public RollerAction roller_action;
    public Optional<Double> top_open_loop_jog;
    public Optional<Double> bottom_open_loop_jog;

    public void reset() {
        m_elevator_setpoints.bottom_setpoint = Optional.empty();
        m_elevator_setpoints.top_setpoint = Optional.empty();
        claw_action = TopCarriageClawAction.NONE;
        pivot_action = TopCarriagePivotAction.NONE;
        flapper_action =  BottomCarriageFlapperAction.NONE;
        intake_action = IntakeAction.NONE;
        roller_action = RollerAction.NONE;
        top_open_loop_jog = m_nullopt;
        bottom_open_loop_jog = m_nullopt;
    }
}
