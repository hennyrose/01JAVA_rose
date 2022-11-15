package bigboom;

import java.util.ArrayDeque;

//Шелдон, Леонард, Воловиц, Кутрапалли и Пенни стоят в очереди за «двойной колой».
//Как только человек выпьет такой колы, он раздваивается и оба становятся в конец очереди,
//чтобы выпить еще стаканчик. Напишите программу, которая выведет на экран состояние очереди
//в зависимости от того, сколько стаканов колы выдал аппарат с чудесным напитком.
//Например, если было выдано только два стакана, то очередь выглядит как:
//[Volovitc, Kutrapalli, Penny, Sheldon, Sheldon, Leonard, Leonard]

public class Main {
	public static void main(String[] args) {

		ArrayDeque<String> deque = new ArrayDeque<>();
		deque.push("Sheldon");
		deque.push("Leonard");
		deque.push("Volovitc");
		deque.push("Kutrapalli");
		deque.push("Penny");

		DoubleCola doubleCola = new DoubleCola();

		if (doubleCola.cola == 2) {
			String one = deque.removeFirst();
			String two = deque.removeFirst();
			deque.addLast(one);
			deque.addLast(one);
			deque.addLast(two);
			deque.addLast(two);
		}
		System.out.println(doubleCola.toString());
		System.out.println(deque);
	}
}