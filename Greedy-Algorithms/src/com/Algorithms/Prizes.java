package com.Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Prizes {
    private static ArrayList<Integer> getDifferentNumbers(int n){
        int i=1;
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        int difference=n;
        while(difference>=2*i+1){  // n/2
            difference-=i;
            numbers.add(i);
            i++;
        }
        numbers.add(difference);
        return numbers;
    }

    public static void testGetDifferentNumbers(){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        ArrayList<Integer> result=getDifferentNumbers(number);
        System.out.println(result.size());
        for(int element:result){
            System.out.print(element+" ");
        }

    }
}
