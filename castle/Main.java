package castle;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Economics.eco = Atreides.ecoA + Lannister.ecoL;
		
		Scanner scA = new Scanner(System.in);
		System.out.println("enter the amount of spice:  (from 1 to 300)");
		
		Atreides.spice = scA.nextDouble();
		
		if ( Atreides.spice > 300 || Atreides.spice <= 0) {
			System.out.println("recources error!");
		}
		else {
		System.out.println("amount of spice: " + Atreides.spice);
		}
		
		double sCurrency = Atreides.spice / Economics.eco;
		System.out.println("spice currency: " + sCurrency);
		
		Scanner scL = new Scanner(System.in);
		System.out.println("enter the amount of gold:  (from 400 to 1000)");
		
		Lannister.gold = scL.nextDouble();
		
		if ( Lannister.gold > 1000 || Lannister.gold <= 399) {
			System.out.println("recources error!");
		}
		else {
		System.out.println("amount of gold: " + Lannister.gold);
		}
		
		double gCurrency = Lannister.gold / Economics.eco;
		System.out.println("gold currency: " + gCurrency);
		
		double aIncome = Atreides.spice * sCurrency;
		double lIncome = Lannister.gold * sCurrency;
		double aSpend = lIncome;
		double lSpend = aIncome;
		
		Atreides.aTotal = Atreides.ecoA + aIncome - aSpend;
		Lannister.lTotal = Lannister.ecoL + lIncome - lSpend;
		
		System.out.println("Atreides total: " + Atreides.aTotal);
		System.out.println("Lannister total: " + Lannister.lTotal);
		
		Atreides.spiceWeight = Atreides.spice / 2;
		Lannister.goldWeight = Lannister.gold / 10;
		
		
		Messengers mes1 = new Messengers();
		Messengers mes2 = new Messengers();
		
		mes1.name = "Ingvar";
		mes1.house = Atreides.name;
		
		if (Lannister.goldWeight > 150) {
			System.out.println(mes2.name + " has no enough power!\nSpice not delivered!");
		}
		else {
			mes1.power = 150;
			mes1.speed = Math.ceil(45 - mes1.power / Atreides.spiceWeight) ;
			mes1.delivery_time = Math.ceil(Atreides.distance_lan / mes1.speed);
		}
		
		mes2.name = "Peter";
		mes2.house = Lannister.name;
		mes2.speed = 40;
		if (Lannister.goldWeight > 80) {
			System.out.println(mes2.name + " has no enough power!\nGold not delivered!");
		}
		else {
			mes2.power = 80;
			mes2.delivery_time = Lannister.distance_atr / mes2.speed;
		}
		
		
		
		System.out.println(mes1);
		System.out.println(mes2);
		
	}

}
