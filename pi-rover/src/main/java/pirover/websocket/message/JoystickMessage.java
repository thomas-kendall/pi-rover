package pirover.websocket.message;

public class JoystickMessage {
	private String joystick;
	private double angle;
	private double magnitude;

	public double getAngle() {
		return angle;
	}

	public String getJoystick() {
		return joystick;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public boolean isLeft() {
		return "left".equals(getJoystick());
	}

	public boolean isRight() {
		return "right".equals(getJoystick());
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setJoystick(String joystick) {
		this.joystick = joystick;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	@Override
	public String toString() {
		return JoystickMessageMarshaller.toJSON(this);
	}
}
