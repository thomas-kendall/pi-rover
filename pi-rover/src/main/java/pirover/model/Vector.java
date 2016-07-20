package pirover.model;

public class Vector {
	public double angle;
	public double magnitude;

	public Vector() {
		angle = 0.0;
		magnitude = 0.0;
	}

	public Vector(double angle, double magnitude) {
		this.angle = angle;
		this.magnitude = magnitude;
	}

	public Cartesian toCartesian() {
		double x = magnitude * Math.cos(angle);
		double y = magnitude * Math.sin(angle);
		return new Cartesian(x, y);
	}
}
