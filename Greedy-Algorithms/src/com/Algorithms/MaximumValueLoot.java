package com.Algorithms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaximumValueLoot {
    public static double getMaximumValueOfLoot(ProblemInfo problemInfo){
        double W=problemInfo.W;
        ArrayList<int[]> items=problemInfo.items;
        double V=0.0;
        for (int[] item:items){
            if(W==0){
                return V;
            }
            double quantity=Math.min(W,item[1]);
            double currentValue=quantity*item[0]/item[1];
            V+=currentValue;
            W-=quantity;
        }
        return V;
    }

    private static ProblemInfo readData(){
        Scanner scanner=new Scanner(System.in);
        String info=scanner.nextLine();
        int itemsNumber=Integer.parseInt(info.split(" ")[0]);
        int W=Integer.parseInt(info.split(" ")[1]);
        ArrayList<int[]> items=new ArrayList<int[]>();
        for(int i=0;i<itemsNumber;i++){
            String itemInfoString=scanner.nextLine();
            int itemValue=Integer.parseInt(itemInfoString.split(" ")[0]);
            int itemWeight=Integer.parseInt(itemInfoString.split(" ")[1]);
            items.add(new int[]{itemValue,itemWeight});
        }
        ProblemInfo problemInfo=new ProblemInfo(W,items);
        return problemInfo;
    }

    private static class ProblemInfo{
        int W;
        ArrayList<int[]> items;
        public ProblemInfo(int W,ArrayList items){
            this.W=W;
            this.items=items;
        }
    }

    public static void testDataInput(){
        ProblemInfo problemInfo=readData();
    }

    public static void testMaximumLoot(){
        ProblemInfo problemInfo=readData();
        double result=getMaximumValueOfLoot(problemInfo);
        System.out.format("%.4f",result);
    }
}
