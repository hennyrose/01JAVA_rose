import java.util.*;

public class TradingGam {
	public static void main(String[] args) {
		Map<String, Integer> atreides = new HashMap<String, Integer>();
		atreides.put("money", 1000);
		atreides.put("spice", 100);
		atreides.put("iron", 50);
		atreides.put("wood", 200);
		atreides.put("food", 150);
		Map<String, Integer> harkonnen = new HashMap<String, Integer>();
		harkonnen.put("money", 1000);
		harkonnen.put("spice", 100);
		harkonnen.put("iron", 50);
		harkonnen.put("wood", 200);
		harkonnen.put("food", 150);

		Map<String, Integer> ferrari = new HashMap<String, Integer>();
		ferrari.put("money", 1000);
		ferrari.put("spice", 100);
		ferrari.put("iron", 50);
		ferrari.put("wood", 200);
		ferrari.put("food", 150);

		Map<String, Integer> emperor = new HashMap<String, Integer>();
		emperor.put("money", 1000);
		emperor.put("spice", 100);
		emperor.put("iron", 50);
		emperor.put("wood", 200);
		emperor.put("food", 150);

		Map<Integer, String> cMap = new HashMap<Integer, String>();
		cMap.put(1, "House Atreides");
		cMap.put(2, "House Harkonnen");
		cMap.put(3, "House Ferrari");
		cMap.put(4, "Emperor");

		Map<Integer, String> rMap = new HashMap<Integer, String>();
		rMap.put(1, "(1) House Atreides MONEY [" + atreides.get("money") + "]");
		rMap.put(2, "(2) House Harkonnen MONEY [" + harkonnen.get("money") + "]");
		rMap.put(3, "(3) House Ferrari MONEY [" + ferrari.get("money") + "]");
		rMap.put(4, "(4) Emperor MONEY [" + emperor.get("money") + "]");

		int[] houseKeys = { 1, 2, 3 };

		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		while (true) {

			System.out.println("Resources:");
			System.out.println("- Atreides' Money: " + atreides.get("money"));
			System.out.println("- Atreides' Spice: " + atreides.get("spice"));
			System.out.println("- Atreides' Iron: " + atreides.get("iron"));
			System.out.println("- Atreides' Wood: " + atreides.get("wood"));
			System.out.println("- Atreides' Food: " + atreides.get("food"));

			System.out.println("Houses:");
			System.out.println("- " + rMap.get(1));
			System.out.println("- " + rMap.get(2));
			System.out.println("- " + rMap.get(3));
			System.out.println("- " + rMap.get(4));
			System.out.println("Choose a house to trade with: ( 2; 3; 4 ) ");
			int houseChoice = scanner.nextInt();

			if (Arrays.stream(houseKeys).noneMatch(x -> x == houseChoice) || houseChoice == 1) {
				System.out.println("Invalid house choice, please choose again.");
				continue;
			}

			String selectedHouse = cMap.get(houseChoice);

			System.out.println("You have chosen to trade with " + selectedHouse);

			Map<String, Integer> selectedHouseResources;

			if (selectedHouse.equals("House Atreides")) {
				selectedHouseResources = atreides;
			} else if (selectedHouse.equals("House Harkonnen")) {
				selectedHouseResources = harkonnen;
			} else if (selectedHouse.equals("House Ferrari")) {
				selectedHouseResources = ferrari;
			} else {
				selectedHouseResources = emperor;
			}

			System.out.println("Selected House Resources:");
			System.out.println("- Money: " + selectedHouseResources.get("money"));
			System.out.println("- Spice: " + selectedHouseResources.get("spice"));
			System.out.println("- Iron: " + selectedHouseResources.get("iron"));
			System.out.println("- Wood: " + selectedHouseResources.get("wood"));
			System.out.println("- Food: " + selectedHouseResources.get("food"));

			System.out.println("What resource do you want to trade? ( money; spice; iron; wood; food )");

			String tradeResource = scanner.next();

			if (!selectedHouseResources.containsKey(tradeResource)) {
				System.out.println("Invalid resource choice, please choose again.");
				continue;
			}

			System.out.println("Enter the amount to trade:");

			int tradeAmount = scanner.nextInt();

			if (tradeAmount > selectedHouseResources.get(tradeResource)) {
				System.out.println("Selected house does not have enough of the selected resource.");
				continue;
			}

			System.out.println("Confirm trade of " + tradeAmount + " " + tradeResource + " for "
					+ (tradeAmount * rand.nextInt(50)) + " gold? (y/n)");

			String confirmTrade = scanner.next();

			if (confirmTrade.equals("y")) {

				selectedHouseResources.put(tradeResource, selectedHouseResources.get(tradeResource) - tradeAmount);
				atreides.put(tradeResource, atreides.get(tradeResource) + tradeAmount);
				atreides.put("money", atreides.get("money") - (tradeAmount * rand.nextInt(50)));

				System.out.println("Trade successful!");

			} else {
				System.out.println("Trade cancelled.");
			}

		}
	}
}
