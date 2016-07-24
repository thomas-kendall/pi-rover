package pirover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rover implements Runnable {

	@Autowired
	private RoverService roverService;

	@Override
	public void run() {

		boolean looping = true;
		while (looping) {
			// Get speeds from service
			double velocityLeft = roverService.getVelocityLeft();
			double velocityRight = roverService.getVelocityRight();

			// TODO: send speeds to the motors
			System.out.println("Rover setting velocity: " + velocityLeft + ", " + velocityRight);

			// Sleep momentarily
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// On application close, Thread.sleep() throws this exception
				looping = false;
			}
		}
	}
}
