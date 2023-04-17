import java.util.*;
import javax.swing.*;

public class TradingGameGUI {
	private static Map<String, Integer> atreides = new HashMap<String, Integer>();
	private static Map<String, Integer> harkonnen = new HashMap<String, Integer>();
	private static Map<String, Integer> ferrari = new HashMap<String, Integer>();
	private static Map<String, Integer> emperor = new HashMap<String, Integer>();
	private static Map<Integer, String> cMap = new HashMap<Integer, String>();
	private static Map<Integer, String> rMap = new HashMap<Integer, String>();
	private static Scanner scanner = new Scanner(System.in);
	private static Random rand = new Random();

	private static JLabel resourcesLabel;
	private static JLabel housesLabel;
	private static JLabel dealsLabel;
	private static JFrame frame;
	private static JPanel panel;
	private static JButton house2Button;
	private static JButton house3Button;
	private static JButton house4Button;
	private static JTextArea console;

	public static void main(String[] args) {
		atreides.put("money", 1000);
		atreides.put("spice", 100);
		atreides.put("iron", 50);
		atreides.put("wood", 200);
		atreides.put("food", 150);
		harkonnen.put("money", 1000);
		harkonnen.put("spice", 100);
		harkonnen.put("iron", 50);
		harkonnen.put("wood", 200);
		harkonnen.put("food", 150);
		ferrari.put("money", 1000);
		ferrari.put("spice", 100);
		ferrari.put("iron", 50);
		ferrari.put("wood", 200);
		ferrari.put("food", 150);
		emperor.put("money", 1000);
		emperor.put("spice", 100);
		emperor.put("iron", 50);
		emperor.put("wood", 200);
		emperor.put("food", 150);

		cMap.put(1, "House Atreides");
		cMap.put(2, "House Harkonnen");
		cMap.put(3, "House Ferrari");
		cMap.put(4, "Emperor");

		rMap.put(1, "(1) House Atreides MONEY [" + atreides.get("money") + "]");
		rMap.put(2, "(2) House Harkonnen MONEY [" + harkonnen.get("money") + "]");
		rMap.put(3, "(3) House Ferrari MONEY [" + ferrari.get("money") + "]");
		rMap.put(4, "(4) Emperor MONEY [" + emperor.get("money") + "]");

		frame = new JFrame("Trading Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();

		resourcesLabel = new JLabel();
		resourcesLabel.setText("Resources:");
		panel.add(resourcesLabel);

		housesLabel = new JLabel();
		housesLabel.setText("Houses:");
		panel.add(housesLabel);

		dealsLabel = new JLabel();
		panel.add(dealsLabel);

		house2Button = new JButton("Trade with House Harkonnen");
		house2Button.addActionListener(e -> {
			tradeWithHouse(2);
		});
		panel.add(house2Button);

		house3Button = new JButton("Trade with House Ferrari");
		house3Button = new JButton("Trade with House Ferrari");
		house3Button.addActionListener(e -> {
			tradeWithHouse(3);
		});
		panel.add(house3Button);
		house4Button = new JButton("Trade with Emperor");
		house4Button.addActionListener(e -> {
			tradeWithHouse(4);
		});
		panel.add(house4Button);

		console = new JTextArea(10, 40);
		console.setEditable(false);
		panel.add(console);

		updateLabels();

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	private static void updateLabels() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		for (Map.Entry<String, Integer> entry : atreides.entrySet()) {
			sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
		}
		sb.append("</html>");
		resourcesLabel.setText(sb.toString());

		StringBuilder sb2 = new StringBuilder();
		sb2.append("<html>");
		for (Map.Entry<Integer, String> entry : cMap.entrySet()) {
			sb2.append(entry.getKey()).append(". ").append(entry.getValue()).append("<br>");
		}
		sb2.append("</html>");
		housesLabel.setText(sb2.toString());
	}

	private static void tradeWithHouse(int house) {
		int playerMoney = atreides.get("money");
		int playerSpice = atreides.get("spice");
		int playerIron = atreides.get("iron");
		int playerWood = atreides.get("wood");
		int playerFood = atreides.get("food");

		int houseMoney;
		int houseSpice;
		int houseIron;
		int houseWood;
		int houseFood;

		if (house == 2) {
			houseMoney = harkonnen.get("money");
			houseSpice = harkonnen.get("spice");
			houseIron = harkonnen.get("iron");
			houseWood = harkonnen.get("wood");
			houseFood = harkonnen.get("food");
		} else if (house == 3) {
			houseMoney = ferrari.get("money");
			houseSpice = ferrari.get("spice");
			houseIron = ferrari.get("iron");
			houseWood = ferrari.get("wood");
			houseFood = ferrari.get("food");
		} else {
			houseMoney = emperor.get("money");
			houseSpice = emperor.get("spice");
			houseIron = emperor.get("iron");
			houseWood = emperor.get("wood");
			houseFood = emperor.get("food");
		}

		String tradeItem = (String) JOptionPane.showInputDialog(frame,
				"What do you want to trade?\nMoney: " + playerMoney + "\nSpice: " + playerSpice + "\nIron: "
						+ playerIron + "\nWood: " + playerWood + "\nFood: " + playerFood,
				"Trade", JOptionPane.PLAIN_MESSAGE, null, new String[] { "Money", "Spice", "Iron", "Wood", "Food" },
				"Money");

		if (tradeItem != null) {
			int amount = Integer.parseInt(JOptionPane.showInputDialog(frame, "How much do you want to trade?", "Trade",
					JOptionPane.PLAIN_MESSAGE));

			if (tradeItem.equals("Money")) {
				if (playerMoney < amount) {
					console.append("You don't have enough money to make that trade.\n");
					return;
				}
				playerMoney -= amount;
				houseMoney += amount;
				atreides.put("money", playerMoney);
				if (house == 2) {
					harkonnen.put("money", houseMoney);
				} else if (house == 3) {
					ferrari.put("money", houseMoney);
				} else {
					emperor.put("money", houseMoney);
				}
			} else if (tradeItem.equals("Spice")) {
				if (playerSpice < amount) {
					console.append("You don't have enough spice to make that trade.\n");
					return;
				}
				playerSpice -= amount;
				houseSpice += amount;
				atreides.put("spice", playerSpice);
				if (house == 2) {
					harkonnen.put("spice", houseSpice);
				} else if (house == 3) {
					ferrari.put("spice", houseSpice);
				} else {
					emperor.put("spice", houseSpice);
				}
			} else if (tradeItem.equals("Iron")) {
				if (playerIron < amount) {
					console.append("You don't have enough iron to make that trade.\n");
					return;
				}
				playerIron -= amount;
				houseIron += amount;
				atreides.put("iron", playerIron);
				if (house == 2) {
					harkonnen.put("iron", houseIron);
				} else if (house == 3) {
					ferrari.put("iron", houseIron);
				} else {
					emperor.put("iron", houseIron);
				}
			} else if (tradeItem.equals("Wood")) {
				if (playerWood < amount) {
					console.append("You don't have enough wood to make that trade.\n");
					return;
				}
				playerWood -= amount;
				houseWood += amount;
				atreides.put("wood", playerWood);
				if (house == 2) {
					harkonnen.put("wood", houseWood);
				} else if (house == 3) {
					ferrari.put("wood", houseWood);
				} else {
					emperor.put("wood", houseWood);
				}
			} else if (tradeItem.equals("Food")) {
				if (playerFood < amount) {
					console.append("You don't have enough food to make that trade.\n");
					return;
				}
				playerFood -= amount;
				houseFood += amount;
				atreides.put("food", playerFood);
				if (house == 2) {
					harkonnen.put("food", houseFood);
				} else if (house == 3) {
					ferrari.put("food", houseFood);
				} else {
					emperor.put("food", houseFood);
				}
			}
			console.append("You traded " + amount + " " + tradeItem + " with House " + cMap.get(house) + ".\n");
			updateLabels();
		}
	}
}
