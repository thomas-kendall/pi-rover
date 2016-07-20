package pirover.service;

import org.springframework.stereotype.Service;

@Service
public class RoverService {

	private double velocityLeft = 0.0;
	private double velocityRight = 0.0;

	public double getVelocityLeft() {
		return velocityLeft;
	}

	public double getVelocityRight() {
		return velocityRight;
	}

	public void setVelocityLeft(double velocity) {
		velocityLeft = validateVelocity(velocity);
	}

	public void setVelocityRight(double velocity) {
		velocityRight = validateVelocity(velocity);
	}

	private double validateVelocity(double velocity) {
		if (velocity > 1.0) {
			velocity = 1.0;
		}
		if (velocity < -1.0) {
			velocity = -1.0;
		}
		return velocity;
	}
}
