package atreidesgames;

import java.util.*;

public class TradingGame {
	public static void main(String[] args) {
		// Initialize resources and houses
		int money = 1000;
		int spice = 100;
		int iron = 50;
		int wood = 200;
		int food = 150;

		HashMap<Integer, String> cMap = new HashMap<Integer, String>();
		cMap.put(1, "House Atreides");
		cMap.put(2, "House Harkonnen");
		cMap.put(3, "House Ferrari");
		cMap.put(4, "Emperor");

		HashMap<Integer, String> rMap = new HashMap<Integer, String>();
		rMap.put(1, "(1) House Atreides MONEY [" + money + "]");
		rMap.put(2, "(2) House Harkonnen MONEY [" + money + "]");
		rMap.put(3, "(3) House Ferrari MONEY [" + money + "]");
		rMap.put(4, "(4) Emperor MONEY [" + money + "]");

		int[] houseKeys = { 1, 2, 3 };

		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		// Game loop
		while (true) {
			// Print resources and houses
			System.out.println("Resources:");
			System.out.println("- Money: " + money);
			System.out.println("- Spice: " + spice);
			System.out.println("- Iron: " + iron);
			System.out.println("- Wood: " + wood);
			System.out.println("- Food: " + food);

			System.out.println("Houses:");
			System.out.println("- " + rMap.get(1));
			System.out.println("- " + rMap.get(2));
			System.out.println("- " + rMap.get(3));
			System.out.println("- " + rMap.get(4));

			// House 1 trading with a random house
			int house1ResourceType = rand.nextInt(4) + 1;
			int house1Resource = rand.nextInt(250) + 1;

			System.out.println("Do you want to trade with another house? (y/n)");
			String tradeAnswer = scanner.nextLine();

			if (tradeAnswer.equalsIgnoreCase("y")) {
				System.out.println("Which house do you want to trade with? (1/2/3)");
				int house2Index = scanner.nextInt();
				scanner.nextLine();

				if (house2Index == 1) {
					System.out.println("You can't trade with yourself. Please choose another house.");
					continue;
				}

				String house2Name = cMap.get(house2Index);

				System.out.println("What resource do you want to offer?");
				System.out.println("1. Spice");
				System.out.println("2. Iron");
				System.out.println("3. Wood");
				System.out.println("4. Food");

				int resourceOffered = scanner.nextInt();
				scanner.nextLine();

				System.out.println("How much of this resource do you want to offer? (1-250)");
				int resourceOfferedAmount = scanner.nextInt();
				scanner.nextLine();

				// Perform the trade
				if (resourceOfferedAmount > 250) {
					System.out.println("You can't offer more than 250 units of a resource.");
					continue;
				}

				switch (resourceOffered) {
				case 1:
					if (spice < resourceOfferedAmount) {
						System.out.println("You don't have enough spice to offer.");
						continue;
					}
					rMap.put(1, "(1) House Atreides SPICE [" + (spice - resourceOfferedAmount) + "]");
					break;
				case 2:
					if (iron < resourceOfferedAmount) {
						System.out.println("You don't have enough iron to offer.");
						continue;
					}
					rMap.put(1, "(1) House Atreides IRON [" + (iron - resourceOfferedAmount) + "]");
					break;
				case 3:
					if (wood < resourceOfferedAmount) {
						System.out.println("You don't have enough wood to offer.");
						continue;
					}
					rMap.put(1, "(1) House Atreides WOOD [" + (wood - resourceOfferedAmount) + "]");
					break;
				case 4:
					if (food < resourceOfferedAmount) {
						System.out.println("You don't have enough food to offer.");
						continue;
					}
					rMap.put(1, "(1) House Atreides FOOD [" + (food - resourceOfferedAmount) + "]");
					break;
				default:
					System.out.println("Invalid resource type.");
					continue;
				}

				int house2ResourceType = rand.nextInt(4) + 1;
				int house2Resource = rand.nextInt(250) + 1;

				System.out.println(
						house2Name + " offers " + house2Resource + " units of " + rMap.get(house2ResourceType));

				System.out.println("Do you accept the offer? (y/n)");
				String tradeAcceptAnswer = scanner.nextLine();

				if (tradeAcceptAnswer.equalsIgnoreCase("y")) {
					switch (house2ResourceType) {
					case 1:
						if (money < house2Resource) {
							System.out.println("You don't have enough money to accept the offer.");
							continue;
						}
						money -= house2Resource;
						rMap.put(house2Index,
								"(" + house2Index + ") " + house2Name + " MONEY [" + (money + house2Resource) + "]");
						break;
					case 2:
						if (iron + house2Resource > 250) {
							System.out.println(
									"You can't accept the offer. You have reached the maximum amount of iron.");
							continue;
						}
						iron += house2Resource;
						rMap.put(house2Index, "(" + house2Index + ") " + house2Name + " IRON [" + iron + "]");
						break;
					case 3:
						if (wood + house2Resource > 250) {
							System.out.println(
									"You can't accept the offer. You have reached the maximum amount of wood.");
							continue;
						}
						wood += house2Resource;
						rMap.put(house2Index, "(" + house2Index + ") " + house2Name + " WOOD [" + wood + "]");
						break;
					case 4:
						if (food + house2Resource > 250) {
							System.out.println(
									"You can't accept the offer. You have reached the maximum amount of food.");
							continue;
						}
						food += house2Resource;
						rMap.put(house2Index, "(" + house2Index + ") " + house2Name + " FOOD [" + food + "]");
						break;
					default:
						System.out.println("Invalid resource type.");
						continue;
					}

					switch (house1ResourceType) {
					case 1:
						money += house1Resource;
						rMap.put(1, "(1) House Atreides MONEY [" + money + "]");
						break;
					case 2:
						if (iron < house1Resource) {
							System.out.println("You don't have enough iron to offer.");
							continue;
						}
						iron -= house1Resource;
						rMap.put(1, "(1) House Atreides IRON [" + iron + "]");
						break;
					case 3:
						if (wood < house1Resource) {
							System.out.println("You don't have enough wood to offer.");
							continue;
						}
						wood -= house1Resource;
						rMap.put(1, "(1) House Atreides WOOD [" + wood + "]");
						break;
					case 4:
						if (food < house1Resource) {
							System.out.println("You don't have enough food to offer.");
							continue;
						}
						food -= house1Resource;
						rMap.put(1, "(1) House Atreides FOOD [" + food + "]");
						break;
					default:
						System.out.println("Invalid resource type.");
						continue;
					}

					System.out.println("The trade has been successful!");

				} else {
					System.out.println("The trade has been rejected.");
				}
			}
		}
	}
}