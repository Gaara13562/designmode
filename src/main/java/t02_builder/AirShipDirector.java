package t02_builder;

/**
 * 组装一个对象的子组件，使之成为一个对象
 */
public interface AirShipDirector {
	AirShip directAirShip();
}

class MyAirShipDirector implements AirShipDirector {

	private AirShipBuilder builder;

	public MyAirShipDirector(AirShipBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public AirShip directAirShip() {
		Rocket rocket = builder.buildRocket();
		Orbit orbit = builder.calculateOrbit();
		return new AirShip(rocket, orbit);
	}

}