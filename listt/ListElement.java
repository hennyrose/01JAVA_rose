package listt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListElement {
	List<String> list = new ArrayList<>();

	public List<String> addMetod(String name) {
		list.add(name);
		return list;
	}

	public List<String> remoteElement(String name) {
		list.remove(0);
		list.remove(0);
		list.remove(list.size() - 1);
		return list;
	}
}
