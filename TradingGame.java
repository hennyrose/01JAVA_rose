import java.util.*;

public class TradingGame {
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

			int house1ResourceType = rand.nextInt(4) + 1;
			int house1Resource = rand.nextInt(250) + 1;

			System.out.println("Do you want to trade with another house? (y/n)");
			String tradeAnswer = scanner.nextLine();

			if (tradeAnswer.equalsIgnoreCase("y")) {
				System.out.println("Which house do you want to trade with? (1/2/3)");
				int house2Index = scanner.nextInt();
				scanner.nextLine();
				if (Arrays.binarySearch(houseKeys, house2Index) < 0) {
					System.out.println("Invalid house number, try again.");
					continue;
				}

				System.out.println("Which resource do you want to trade? (money/spice/iron/wood/food)");
				String resourceType = scanner.nextLine();

				if (!atreides.containsKey(resourceType)) {
					System.out.println("Invalid resource type, try again.");
					continue;
				}

				System.out.println("How much of this resource do you want to trade?");
				int resourceAmount = scanner.nextInt();
				scanner.nextLine();

				int atreidesResourceAmount = atreides.get(resourceType);
				int atreidesMoney = atreides.get("money");
				int house2ResourceAmount = 0;
				int house2Money = 0;
				Map<String, Integer> house2Resources = null;

				if (house2Index == 1) {
					house2Resources = atreides;
				} else if (house2Index == 2) {
					house2Resources = harkonnen;
				} else if (house2Index == 3) {
					house2Resources = ferrari;
				} else if (house2Index == 4) {
					house2Resources = emperor;
				}

				if (resourceType.equals("money")) {
					if (atreidesMoney >= resourceAmount) {
						atreides.put("money", atreidesMoney - resourceAmount);
						house2Resources.put("money", house2Resources.get("money") + resourceAmount);
						System.out.println("Trade successful!");
					} else {
						System.out.println("Not enough money to make the trade.");
					}
				} else {
					if (atreidesResourceAmount >= resourceAmount) {
						int house2ResourceAmount2 = house2Resources.get(resourceType);
						int atreidesMoney2 = atreides.get("money");
						int house2Money2 = house2Resources.get("money");
						int resourcePrice = rand.nextInt(50) + 1;
						int totalCost = resourceAmount * resourcePrice;

						if (atreidesMoney2 >= totalCost) {
							atreides.put(resourceType, atreidesResourceAmount - resourceAmount);
							house2Resources.put(resourceType, house2ResourceAmount2 + resourceAmount);
							atreides.put("money", atreidesMoney2 - totalCost);
							house2Resources.put("money", house2Money2 + totalCost);
							System.out.println("Trade successful!");
						} else {
							System.out.println("Not enough money to make the trade.");
						}
					} else {
						System.out.println("Not enough resources to make the trade.");
					}
				}
			} else {
				System.out.println("Goodbye!");
				break;
			}
		}
	}
}
