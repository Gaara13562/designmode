package t02_builder;

/**
 * 构建一个对象所需的子组件
 */
public interface AirShipBuilder {
	Rocket buildRocket();
	Orbit calculateOrbit();
}

class MyAirShipBuilder implements AirShipBuilder {

	@Override
	public Rocket buildRocket() {
		System.out.println("建造子组件 - 火箭");
		return new Rocket("长征5A");
	}

	@Override
	public Orbit calculateOrbit() {
		System.out.println("建造子组件 - 轨道");
		return new Orbit(12L);
	}
	
}