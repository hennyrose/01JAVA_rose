public class Main {

	public static void main(String[] args) {
		Network net = new Network(10);
		Phone iphone1 = new Phone("0994447557");
		Phone iphone2 = new Phone("0994447558");
		Phone iphone3 = new Phone("0994447559");
		
		iphone1.register(net);
		iphone2.register(net);
		iphone3.register(net);
		
		iphone1.call("0994447559");
		iphone2.call("0994447557");
		iphone3.call("0994447552");

	}
}
