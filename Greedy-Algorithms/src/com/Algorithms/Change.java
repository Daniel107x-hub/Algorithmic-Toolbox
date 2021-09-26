package com.Algorithms;

public class Change {
    private static final int[] coins=new int[]{10,5,1};

    private static int getArraySum(int[] array){
        int sum=0;
        for(int element:array){
            sum+=element;
        }
        return sum;
    }

    public static int getChange(int number){
        int[] cantidades=new int[]{0,0,0};
        for(int i=0;i<coins.length;i++){
            cantidades[i]=Math.floorDiv(number,coins[i]);
            number=number%coins[i];
        }
        return getArraySum(cantidades);
    }

    public static void testGetChange(){
        int result=getChange(2);
        if(result!=2){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
        result=getChange(28);
        if(result!=6){
            System.out.println("Error: "+result);
        }
        System.out.println("OK");
    }
}
