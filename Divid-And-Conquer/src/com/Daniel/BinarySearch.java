package com.Daniel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    private static int search(List<Integer> N, int start, int end, int k){
        int mid=(start+end)/2;
        if(start>end){
            return -1;
        }
        if(N.get(mid)==k){
            return mid;
        }
        else if(N.get(mid)>k){
            return search(N,start,mid-1,k);
        }
        else{
            return search(N,mid+1,end,k);
        }
    }

    private static List<Integer> solveProblem(List<Integer> N,List<Integer> K){
        List<Integer> solution=new ArrayList<Integer>();
        for(int element:K){
            int index=search(N,0,N.size()-1,element);
            solution.add(index);
        }
        return solution;
    }

    public static void testBinarySearch(){
        List<Integer> N=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        int k=10;
        int result=search(N,0,N.size()-1,k);
        System.out.println(result);
    }

    public static void testOnInputList(){
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        String[] elements=line.split(" ");
        List<Integer> N=new ArrayList<Integer>();
        for(int i=0;i<Integer.parseInt(elements[0]);i++){
            N.add(Integer.parseInt(elements[i+1]));
        }
        line=scanner.nextLine();
        elements=line.split(" ");
        List<Integer> K=new ArrayList<Integer>();
        for(int i=0;i<Integer.parseInt(elements[0]);i++){
            K.add(Integer.parseInt(elements[i+1]));
        }
        List<Integer> solution=solveProblem(N,K);
        System.out.println("Solution: ");
        for(int element:solution){
            System.out.print(element+" ");
        }
    }
}
