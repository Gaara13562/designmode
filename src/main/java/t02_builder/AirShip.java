package t02_builder;

public class AirShip {
	private Rocket rocket;
	private Orbit orbit;

	public AirShip() {
		super();
	}

	public AirShip(Rocket rocket, Orbit orbit) {
		super();
		this.rocket = rocket;
		this.orbit = orbit;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}

	public Orbit getOrbit() {
		return orbit;
	}

	public void setOrbit(Orbit orbit) {
		this.orbit = orbit;
	}

	public void launch() {
		System.out.println("用【" + rocket.getName() + "】型号的火箭将飞船送往周期为【" + orbit.getCycle() + "】小时的轨道上");
	}
}

class Rocket {
	private String name;

	public Rocket(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Orbit {
	private long cycle;

	public Orbit(long cycle) {
		this.cycle = cycle;
	}

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

}