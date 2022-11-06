package listt;

public class Main {
	public static void main(String[] args) {
		ListElement listElement = new ListElement();
		listElement.addMetod("Jay");
		listElement.addMetod("Future");
		listElement.addMetod("Carti");
		listElement.addMetod("Ye");
		listElement.addMetod("Drake");
		listElement.addMetod("Savage");
		listElement.addMetod("Gunna");
		listElement.addMetod("Thugger");
		listElement.addMetod("Migo");
		listElement.addMetod("Lamar");

		System.out.println(listElement.list);

		listElement.remoteElement(listElement.list.toString());

		System.out.println();
		System.out.println(listElement.list);
	}
}
