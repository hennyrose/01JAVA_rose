package castle;

public class Messengers {

	String name;
	String house;
	double speed;
	double power;
	double delivery_time;
	
	public String toString() {
		return "Messenger [house: " + house +
				", name: " + name +
				", speed: " + speed +
				" km/h, power: " + power +
				" delivery_time: " + delivery_time +
				" hrs" + "]";
	}
	
	
}
