package com.team254.frc2015.subsystems.controllers;

import com.team254.lib.trajectory.TrajectoryFollower;
import com.team254.lib.util.Controller;

public class ElevatorCarriagePositionController extends Controller {
	TrajectoryFollower m_follower;
	double m_goal;
	double m_error;

	public ElevatorCarriagePositionController(double kp, double ki, double kd,
			double kv, double ka, TrajectoryFollower.TrajectoryConfig config) {
		m_follower = new TrajectoryFollower();
		m_follower.configure(kp, ki, kd, kv, ka, config);
	}

	public void setGoal(TrajectoryFollower.TrajectorySetpoint current_state, double goal) {
		m_follower.setGoal(current_state, goal);
	}

	public double update(double position, double velocity) {
		m_error = m_goal - position;
		return m_follower.calculate(position, velocity);
	}
	
	public TrajectoryFollower.TrajectorySetpoint getSetpoint() {
		return m_follower.getCurrentSetpoint();
	}

	@Override
	public void reset() {
		m_error = 0;
		m_follower.setGoal(m_follower.getCurrentSetpoint(), m_goal);
	}

	@Override
	public boolean isOnTarget() {
		return m_follower.isFinishedTrajectory() && Math.abs(m_error) < 1.0;
	}

}
