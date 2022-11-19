package castle;

import java.util.Scanner;
import java.util.Random;

//доствка грузів між королівствами

public class Main {

	public static void main(String[] args) {

		Economics.eco = Atreides.ecoA + Lannister.ecoL;

		// ввести кількість грузу і дізнатись курс відносно кредитів
		Scanner scA = new Scanner(System.in);
		System.out.println("enter the amount of spice:  (from 1 to 300)");

		Atreides.spice = scA.nextDouble();

		if (Atreides.spice > 300 || Atreides.spice <= 0) {
			System.out.println("recources error!");
		} else {
			System.out.println("amount of spice: " + Atreides.spice);
		

		double sCurrency = Atreides.spice / Economics.eco;
		System.out.println("spice currency: " + sCurrency + "credits");

		Scanner scL = new Scanner(System.in);
		System.out.println("enter the amount of gold:  (from 400 to 1000)");

		Lannister.gold = scL.nextDouble();

		if (Lannister.gold > 1000 || Lannister.gold <= 399) {
			System.out.println("recources error!");
		} else {
			System.out.println("amount of gold: " + Lannister.gold);
		

		double gCurrency = Lannister.gold / Economics.eco;
		System.out.println("gold currency: " + gCurrency + "credits");
		// дізнатись дохід обох королівств
		double aIncome = Atreides.spice * sCurrency;
		double lIncome = Lannister.gold * sCurrency;
		double aSpend = lIncome;
		double lSpend = aIncome;

		Atreides.aTotal = Atreides.ecoA + aIncome - aSpend;
		Lannister.lTotal = Lannister.ecoL + lIncome - lSpend;

		System.out.println("Atreides income: " + aIncome);
		System.out.println("Atreides spending: " + aSpend);
		System.out.println("Atreides total: " + Atreides.aTotal);
		System.out.println("Lannister income: " + lIncome);
		System.out.println("Lannister spending: " + lSpend);
		System.out.println("Lannister total: " + Lannister.lTotal);

		Atreides.spiceWeight = Atreides.spice / 2;
		Lannister.goldWeight = Lannister.gold / 10;

		Messengers mes1 = new Messengers();
		Messengers mes2 = new Messengers();
		Messengers mes3 = new Messengers();
		
		Dragon dr1 = new Dragon();
		dr1.name = "Jegermeister";
		dr1.random = new Random();
		boolean possibility = dr1.random.nextBoolean();
		
		System.out.println("dragon possibility: " + possibility);
		
		
		// дані про посиланців і дракона
		if(possibility == false) {
			mes1.name = "Ingvar";
			mes1.house = Atreides.name;

			if (Lannister.goldWeight > 140) {
				System.out.println(mes1.name + " doesn't have enough power!\nSpice not delivered!");
			} else {
				mes1.power = 140;
				mes1.speed = Math.ceil(45 - mes1.power / Atreides.spiceWeight);
				mes1.delivery_time = Math.ceil(Atreides.distance_lan / mes1.speed);
			}

			mes2.name = "Peter";
			mes2.house = Lannister.name;
			if (Lannister.goldWeight > 90) {
				System.out.println(mes2.name + " doesn't have enough power!\nGold not delivered!"); 
			} else {
				mes2.power = 90;
				mes2.speed = Math.ceil(40 - mes2.power / Atreides.spiceWeight);
				mes2.delivery_time = Math.ceil(Lannister.distance_atr / mes2.speed);
			}

			System.out.println(mes1);
			System.out.println(mes2);
		}
		else {
			System.out.println("there is a dragon: " + dr1.name + "on the way! all messengers are dead(");
		
		}

	}
		}
	}

}
