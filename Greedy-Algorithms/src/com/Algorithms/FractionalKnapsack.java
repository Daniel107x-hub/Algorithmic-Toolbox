package com.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double[] cost = new double[values.length];
        for(int i=0;i<values.length;i++){
            cost[i] = (double)values[i] / (double)weights[i];
        }
        merge_sort(cost, values, weights, 0, cost.length-1);
        double value = getMaximumValue(cost, values, weights, capacity, cost.length-1);
        return value;
    }

    private static double getMaximumValue(double[] cost, int[] values, int[] weights, int capacity, int index){
        if(capacity>=weights[index]){
            return values[index] + getMaximumValue(cost, values, weights, capacity-weights[index], index-1);
        }else{
            return Math.round(cost[index]*capacity*10000.0)/10000.0;
        }
    }

    private static void merge_sort(double[] cost, int[] values, int[] weights, int start, int end){
        if(start<end){
            int q = (start+end)/2;
            merge_sort(cost, values, weights, start, q);
            merge_sort(cost, values, weights, q+1, end);
            merge(cost, values, weights, start, q, end);
        }
    }

    private static void merge(double[] cost, int[] values, int[] weights, int start, int q, int end){
        int n1 = q-start+1;
        int n2 = end-q;
        double[] leftCost = new double[n1];
        double[] rightCost = new double[n2];
        int[] leftValue = new int[n1];
        int[] rightValue = new int[n2];
        int[] leftWeight = new int[n1];
        int[] rightWeight = new int[n2];
        for(int i=0;i<n1;i++){
            leftCost[i] = cost[start+i];
            leftValue[i] = values[start+i];
            leftWeight[i] = weights[start+i];
        }
        for(int i=0;i<n2;i++){
            rightCost[i] = cost[q+i+1];
            rightValue[i] = values[q+i+1];
            rightWeight[i] = weights[q+i+1];
        }
        int i=0;
        int j=0;
        int k=start;
        while(i<leftCost.length && j<rightCost.length){
            if(leftCost[i]<=rightCost[j]){
                cost[k] = leftCost[i];
                values[k] = leftValue[i];
                weights[k] = leftWeight[i];
                i++;
            }else{
                cost[k] = rightCost[j];
                values[k] = rightValue[j];
                weights[k] = rightWeight[j];
                j++;
            }
            k++;
        }
        if(i<leftCost.length){
            for(j=k;j<=end;j++){
                cost[j] = leftCost[i];
                values[j] = leftValue[i];
                weights[j] = leftWeight[i];
                i++;
            }
        }else if(j<rightCost.length){
            for(i=k;i<=end;i++){
                cost[i] = rightCost[j];
                values[i] = rightValue[j];
                weights[i] = rightWeight[j];
                j++;
            }
        }
    }



    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
