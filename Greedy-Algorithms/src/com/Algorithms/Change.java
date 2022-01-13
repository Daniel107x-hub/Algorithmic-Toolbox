package com.Algorithms;

import java.util.Scanner;

public class Change {
    private static int[] coins = {1,5,10};

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(String.valueOf(getChange(m,coins.length-1)));
    }

    private static int getChange(int money, int coin){
        while(money>0){
            while(money<coins[coin]){
                coin--;
            }
            int takenCoins = money/coins[coin];
            return takenCoins+getChange(money-takenCoins*coins[coin], coin);
        }
        return 0;
    }

}
