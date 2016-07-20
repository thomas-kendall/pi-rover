package pirover.model;

public class Cartesian {
	public double x;
	public double y;

	public Cartesian() {
		x = 0.0;
		y = 0.0;
	}

	public Cartesian(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector toVector() {
		double angle = Math.atan2(y, x);
		double magnitude = Math.sqrt(x * x + y * y);
		return new Vector(angle, magnitude);
	}
}
