
package com.sankalp.knapsack;

import java.util.Scanner;

public class Knapsack {
	
	private double weight[];
	private double profit[];
	private double ratio[];
	private double W;
	
	public static void main(String[] args) {
		Knapsack s = new Knapsack();
		s.calculate();
	}
	Knapsack() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();
		
		weight = new double[n];
		profit = new double[n];
		ratio = new double[n];
		
		System.out.println("Enter " + n + " weights");
		for(int i=0; i<n; i++)
			weight[i] = sc.nextDouble();
		
		System.out.println("Enter " + n + " profits");
		for(int i=0; i<n; i++)
			profit[i] = sc.nextDouble();
		
		System.out.println("Enter the weight of Knapsack Baggage");
		W = sc.nextDouble();
		
		for(int i=0; i<n; i++)
			ratio[i] = profit[i]/weight[i];
		
		sc.close();
	}
	
	public int maxRatio() {
		double highest = 0;
		int index = -1;
		for(int i=0; i<ratio.length; i++) {
			if(ratio[i] > highest) {
				highest = ratio[i];
				index = i;
			}
		}
		return index;
	}
	
	public void calculate() {
		double currentWeight = 0;
		double currentProfit = 0;
		
		while(currentWeight < W) {
			int indexMaxProfit = maxRatio();
			
			if(indexMaxProfit == -1){
				System.out.println("here");
				System.out.println("No items left! ");
				break;
			}
			if((currentWeight + weight[indexMaxProfit]) <= W) {
				System.out.println("here there");

				currentWeight += weight[indexMaxProfit];
				currentProfit += profit[indexMaxProfit];
				ratio[indexMaxProfit] = 0;
			}
			else {
				currentProfit += (ratio[indexMaxProfit]*(W - currentWeight));
				currentWeight += ((W - currentWeight));
				break;
			}
		}

		System.out.println("The maximum benefit: " + currentProfit);
		
		
	}
	

}
